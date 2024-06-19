package kr.happyjob.study.support.service;

import java.util.List;
import java.util.Map;


import kr.happyjob.study.tCourse.model.CourseVO;
import kr.happyjob.study.tCourse.model.DayoffVO;
import kr.happyjob.study.tCourse.model.EnrollmentDTO;


public interface AttendanceService {
	
	public List<CourseVO> listAttendance(Map<String, Object> paramMap) throws Exception;
	
	public int totalAttendance(Map<String, Object> paramMap) throws Exception;
	
	public List<EnrollmentDTO> infoAttendance(Map<String, Object> paramMap) throws Exception;
	
	public int totalInfoAttendance(Map<String, Object> paramMap) throws Exception;
	
	public Map<String, Object> insertAttendance(Map<String, Object> paramMap) throws Exception;
	
	public List<DayoffVO> listDay(Map<String, Object> paramMap) throws Exception;

	public List<EnrollmentDTO> allListAttendance(Map<String, Object> paramMap) throws Exception;
	
	public CourseVO keyAttendance(Map<String, Object> paramMap) throws Exception;
}
