package kr.happyjob.study.information.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import kr.happyjob.study.aAlert.model.AFileDTO;
import kr.happyjob.study.information.dto.AAttendanceDTO;

public interface AStudentAttendanceService {
	
	public List<Map<String, Object>> searchLecture(Map<String, Object> paramMap) throws Exception;
	
	public List<AAttendanceDTO> searchAttendance(Map<String, Object> paramMap) throws Exception;
	
	public int updateAttendanceStatus(Map<String, Object> paramMap) throws Exception;
	
	public int uploadAttendanceFile(Map<String, Object> paramMap, HttpServletRequest request) throws Exception;
	
	public AFileDTO downloadFile(Map<String, Object> paramMap) throws Exception;
	
	public int deleteFile(Map<String, Object> paramMap) throws Exception;

}
