package kr.happyjob.study.support.dao;

import java.util.List;
import java.util.Map;

import kr.happyjob.study.tCourse.model.DayoffVO;



public interface ClassScheduleDao {
	
	
	public List<DayoffVO> listClassSchedule(Map<String, Object> paramMap) throws Exception;
	
	public int totalClassSchedule(Map<String, Object> paramMap) throws Exception;
	
	public DayoffVO keySchedule(Map<String, Object> paramMap) throws Exception;
	
	public int insertSchedule(Map<String, Object> paramMap) throws Exception;
	
	public int updateSchedule(Map<String, Object> paramMap) throws Exception;
	
	public int deleteSchedule(Map<String, Object> paramMap) throws Exception;
	
	public int deleteAll(Map<String, Object> paramMap) throws Exception;
	
	public int insertApi(List<DayoffVO> paramMap) throws Exception;
	


}
