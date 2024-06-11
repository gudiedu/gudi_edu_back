package kr.happyjob.study.classroom.dao;

import java.util.List;
import java.util.Map;

import kr.happyjob.study.classroom.dto.SCourseDto;
public interface SCourseDao {

	/** 강의관리 출결 : 학생이 듣는 특정 강의 내용 조회 */
	public SCourseDto sStudentCourseInfo(Map<String, Object> paramMap) throws Exception;
	
	/** 강의관리 출결 : 학생 출결(출석한 횟수) */
	public int sAttendanceDays(Map<String, Object> paramMap) throws Exception;
	
	/** 강의관리 출결 : 학생 출결(결석한 횟수) */
	public int sAbsenceDays(Map<String, Object> paramMap) throws Exception;
	
	/** 강의관리 출결 : 학생 출결(지각, 결석한 것만) */
	public List<SCourseDto> sAttendanceNotes(Map<String, Object> paramMap) throws Exception;
}
