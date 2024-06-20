package kr.happyjob.study.tCourse.dao;

import java.util.List;
import java.util.Map;

import kr.happyjob.study.tCourse.model.CourseVO;
import kr.happyjob.study.tCourse.model.TestReslutSubmissionDTO;

public interface TestResultDao {

	// 강의 정보 조회 메서드
	public List<CourseVO> selectCourseList(Map<String, Object> paramMap);

	public int countCourseList(Map<String, Object> paramMap);

	// 시험 결과 조회 메서드
	public List<TestReslutSubmissionDTO> selectTestResults(Map<String, Object> paramMap);

	// 시험 결과 조회 메서드
	public List<TestReslutSubmissionDTO> selectStudentTestDetails(Map<String, Object> paramMap);
	
	
	
	// 통계 정보를 가져오는 메서드 추가
	public TestReslutSubmissionDTO selectTestStatistics(Map<String, Object> paramMap);
	
}
