package kr.happyjob.study.tCourse.service;

import java.util.List;
import java.util.Map;


import kr.happyjob.study.tCourse.model.CourseVO;
import kr.happyjob.study.tCourse.model.SurveyVO;


public interface CourseService {
	
	/*강의 목록*/
	public List<CourseVO> listCourse(Map<String, Object> paramMap) throws Exception;
	
	/*강의 목록 카운트*/
	public int totalCourse(Map<String, Object> paramMap) throws Exception;
	
	/*강의 목록 저장 수정 삭제*/
	public Map<String, Object> saveCourse(Map<String, Object> paramMap) throws Exception;
	
	/*강의 세부 정보*/
	public Map<String, Object> detailCourse(Map<String, Object> paramMap) throws Exception;
	
	/*강의 설문조사 목록(selectbox)*/
	public List<SurveyVO> listSurvey(Map<String, Object> paramMap) throws Exception;
	
	
}
