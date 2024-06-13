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
	
	/** 강의관리 출결 : 학생이 듣는 특정 강의 내용 조회 */
	public SCourseDto sStudentCourseInfo(Map<String, Object> paramMap) throws Exception {
		return sCourseDao.sStudentCourseInfo(paramMap);
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
	
}
