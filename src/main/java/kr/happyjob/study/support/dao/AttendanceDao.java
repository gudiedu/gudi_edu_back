package kr.happyjob.study.support.dao;

import java.util.List;
import java.util.Map;

import kr.happyjob.study.tCourse.model.CourseVO;
import kr.happyjob.study.tCourse.model.DayoffVO;
import kr.happyjob.study.tCourse.model.EnrollmentDTO;


public interface AttendanceDao {
	
	
	public List<CourseVO> listAttendance(Map<String, Object> paramMap) throws Exception;
	
	public int totalAttendance(Map<String, Object> paramMap) throws Exception;
	
	public List<EnrollmentDTO> infoAttendance(Map<String, Object> paramMap) throws Exception;
	
	public int totalInfoAttendance(Map<String, Object> paramMap) throws Exception;
	
	public int insertAteendance(Map<String, Object> paramMap) throws Exception;
	
	public int deleteAttendance(Map<String, Object> paramMap) throws Exception;
	
	public int countAttendance(Map<String, Object> paramMap) throws Exception;

	public int updateAttendanceStatus(Map<String, Object> paramMap) throws Exception;
	
	public List<DayoffVO> listDay(Map<String, Object> paramMap) throws Exception;
	
	public List<EnrollmentDTO> allListAttendance(Map<String, Object> paramMap) throws Exception;
	
	public CourseVO keyAttendance(Map<String, Object> paramMap) throws Exception;
	


}
