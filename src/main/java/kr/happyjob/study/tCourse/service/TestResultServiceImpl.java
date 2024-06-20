package kr.happyjob.study.tCourse.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.happyjob.study.tCourse.dao.TestResultDao;
import kr.happyjob.study.tCourse.model.CourseVO;
import kr.happyjob.study.tCourse.model.TestReslutSubmissionDTO;

@Service
public class TestResultServiceImpl implements TestResultService {
	
    @Autowired
    TestResultDao testResultDao;

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
    public TestReslutSubmissionDTO getTestStatistics(Map<String, Object> paramMap) {
        return testResultDao.selectTestStatistics(paramMap);
    }
}
