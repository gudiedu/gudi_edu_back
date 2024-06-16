package kr.happyjob.study.aCourse.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.happyjob.study.aCourse.dao.CourseDao;
import kr.happyjob.study.aCourse.model.CourseModel;

@Service
public class CourseServiceImpl implements CourseService{
	// Set logger
	private final Logger logger = LogManager.getLogger(this.getClass());
	// Get class name for logger
	private final String className = this.getClass().toString();
	
	@Autowired
	private CourseDao courseDao;
	
	//강의 목록 리스트 출력
	public List<CourseModel> CourseList(Map<String, Object> paramMap) throws Exception{
		return courseDao.CourseList(paramMap);
	}

	//강의 목록 검색 조회
	@Override
	public List<CourseModel> courseSearch(String word) throws Exception {
		// TODO Auto-generated method stub
		return courseDao.courseSearch(word);
	}
}
