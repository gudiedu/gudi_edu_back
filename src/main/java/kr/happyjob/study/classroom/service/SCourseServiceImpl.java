package kr.happyjob.study.classroom.service;

import java.util.List;
import java.util.Map;

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
	
}
