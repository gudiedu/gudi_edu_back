package kr.happyjob.study.tCourse.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.happyjob.study.tCourse.dao.CourseInfoDao;
import kr.happyjob.study.tCourse.model.CourseVO;
import kr.happyjob.study.tCourse.model.EnrollmentDTO;

@Service
public class CourseInfoServiceImpl implements CourseInfoService {
	
	@Autowired
	CourseInfoDao courseInfoDao;

	@Override
	public List<CourseVO> listCourseInfo(Map<String, Object> paramMap) throws Exception {
		return courseInfoDao.listCourseInfo(paramMap);
	}

	@Override
	public int totalCourseInfo(Map<String, Object> paramMap) throws Exception {
		return courseInfoDao.totalCourseInfo(paramMap);
	}

	@Override
	public List<EnrollmentDTO> listEnrollment(Map<String, Object> paramMap) throws Exception {
		return courseInfoDao.listEnrollment(paramMap);
	}

	@Override
	public Map<String, Object> updateEnroll(Map<String, Object> paramMap) throws Exception {
		Map<String, Object> returnMap = new HashMap<>(); 
		
		String status = (String) paramMap.get("status");
		String msg = "";
		
		if ("cancel".equals(status)) {
			paramMap.put("enYn", "N");
			msg = "취소 완료";
		} else if ("approval".equals(status)) {
			paramMap.put("enYn", "Y");
			msg = "승인 완료";
		} else {
			msg = "잘못된 요청입니다.";
		}
		
		int sqlreturn = courseInfoDao.updateEnroll(paramMap);
		
		if (sqlreturn < 0) {
			msg = "업데이트 실패";
		}
		
		
		returnMap.put("resultMsg", msg);
		
		return returnMap;
	}

	@Override
	public int totalEnrollment(Map<String, Object> paramMap) throws Exception {
		return courseInfoDao.totalEnrollment(paramMap);
	}

}
