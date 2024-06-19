package kr.happyjob.study.support.service;

import java.util.List;
import java.util.Map;


import kr.happyjob.study.tCourse.model.CourseVO;
import kr.happyjob.study.tCourse.model.DayoffVO;
import kr.happyjob.study.tCourse.model.EnrollmentDTO;
import kr.happyjob.study.tCourse.model.SurveyVO;


public interface ClassScheduleService {
	
	public List<DayoffVO> listClassSchedule(Map<String, Object> paramMap) throws Exception;
	
	public int totalClassSchedule(Map<String, Object> paramMap) throws Exception;
	
	public DayoffVO keySchedule(Map<String, Object> paramMap) throws Exception;

	public Map<String, Object> saveSchedule(Map<String, Object> paramMap) throws Exception;

	public Map<String, Object> apiHoliday(Map<String, Object> paramMap) throws Exception;
	
}
