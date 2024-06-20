package kr.happyjob.study.tCourse.controller;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.happyjob.study.tCourse.model.CourseVO;
import kr.happyjob.study.tCourse.model.TestReslutSubmissionDTO;
import kr.happyjob.study.tCourse.service.TestResultService;

@Controller
@RequestMapping("/tCourse/")
public class TestResultController {

	@Autowired
	private TestResultService testResultService;

	// Set logger
	private final Logger logger = LogManager.getLogger(this.getClass());

	// Get class name for logger
	private final String className = this.getClass().toString();

	@RequestMapping("courseList")
	@ResponseBody
	public Map<String, Object> getCourseList(Model model, @RequestParam Map<String, Object> paramMap,
			HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {

		logger.info("+ Start " + className + ".courseList");
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
        
		
		
        int currentPage = Integer.parseInt((String) (paramMap.get("currentPage") == null ? "1" : paramMap.get("currentPage")));
        int pageSize = Integer.parseInt((String) (paramMap.get("pageSize") == null ? "5" : paramMap.get("pageSize")));
        int startPoint = (currentPage - 1) * pageSize;

        paramMap.put("pageSize", pageSize);
        paramMap.put("startPoint", startPoint);

        Map<String, Object> returnMap = new HashMap<>();
        List<CourseVO> courseList = testResultService.getCourseList(paramMap);
        int totalCnt = testResultService.countCourseList(paramMap);

        returnMap.put("courseList", courseList);
        returnMap.put("totalCnt", totalCnt);

        logger.info("End TestResultController.getCourseList");

        return returnMap;
	}
	
	
	@RequestMapping("testResults")
	@ResponseBody
	public Map<String, Object> getTestResults(Model model, @RequestParam Map<String, Object> paramMap,
	        HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {

	    logger.info("+ Start " + className + ".testResults");
	    logger.info("   - paramMap : " + paramMap);

	    Map<String, Object> returnMap = new HashMap<>();
	    List<TestReslutSubmissionDTO> testResults = testResultService.getTestResults(paramMap);

	    returnMap.put("testResults", testResults);

	    logger.info("End TestResultController.getTestResults");
	    logger.info("Return data: " + returnMap);

	    return returnMap;
	}
	
	
	

	@RequestMapping("studentTestDetails")
	@ResponseBody
	public Map<String, Object> getStudentTestDetails(Model model, @RequestParam Map<String, Object> paramMap,
	        HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {

	    logger.info("+ Start " + className + ".getStudentTestDetails");
	    logger.info("   - paramMap : " + paramMap);

	    Map<String, Object> returnMap = new HashMap<>();
	    List<TestReslutSubmissionDTO> studentTestDetails = testResultService.getStudentTestDetails(paramMap);
	    
	    // 학생 총점수 가져오기
	    int totalScore = studentTestDetails.isEmpty() ? 0 : studentTestDetails.get(0).getResult_score();
	    
	    returnMap.put("studentTestDetails", studentTestDetails);
	    returnMap.put("totalScore", totalScore);

	    logger.info("End " + className + ".getStudentTestDetails");
	    logger.info("Return data: " + returnMap);

	    return returnMap;
	}
	
	
	// 추가된 부분: 통계 정보를 가져오는 메서드
	@RequestMapping("testStatistics")
	@ResponseBody
	public Map<String, Object> getTestStatistics(Model model, @RequestParam Map<String, Object> paramMap,
	        HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {

	    logger.info("+ Start " + className + ".testStatistics");
	    logger.info("   - paramMap : " + paramMap);

	    Map<String, Object> returnMap = new HashMap<>();
	    TestReslutSubmissionDTO statistics = testResultService.getTestStatistics(paramMap);

	    returnMap.put("statistics", statistics);

	    logger.info("End TestResultController.getTestStatistics");
	    logger.info("Return data: " + returnMap);

	    return returnMap;
	}
	
	
	
	
}
