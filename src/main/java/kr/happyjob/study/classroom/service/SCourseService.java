package kr.happyjob.study.classroom.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import kr.happyjob.study.classroom.dto.SCourseDto;
import kr.happyjob.study.classroom.model.SDayoffModel;

public interface SCourseService {
	
	/** 강의관리 : 학생이 수강하는 강의 목록 조회 */
	public List<SCourseDto> sStudentCourseInfo(Map<String, Object> paramMap) throws Exception;
	
	/** 강의관리 : 학생이 수강하는 강의 목록 갯수 조회 */
	public int totalCntCourse(Map<String, Object> paramMap) throws Exception;
	
	/** 강의관리 출결 : 학생이 수강하는 특정 강의 내용 조회 */
	public SCourseDto sStudentSelectedCourseInfo(Map<String, Object> paramMap) throws Exception;
	
	/** 강의관리 출결 : 학생 출결(출석한 횟수) */
	public int sAttendanceDays(Map<String, Object> paramMap) throws Exception;
	
	/** 강의관리 출결 : 학생 출결(결석한 횟수) */
	public int sAbsenceDays(Map<String, Object> paramMap) throws Exception;
	
	/** 강의관리 출결 : 학생 출결(지각, 결석한 것만) */
	public List<SCourseDto> sAttendanceNotes(Map<String, Object> paramMap) throws Exception;
	
	/** 강의관리 출결 : 공휴일 및 휴강일 */
	public List<SDayoffModel> sDayoffInfo(Map<String, Object> paramMap) throws Exception;
	
	/** 강의관리 수업만족도 : 수업만족도 질문 조회 */
	public List<SCourseDto> sSatisfactionQuestion(Map<String, Object> paramMap) throws Exception;
	
	/** 강의관리 수업만족도 : 수업만족도 보기 조회 */
	public List<SCourseDto> sSatisfactionAnswer(Map<String, Object> paramMap) throws Exception;
	
	/** 강의관리 수업만족도 : 수업만족도 응답 */
	public int sInsertSurvey(Map<String, Object> paramMap) throws Exception;
	
	/** 강의관리 수업만족도 : 수업만족도 응답 유무 */
	public int sSurveyComplete(Map<String, Object> paramMap) throws Exception;

	/** 강의관리: 특정 강의 정보 조회*/
	public List<SCourseDto> sCourseInfo(Map<String, Object> paramMap) throws Exception;
	
	/** 강의관리: 강의 세부 정보 조회*/
	public List<SCourseDto> sCourseDetail(Map<String, Object> paramMap) throws Exception;

	/** 수강신청: 수강신청 가능 목록 조회*/
	public List<SCourseDto> sEnrollList(Map<String, Object> paramMap) throws Exception;

	/** 수강신청: 중복확인하기*/
	public int checkEnrollment(Map<String, Object> paramMap) throws Exception;

	/** 수강신청: 수강신청하기*/
	public int sEnrollInsert(Map<String, Object> paramMap, HttpServletRequest request) throws Exception;

	/** 시험응시: 시험관련 목록 조회*/
	public List<SCourseDto> sTestList(Map<String, Object> paramMap) throws Exception;
	
	/** 시험응시: 시험 제출하기*/
	public int sTestSubmit(Map<String, Object> paramMap, HttpServletRequest request) throws Exception;

	/** 시험응시: 시험 문제 불러오기*/
	public List<SCourseDto> sCreateTest(Map<String, Object> paramMap) throws Exception;
	
	/** 시험응시: 시험 총점 계산해서 등록하기*/
	public int sTestCalculate(Map<String, Object> paramMap, HttpServletRequest request) throws Exception;

	/** 시험응시: 시험 제출 결과 불러오기*/
	public List<SCourseDto> sShowingTestResult(Map<String, Object> paramMap) throws Exception;

//	/** 수강신청: 현재 강좌의 수강신청한 학생 명수*/
//	public int currentEnrolled(Map<String, Object> paramMap) throws Exception;


	
}