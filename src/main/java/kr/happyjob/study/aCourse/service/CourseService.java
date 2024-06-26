package kr.happyjob.study.aCourse.service;

import java.util.List;
import java.util.Map;

import kr.happyjob.study.aCourse.model.CourseModel;

public interface CourseService {
	//강의 목록 리스트 출력
	public List<CourseModel> courseList(Map<String, Object> paramMap) throws Exception;
	
	//강의 목록 검색 조회
	public List<CourseModel> courseSearch(String word) throws Exception;
	
	public List<CourseModel> searchClassSurvey(Map<String, Object> paramMap) throws Exception;

	public int totalcntClassSurvey(Map<String, Object> paramMap) throws Exception;
	
}
