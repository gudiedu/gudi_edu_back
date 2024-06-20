package kr.happyjob.study.tCourse.service;

import java.util.List;
import java.util.Map;

import kr.happyjob.study.tCourse.model.CourseVO;
import kr.happyjob.study.tCourse.model.TestReslutSubmissionDTO;

public interface TestExamService {

	// 강의 목록을 조회하는 메서드
	public List<CourseVO> examlist(Map<String, Object> paramMap) throws Exception;

	// 전체 강의 수를 조회하는 메서드
	public int countexamlist(Map<String, Object> paramMap) throws Exception;

	// 기존 시험 문제를 업데이트하는 메서드
	public int updateExam(TestReslutSubmissionDTO testReslutSubmissionDTO) throws Exception;

	// 시험 문제 삭제 메서드
	public void deleteExam(int testNo) throws Exception;

	// 새로운 시험 전체 삭제 메서드 추가
	public void deleteExamByCategory(Map<String, Object> paramMap) throws Exception;

	// 특정 시험의 전체 문제 수를 조회하는 메서드
	public int countExamQuestions(Map<String, Object> paramMap) throws Exception;

	// 새로운 시험 문제를 등록하는 메서드
	public int registerExam(TestReslutSubmissionDTO testReslutSubmissionDTO) throws Exception;

	// 특정 강의의 시험 카테고리별 문제 개수를 조회하는 메서드 수정
	public List<TestReslutSubmissionDTO> getExamQuestionsByCategory(Map<String, Object> paramMap) throws Exception;

	// 특정 시험의 문제 목록을 조회하는 메서드
	public List<TestReslutSubmissionDTO> getExamQuestions(Map<String, Object> paramMap) throws Exception;

	// 특정 강의에 특정 시험 카테고리가 존재하는지 확인하는 메서드
	public int countCategoryByCourse(Map<String, Object> paramMap) throws Exception;

	// 특정 강의의 전체 시험 개수를 조회하는 메서드
	public int countTotalExamsByCourse(int courseNo) throws Exception;

	// 시험 카테고리에 따른 문제 목록 조회 메서드
	public List<TestReslutSubmissionDTO> getExamFixCategory(Map<String, Object> paramMap) throws Exception;

	public List<String> getTestCategoriesByCourse(int courseNo) throws Exception;

}
