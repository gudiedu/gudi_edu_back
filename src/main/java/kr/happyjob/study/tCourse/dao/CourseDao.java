package kr.happyjob.study.tCourse.dao;

import java.util.List;
import java.util.Map;

import kr.happyjob.study.tCourse.model.CourseDetailVO;
import kr.happyjob.study.tCourse.model.CourseVO;
import kr.happyjob.study.tCourse.model.SurveyVO;


public interface CourseDao {
	
	
	public List<CourseVO> listCourse(Map<String, Object> paramMap) throws Exception;
	
	public int totalCourse(Map<String, Object> paramMap) throws Exception;
	
	public List<CourseDetailVO> detailCourse(Map<String, Object> paramMap) throws Exception;
	
	public CourseVO keyCourse(Map<String, Object> paramMap) throws Exception;
	
	public List<SurveyVO> listSurvey(Map<String, Object> paramMap) throws Exception;
	
	public int insertCourse(Map<String, Object> paramMap) throws Exception;
	
	public int insertCourseDetail(Map<String, Object> paramMap) throws Exception;

	public int insertTest(Map<String, Object> paramMap) throws Exception;
	
	public int updateCourse(Map<String, Object> paramMap) throws Exception;
	
	public int deleteCourse(Map<String, Object> paramMap) throws Exception;
	
	public int deleteCourseDetail(Map<String, Object> paramMap) throws Exception;
	

}
