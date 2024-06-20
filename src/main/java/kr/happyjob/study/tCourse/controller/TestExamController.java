package kr.happyjob.study.tCourse.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import kr.happyjob.study.tCourse.model.CourseVO;
import kr.happyjob.study.tCourse.model.TestReslutSubmissionDTO;
import kr.happyjob.study.tCourse.service.TestExamService;

@Controller
@RequestMapping("/tCourse/")
public class TestExamController {

	@Autowired
    TestExamService testExamService;

    // 로거 설정
    private final Logger logger = LogManager.getLogger(this.getClass());

    // 로거를 위한 클래스 이름 가져오기
    private final String className = this.getClass().toString();

   
    @RequestMapping("examlist")
    @ResponseBody
    public Map<String, Object> examlist(Model model, @RequestParam Map<String, Object> paramMap,
            HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {

        logger.info("+ Start " + className + ".examlist");
        logger.info("   - paramMap : " + paramMap);

       

        // 현재 로그인한 강사의 loginID를 세션에서 가져와서 paramMap에 추가
        String loginID = (String) session.getAttribute("loginId");
        logger.info("   - loginID from session: " + loginID); // 세션에서 가져온 loginID 로그 출력

        // loginID가 null이면, 에러 로그 출력
        if (loginID == null) {
            logger.error("   - Error: loginID is null");
            throw new Exception("로그인이 필요합니다.");
        }
        paramMap.put("loginID", loginID); // loginID를 paramMap에 추가
        
        
        int currentPage = Integer
                .parseInt((String) (paramMap.get("currentPage") == null ? "1" : paramMap.get("currentPage")));
        int pageSize = Integer.parseInt((String) (paramMap.get("pageSize") == null ? "5" : paramMap.get("pageSize")));
        int startPoint = (currentPage - 1) * pageSize;

        paramMap.put("pageSize", pageSize);
        paramMap.put("startPoint", startPoint);

        Map<String, Object> returnMap = new HashMap<String, Object>();

        List<CourseVO> examList = testExamService.examlist(paramMap);
        int totalCnt = testExamService.countexamlist(paramMap);

        returnMap.put("examList", examList);
        returnMap.put("totalCnt", totalCnt);

       
        
        logger.info("+ End " + className + ".examlist");

        return returnMap;
    }

    @RequestMapping("getExamQuestions")
    @ResponseBody
    public Map<String, Object> getExamQuestions(@RequestParam Map<String, Object> paramMap) throws Exception {
        logger.info("+ Start " + className + ".getExamQuestions");
        logger.info("   - paramMap : " + paramMap);

        Map<String, Object> returnMap = new HashMap<String, Object>();

        if (paramMap.get("course_no") == null) {
            returnMap.put("success", false);
            returnMap.put("message", "course_no is missing");
            return returnMap;
        }

        List<TestReslutSubmissionDTO> questionCategories = testExamService.getExamQuestionsByCategory(paramMap);

        returnMap.put("questionCategories", questionCategories);
        returnMap.put("success", true);

        logger.info("+ End " + className + ".getExamQuestions");

        return returnMap;
    }
    
    
    @RequestMapping("updateExam")
    @ResponseBody
    public Map<String, Object> updateExam(@RequestBody Map<String, Object> payload) {
        Map<String, Object> result = new HashMap<>();
        try {
            int courseNo = (int) payload.get("courseNo");
            List<Map<String, Object>> questionsData = (List<Map<String, Object>>) payload.get("questions");
            List<Map<String, Object>> deletedQuestionsData = (List<Map<String, Object>>) payload.get("deletedQuestions");

            // 데이터 확인 로그 추가
            logger.info("Received questionsData: " + questionsData);
            logger.info("Received deletedQuestionsData: " + deletedQuestionsData);

            if (questionsData == null) {
                throw new NullPointerException("Questions data is missing.");
            }

            // deletedQuestionsData가 null인 경우 빈 배열로 초기화
            if (deletedQuestionsData == null) {
                deletedQuestionsData = new ArrayList<>();
            }

            ObjectMapper mapper = new ObjectMapper();
            List<TestReslutSubmissionDTO> questions = mapper.convertValue(questionsData, new TypeReference<List<TestReslutSubmissionDTO>>() {});
            List<TestReslutSubmissionDTO> deletedQuestions = mapper.convertValue(deletedQuestionsData, new TypeReference<List<TestReslutSubmissionDTO>>() {});

            // 시험 문제 업데이트
            for (TestReslutSubmissionDTO question : questions) {
                question.setCourse_no(courseNo);
                testExamService.updateExam(question);
            }

            // 삭제된 문제 처리
            for (TestReslutSubmissionDTO deletedQuestion : deletedQuestions) {
                testExamService.deleteExam(deletedQuestion.getTest_no());
            }

            result.put("success", true);
        } catch (NullPointerException e) {
            result.put("success", false);
            result.put("message", "Required data is missing: " + e.getMessage());
        } catch (Exception e) {
            result.put("success", false);
            result.put("message", e.getMessage());
            e.printStackTrace();
        }
        return result;
    }
    
    
    
    @RequestMapping("deleteExam")
    @ResponseBody
    public Map<String, Object> deleteExam(@RequestBody Map<String, Object> payload) {
        logger.info("+ Start " + className + ".deleteExam");
        logger.info("   - paramMap : " + payload);

        Map<String, Object> returnMap = new HashMap<String, Object>();

        try {
            int courseNo = (int) payload.get("courseNo");
            String testCategory = (String) payload.get("testCategory");

            Map<String, Object> paramMap = new HashMap<>();
            paramMap.put("course_no", courseNo);
            paramMap.put("test_category", testCategory);

            testExamService.deleteExamByCategory(paramMap);  // 새로운 메서드 호출
            returnMap.put("success", true);
            returnMap.put("message", "시험이 성공적으로 삭제되었습니다.");
        } catch (Exception e) {
            logger.error("Error deleting exam: ", e);
            returnMap.put("success", false);
            returnMap.put("message", "시험 삭제에 실패했습니다.");
        }

        logger.info("+ End " + className + ".deleteExam");
        return returnMap;
    }
    
    
    
    @RequestMapping("registerExam")
    @ResponseBody
    public Map<String, Object> registerExam(@RequestBody Map<String, Object> payload) {
        Map<String, Object> result = new HashMap<>();
        int courseNo = (int) payload.get("courseNo");
        String testCategory = (String) payload.get("testCategory");

        // 해당 강의에 이미 testCategory가 존재하는지 확인
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("course_no", courseNo);
        paramMap.put("test_category", testCategory);
        int categoryCount = 0;
        int currentCategoryCount = 0;

        try {
            categoryCount = testExamService.countCategoryByCourse(paramMap);
        } catch (Exception e) {
            result.put("success", false);
            result.put("message", "시험 카테고리 확인 중 오류가 발생했습니다.");
            return result;
        }

        if (categoryCount >= 1) {
            result.put("success", false);
            result.put("message", "해당 강의에는 이미 " + testCategory + " 가 존재합니다.");
            return result;
        }

        // 강의당 시험 카테고리 개수 제한 확인
        int categoryLimit = 3; // 최대 3개의 카테고리 허용
        try {
            List<String> testCategories = testExamService.getTestCategoriesByCourse(courseNo);
            currentCategoryCount = testCategories.size();
        } catch (Exception e) {
            result.put("success", false);
            result.put("message", "총 시험 개수 확인 중 오류가 발생했습니다.");
            return result;
        }

        if (currentCategoryCount >= categoryLimit) {
            result.put("success", false);
            result.put("message", "더이상 등록이 되지 않습니다. 등록된 시험을 삭제 후 등록하세요.");
            return result;
        }

        try {
            List<Map<String, Object>> questionsData = (List<Map<String, Object>>) payload.get("questions");
            ObjectMapper mapper = new ObjectMapper();
            List<TestReslutSubmissionDTO> questions = mapper.convertValue(questionsData, new TypeReference<List<TestReslutSubmissionDTO>>() {});

            for (TestReslutSubmissionDTO question : questions) {
                question.setCourse_no(courseNo);
                question.setTest_category(testCategory); // testCategory 설정
                testExamService.registerExam(question);
            }
            result.put("success", true);
        } catch (Exception e) {
            result.put("success", false);
            result.put("message", "시험 등록 중 오류가 발생했습니다.");
            e.printStackTrace();
        }
        return result;
    }
    
    
    
    
    @RequestMapping("getExamFixCategory")
    @ResponseBody
    public Map<String, Object> getExamFixCategory(@RequestParam Map<String, Object> paramMap) throws Exception {
        logger.info("+ Start " + className + ".getExamFixCategory");
        logger.info("   - paramMap : " + paramMap);

        Map<String, Object> returnMap = new HashMap<String, Object>();

        if (paramMap.get("course_no") == null || paramMap.get("test_category") == null) {
            returnMap.put("success", false);
            returnMap.put("message", "course_no or test_category is missing");
            return returnMap;
        }

        List<TestReslutSubmissionDTO> questionList = testExamService.getExamFixCategory(paramMap);

        returnMap.put("questionList", questionList);
        returnMap.put("success", true);

        logger.info("+ End " + className + ".getExamFixCategory");

        return returnMap;
    }
    
    
    
    
}