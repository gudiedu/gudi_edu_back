package kr.happyjob.study.tCourse.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.happyjob.study.tCourse.dao.TestExamDao;
import kr.happyjob.study.tCourse.model.CourseVO;
import kr.happyjob.study.tCourse.model.TestReslutSubmissionDTO;

@Service
public class TestExamServiceImpl implements TestExamService {

	@Autowired
	TestExamDao testExamDao;

	// 강의 목록을 조회하는 메서드
    @Override
    public List<CourseVO> examlist(Map<String, Object> paramMap) throws Exception {
        return testExamDao.examlist(paramMap);
    }

    // 전체 강의 수를 조회하는 메서드
    @Override
    public int countexamlist(Map<String, Object> paramMap) throws Exception {
        return testExamDao.countexamlist(paramMap);
    }

    // 새로운 시험 문제를 등록하는 메서드
    @Override
    public int registerExam(TestReslutSubmissionDTO testReslutSubmissionDTO) throws Exception {
        return testExamDao.registerExam(testReslutSubmissionDTO);
    }


    // 특정 시험의 전체 문제 수를 조회하는 메서드
    @Override
    public int countExamQuestions(Map<String, Object> paramMap) throws Exception {
        return testExamDao.countExamQuestions(paramMap);
    }

    // 기존 시험 문제를 업데이트하는 메서드
    @Override
    public int updateExam(TestReslutSubmissionDTO testReslutSubmissionDTO) throws Exception {
        return testExamDao.updateExam(testReslutSubmissionDTO);
    }

    // 시험 문제 삭제 메서드
    @Override
    public void deleteExam(int testNo) throws Exception {
        testExamDao.deleteExam(testNo);
    }
    
    // 시험 전체 삭제 메서드 추가
    @Override
    public void deleteExamByCategory(Map<String, Object> paramMap) throws Exception {
        testExamDao.deleteExamByCategory(paramMap);
    }
    
    
    
    // 특정 시험의 문제 목록을 조회하는 메서드
    @Override
    public List<TestReslutSubmissionDTO> getExamQuestions(Map<String, Object> paramMap) throws Exception {
    	return testExamDao.getExamQuestions(paramMap);
    }
    
    
    
    // 특정 강의의 시험 카테고리별 문제 개수를 조회하는 메서드 수정
    @Override
    public List<TestReslutSubmissionDTO> getExamQuestionsByCategory(Map<String, Object> paramMap) throws Exception {
        return testExamDao.getExamQuestionsByCategory(paramMap);
    }
    
    
    
    @Override
    public int countTotalExamsByCourse(int courseNo) throws Exception {
        return testExamDao.countTotalExamsByCourse(courseNo);
    }
    
    @Override
    public int countCategoryByCourse(Map<String, Object> paramMap) throws Exception {
        return testExamDao.countCategoryByCourse(paramMap);
    }
	
    
    @Override
    public List<TestReslutSubmissionDTO> getExamFixCategory(Map<String, Object> paramMap) throws Exception {
        return testExamDao.getExamFixCategory(paramMap);
    }

    
    
    
    @Override
    public List<String> getTestCategoriesByCourse(int courseNo) throws Exception {
        return testExamDao.getTestCategoriesByCourse(courseNo);
    }
    
}
