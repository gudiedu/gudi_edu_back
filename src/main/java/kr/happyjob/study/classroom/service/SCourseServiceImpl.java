package kr.happyjob.study.classroom.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.happyjob.study.classroom.dao.SCourseDao;
import kr.happyjob.study.classroom.dto.SCourseDto;
import kr.happyjob.study.classroom.model.SDayoffModel;

@Service
public class SCourseServiceImpl implements SCourseService {

	@Autowired
	SCourseDao sCourseDao;
	
	/** 강의관리 : 학생이 수강하는 강의 목록 조회 */
	public List<SCourseDto> sStudentCourseInfo(Map<String, Object> paramMap) throws Exception {
		return sCourseDao.sStudentCourseInfo(paramMap);
	}
	
	/** 강의관리 : 학생이 수강하는 강의 목록 갯수 조회*/
	public int totalCntCourse(Map<String, Object> paramMap) throws Exception {
		return sCourseDao.totalCntCourse(paramMap);
	}
	
	/** 강의관리 출결 : 학생이 수강하는 특정 강의 내용 조회 */
	public SCourseDto sStudentSelectedCourseInfo(Map<String, Object> paramMap) throws Exception {
		return sCourseDao.sStudentSelectedCourseInfo(paramMap);
	}
	
	/** 강의관리 출결 : 학생 출결(출석한 횟수)*/
	public int sAttendanceDays(Map<String, Object> paramMap) throws Exception {
		return sCourseDao.sAttendanceDays(paramMap);
	}
	
	/** 강의관리 출결 : 학생 출결(결석한 횟수)*/
	public int sAbsenceDays(Map<String, Object> paramMap) throws Exception {
		return sCourseDao.sAbsenceDays(paramMap);
	}
	
	/** 강의관리 출결 : 학생 출결(지각, 결석한 것만) */
	public List<SCourseDto> sAttendanceNotes(Map<String, Object> paramMap) throws Exception {
		return sCourseDao.sAttendanceNotes(paramMap);
	}
	
	/** 강의관리 출결 : 공휴일 및 휴강일 */
	public List<SDayoffModel> sDayoffInfo(Map<String, Object> paramMap) throws Exception {
		return sCourseDao.sDayoffInfo(paramMap);
	}

	/**특정 강의 정보 조회*/
	public List<SCourseDto> sCourseInfo(Map<String, Object> paramMap) throws Exception {
		return sCourseDao.sCourseInfo(paramMap);
	}

	/**강의세부정보 조회*/
	public List<SCourseDto> sCourseDetail(Map<String, Object> paramMap) throws Exception {
		return sCourseDao.sCourseDetail(paramMap);
	}

	/** 수강신청: 수강신청 가능 목록 조회*/
	public List<SCourseDto> sEnrollList(Map<String, Object> paramMap) throws Exception {
		return sCourseDao.sEnrollList(paramMap);
	}
	
	/** 강의관리 수업만족도 : 수업만족도 질문 조회 */
	public List<SCourseDto> sSatisfactionQuestion(Map<String, Object> paramMap) throws Exception {
		return sCourseDao.sSatisfactionQuestion(paramMap);
	}
	
	/** 강의관리 수업만족도 : 수업만족도 보기 조회 */
	public List<SCourseDto> sSatisfactionAnswer(Map<String, Object> paramMap) throws Exception {
		return sCourseDao.sSatisfactionAnswer(paramMap);
	}
	
	/** 강의관리 수업만족도 : 수업만족도 응답*/
	public int sInsertSurvey(Map<String, Object> paramMap) throws Exception {
		return sCourseDao.sInsertSurvey(paramMap);
	}
	
	/** 강의관리 수업만족도 : 수업만족도 응답 유무*/
	public int sSurveyComplete(Map<String, Object> paramMap) throws Exception {
		return sCourseDao.sSurveyComplete(paramMap);
	}
	
	/** 수강신청: 중복확인하기*/
	public int checkEnrollment(Map<String, Object> paramMap) throws Exception{
		return sCourseDao.checkEnrollment(paramMap);
	}

	/** 수강신청: 수강신청하기*/
	public int sEnrollInsert(Map<String, Object> paramMap, HttpServletRequest request) throws Exception {
		return sCourseDao.sEnrollInsert(paramMap);
	}

	/** 시험응시: 시험강의목록조회하기*/
	public List<SCourseDto> sTestList(Map<String, Object> paramMap) throws Exception {
		return sCourseDao.sTestList(paramMap);
	}
	
	/** 시험응시: 시험제출하기*/
	public int sTestSubmit(Map<String, Object> paramMap, HttpServletRequest request) throws Exception {
		return sCourseDao.sTestSubmit(paramMap);
	}

	/** 시험응시: 시험문제 불러오기*/
	public List<SCourseDto> sCreateTest(Map<String, Object> paramMap) throws Exception {
		return sCourseDao.sCreateTest(paramMap);
	}

	/** 시험응시 : 시험 채점 결과 삽입*/
	public int sTestCalculate(Map<String, Object> paramMap, HttpServletRequest request) throws Exception {
		return sCourseDao.sTestCalculate(paramMap);
	}
	
	/** 시험응시: 시험 제출 결과 불러오기*/
	public List<SCourseDto> sShowingTestResult(Map<String, Object> paramMap) throws Exception{
		return sCourseDao.sShowingTestResult(paramMap);
	}

//	/** 수강신청: 현재 수강신청 할 강의의 수강신청 인원 조회*/
//	public int currentEnrolled(Map<String, Object> paramMap) throws Exception {
//		return sCourseDao.sCurrentEnrolled(paramMap);
//	}


}
