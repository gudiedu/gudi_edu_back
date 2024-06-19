package kr.happyjob.study.tCourse.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import kr.happyjob.study.tCourse.dao.CourseDao;
import kr.happyjob.study.tCourse.model.CourseDetailVO;
import kr.happyjob.study.tCourse.model.CourseVO;
import kr.happyjob.study.tCourse.model.SurveyVO;


@Service
public class CourseServiceImpl implements CourseService {
	
	@Autowired
	CourseDao courseDao;

	@Override
	public List<CourseVO> listCourse(Map<String, Object> paramMap) throws Exception {
		return courseDao.listCourse(paramMap);
	}

	@Override
	public int totalCourse(Map<String, Object> paramMap) throws Exception {
		return courseDao.totalCourse(paramMap);
	}

	@Override
	public Map<String, Object> saveCourse(Map<String, Object> paramMap) throws Exception {
		Map<String, Object> returnMap = new HashMap<>(); 
		
		String action = (String) paramMap.get("paction");
		String msg = "";
		int sqlResult = 0; 
		
		
		if ("I".equals(action)) {
			int sql1 = courseDao.insertCourse(paramMap);
			String courseNo = (String) paramMap.get("courseNo");
			String weeksJson = (String) paramMap.get("weeks");
			
			ObjectMapper objectMapper = new ObjectMapper();
			List<Map<String, Object>> weeks = objectMapper.readValue(weeksJson, new TypeReference<List<Map<String, Object>>>() {});
			
			if (weeks != null) {
				for (Map<String, Object> week : weeks) {
					week.put("courseNo", courseNo);
				}
			}
			paramMap.put("weeks", weeks);
			
//			courseDao.insertTest(paramMap);
			
			int sql2 = courseDao.insertCourseDetail(paramMap);
			
			if (sql1 >= 0 && sql2 >= 0 ) {
				sqlResult = 1;
				msg = "저장 되었습니다.";
			} else {
				msg = "저장 실패 되었습니다.";
			}
		} else if ("U".equals(action)) {
			int sql1 = courseDao.updateCourse(paramMap);
			
			courseDao.deleteCourseDetail(paramMap);
			
			String weeksJson = (String) paramMap.get("weeks");
			
			ObjectMapper objectMapper = new ObjectMapper();
			List<Map<String, Object>> weeks = objectMapper.readValue(weeksJson, new TypeReference<List<Map<String, Object>>>() {});
			
			paramMap.put("weeks", weeks);
			
			
			int sql2 = courseDao.insertCourseDetail(paramMap);
			
			if (sql1 >= 0 && sql2 >= 0 ) {
				sqlResult = 1;
				msg = "수정 되었습니다.";
			} else {
				msg = "수정 실패 되었습니다.";
			}
			
		} else if ("D".equals(action)) {
			System.out.println("삭제왓낭ㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇ");
			int sql1 = courseDao.deleteCourse(paramMap);
			if (sql1 >= 0) {
				sqlResult = 1;
				msg = "삭제 되었습니다.";
			} else {
				msg = "삭제 실패 되었습니다.";
			}
			
		} else {
			sqlResult = -1;
			msg = "잘못된 요청 입니다.";
		}
		
		returnMap.put("result", sqlResult);
		returnMap.put("resultMsg", msg);
		
		
		return returnMap;
	}

	@Override
	public Map<String, Object> detailCourse(Map<String, Object> paramMap) throws Exception {
		Map<String, Object> returnMap = new HashMap<>();
		
		returnMap.put("course", courseDao.keyCourse(paramMap));
		returnMap.put("detail", courseDao.detailCourse(paramMap));
		
		return returnMap;
	}

	@Override
	public List<SurveyVO> listSurvey(Map<String, Object> paramMap) throws Exception {
		return courseDao.listSurvey(paramMap);
	}

}
