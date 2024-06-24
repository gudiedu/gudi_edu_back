package kr.happyjob.study.tCourse.service;

import java.util.List;
import java.util.Map;

import kr.happyjob.study.tCourse.model.CourseVO;
import kr.happyjob.study.tCourse.model.TestReslutSubmissionDTO;

public interface TestResultService {

    // 강의 정보 조회 메서드
   public List<CourseVO> getCourseList(Map<String, Object> paramMap);
   
   public int countCourseList(Map<String, Object> paramMap);
   
   // 시험 결과 조회 메서드
   public List<TestReslutSubmissionDTO> getTestResults(Map<String, Object> paramMap);
   
   // 특정 학생의 상세 정보 조회 메서드
   public List<TestReslutSubmissionDTO> getStudentTestDetails(Map<String, Object> paramMap);
   
   // 통계 정보를 가져오는 메서드 추가
   public TestReslutSubmissionDTO getTestStatistics(Map<String, Object> paramMap, String category);
   
   // 카테고리에 따른 시험 결과 조회 메서드 추가
   public List<TestReslutSubmissionDTO> getTestResultsByCategory(Map<String, Object> paramMap, String category);
}
