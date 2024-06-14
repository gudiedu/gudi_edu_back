package kr.happyjob.study.information.service;

import java.util.List;
import java.util.Map;

import kr.happyjob.study.information.dto.AAttendanceDTO;

public interface AStudentAttendanceService {
	
	public List<Map<String, Object>> searchLecture(Map<String, Object> paramMap) throws Exception;
	
	public List<AAttendanceDTO> searchAttendance(Map<String, Object> paramMap) throws Exception;

}
