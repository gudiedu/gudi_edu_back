package kr.happyjob.study.information.dao;

import java.util.List;
import java.util.Map;

import kr.happyjob.study.aAlert.model.AFileDTO;
import kr.happyjob.study.information.dto.AAttendanceDTO;

public interface AStudentAttendanceDAO {
	public List<Map<String, Object>> searchLecture(Map<String, Object> paramMap) throws Exception;
	
	public Map<String, Object> findStudentName(Map<String, Object> paramMap) throws Exception;
	
	public List<AAttendanceDTO> searchAttendance(Map<String, Object> paramMap) throws Exception;
	
	public int updateAttendanceStatus(Map<String, Object> paramMap) throws Exception;
	
	public int saveFile(AFileDTO file) throws Exception;
	
	public AFileDTO downloadFile(Map<String,Object> paramMap) throws Exception;

}
