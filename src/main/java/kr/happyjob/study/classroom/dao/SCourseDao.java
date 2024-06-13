package kr.happyjob.study.classroom.dao;

import java.util.List;
import java.util.Map;

import kr.happyjob.study.classroom.dto.SCourseDto;
import kr.happyjob.study.classroom.model.SDayoffModel;
public interface SCourseDao {

	/** 강의관리 : 학생이 수강하는 강의 목록 조회 */
	public List<SCourseDto> sStudentCourseInfo(Map<String, Object> paramMap) throws Exception;
	
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
}
