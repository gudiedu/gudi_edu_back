package kr.happyjob.study.information.service;

import java.util.List;
import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import kr.happyjob.study.information.dao.AStudentAttendanceDAO;
import kr.happyjob.study.information.dto.AAttendanceDTO;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AStudentAttendanceServiceImpl implements AStudentAttendanceService {
	
	private final AStudentAttendanceDAO aStudentAttendanceDAO;

	private final Logger logger = LogManager.getLogger(this.getClass());

	@Value("${fileUpload.rootPath}")
	private String rootPath;

	@Value("${fileUpload.virtualRootPath}")
	private String virtualRootPath;

	@Value("${fileUpload.attendancePath}")
	private String attendancePath;

	@Override
	public List<Map<String, Object>> searchLecture(Map<String, Object> paramMap) throws Exception {
		List<Map<String,Object>>result = aStudentAttendanceDAO.searchLecture(paramMap);
		
		return result;
	}
	
	@Override
	public List<AAttendanceDTO> searchAttendance(Map<String, Object> paramMap) throws Exception {
		return aStudentAttendanceDAO.searchAttendance(paramMap);
	}

}
