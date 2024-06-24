package kr.happyjob.study.tCourse.service;

import java.util.List;
import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.happyjob.study.tCourse.dao.TestResultDao;
import kr.happyjob.study.tCourse.model.CourseVO;
import kr.happyjob.study.tCourse.model.TestReslutSubmissionDTO;

@Service
public class TestResultServiceImpl implements TestResultService {
	
    @Autowired
    TestResultDao testResultDao;
    
    
	// 로거 설정
	private final Logger logger = LogManager.getLogger(this.getClass());

	// 로거를 위한 클래스 이름 가져오기
	private final String className = this.getClass().toString();

    @Override
    public List<CourseVO> getCourseList(Map<String, Object> paramMap) {
        return testResultDao.selectCourseList(paramMap);
    }

    @Override
    public int countCourseList(Map<String, Object> paramMap) {
        return testResultDao.countCourseList(paramMap);
    }
    
    @Override
    public List<TestReslutSubmissionDTO> getTestResults(Map<String, Object> paramMap) {
        return testResultDao.selectTestResults(paramMap);
    }
    
    @Override
    public List<TestReslutSubmissionDTO> getStudentTestDetails(Map<String, Object> paramMap) {
        return testResultDao.selectStudentTestDetails(paramMap);
    }
    
    // 통계 정보를 가져오는 메서드 추가
    @Override
    public TestReslutSubmissionDTO getTestStatistics(Map<String, Object> paramMap, String category) {
        paramMap.put("test_category", category);
        return testResultDao.selectTestStatistics(paramMap);
    }
    
    // 카테고리에 따른 시험 결과 조회 메서드 구현
    @Override
    public List<TestReslutSubmissionDTO> getTestResultsByCategory(Map<String, Object> paramMap, String category) {
      paramMap.put("test_category", category);
      logger.info("ParamMap for getTestResultsByCategory: " + paramMap);
      return testResultDao.selectTestResultsByCategory(paramMap);
    }
    
    
    
}
