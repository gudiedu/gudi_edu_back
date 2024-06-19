package kr.happyjob.study.support.service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import kr.happyjob.study.support.dao.AttendanceDao;
import kr.happyjob.study.tCourse.model.CourseVO;
import kr.happyjob.study.tCourse.model.DayoffVO;
import kr.happyjob.study.tCourse.model.EnrollmentDTO;

@Service
public class AttendanceServiceImpl implements AttendanceService {
	
	@Autowired
	AttendanceDao attendanceDao;

	@Override
	public List<CourseVO> listAttendance(Map<String, Object> paramMap) throws Exception {
		return attendanceDao.listAttendance(paramMap);
	}

	@Override
	public int totalAttendance(Map<String, Object> paramMap) throws Exception {
		return attendanceDao.totalAttendance(paramMap);
	}

	@Override
	public List<EnrollmentDTO> infoAttendance(Map<String, Object> paramMap) throws Exception {
		return attendanceDao.infoAttendance(paramMap);
	}

	@Override
	public int totalInfoAttendance(Map<String, Object> paramMap) throws Exception {
		return attendanceDao.totalInfoAttendance(paramMap);
	}

	@Override
	public Map<String, Object> insertAttendance(Map<String, Object> paramMap) throws Exception {
		Map<String, Object> returnMap = new HashMap<>();
		LocalDate att_today = LocalDate.now();
		String msg = "";
		String studentsJson = (String) paramMap.get("students");
		
		ObjectMapper objectMapper = new ObjectMapper();
		List<Map<String, Object>> students = objectMapper.readValue(studentsJson, new TypeReference<List<Map<String, Object>>>() {});
		
		paramMap.put("students", students);
		paramMap.put("att_today", att_today.toString());
		
		int resultCount = attendanceDao.countAttendance(paramMap);
		
		if (resultCount > 0) {
			//업데이트
			int sqlresult = attendanceDao.updateAttendanceStatus(paramMap);
			
			if (sqlresult >= 0 ) msg = "재출석 완료";
			else msg = "잘못된 요청";
			
		} else {
			if (students != null) {
				for (Map<String, Object> st : students) {
					st.put("attendance_date", att_today.toString());
				}
			}
			paramMap.put("students", students);
			
			int sqlresult = attendanceDao.insertAteendance(paramMap);
			
			if (sqlresult >= 0) msg = "출석 완료";
			else msg = "잘못된 요청";
			
		}
		
		returnMap.put("resultMsg", msg);
		
		return returnMap;
	}

	@Override
	public List<DayoffVO> listDay(Map<String, Object> paramMap) throws Exception {
		return attendanceDao.listDay(paramMap);
	}

	@Override
	public List<EnrollmentDTO> allListAttendance(Map<String, Object> paramMap) throws Exception {
		return attendanceDao.allListAttendance(paramMap);
	}

	@Override
	public CourseVO keyAttendance(Map<String, Object> paramMap) throws Exception {
		return attendanceDao.keyAttendance(paramMap);
	}

}
