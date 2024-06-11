package kr.happyjob.study.classroom.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.happyjob.study.classroom.dto.SCourseDto;
import kr.happyjob.study.classroom.service.SCourseService;

@Controller
@RequestMapping("/classroom/")
public class SCourseController {
	
	@Autowired
	SCourseService sCourseService;
	
	// Set logger
	private final Logger logger = LogManager.getLogger(this.getClass());

	// Get class name for logger
	private final String className = this.getClass().toString();
	
	@RequestMapping("sStudentAttendance.do")
	@ResponseBody
	 public Map<String, Object> sAttendanceList(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
	         HttpServletResponse response, HttpSession session) throws Exception {
		  
		  logger.info("+ Start " + className + ".sStudentAttendance");
	      logger.info("   - paramMap : " + paramMap);
	      
	      paramMap.put("loginID",(String)session.getAttribute("loginId"));
	      
	      Map<String, Object> returnMap = new HashMap<String, Object>();
	      
	      SCourseDto sStudentCourseInfo = sCourseService.sStudentCourseInfo(paramMap);
	      int attendanceDays = sCourseService.sAttendanceDays(paramMap);
	      int absenceDays = sCourseService.sAbsenceDays(paramMap);
	      List<SCourseDto> sAttendanceNotes = sCourseService.sAttendanceNotes(paramMap);
	      
	      returnMap.put("sStudentCourseInfo", sStudentCourseInfo);
	      returnMap.put("attendanceDays", attendanceDays);
	      returnMap.put("absenceDays", absenceDays);
	      returnMap.put("sAttendanceNotes", sAttendanceNotes);
	      
	      logger.info("+ End " + className + ".sStudentAttendance");
	      
	      return returnMap;
	   }
	
	
}