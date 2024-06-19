package kr.happyjob.study.tCourse.service;

import java.util.List;
import java.util.Map;


import kr.happyjob.study.tCourse.model.CourseVO;
import kr.happyjob.study.tCourse.model.EnrollmentDTO;


public interface CourseInfoService {
	
	public List<CourseVO> listCourseInfo(Map<String, Object> paramMap) throws Exception;
	
	public List<EnrollmentDTO> listEnrollment(Map<String, Object> paramMap) throws Exception;
	
	public int totalCourseInfo(Map<String, Object> paramMap) throws Exception;
	
	public int totalEnrollment(Map<String, Object> paramMap) throws Exception;

	public Map<String, Object> updateEnroll(Map<String, Object> paramMap) throws Exception;;
	
	
}
