package kr.happyjob.study.information.controller;

import java.util.List;
import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.happyjob.study.information.dto.AAttendanceDTO;
import kr.happyjob.study.information.service.AStudentAttendanceService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class AStudentAttendanceController {
	
	private final AStudentAttendanceService aStudentAttendanceService;
	
	private final Logger logger = LogManager.getLogger(this.getClass());
	
	@RequestMapping("/aInformation/student")
	public List<Map<String, Object>> searchLecture(@RequestParam Map<String, Object> paramMap) throws Exception{
		List<Map<String, Object>> result = aStudentAttendanceService.searchLecture(paramMap);
		logger.info(result);
		return result;
	}
	
	@RequestMapping("/aInformation/student/attendance")
	public List<AAttendanceDTO> searchAttendance(@RequestParam Map<String, Object> paramMap) throws Exception{
		
		return aStudentAttendanceService.searchAttendance(paramMap);
	}
}
