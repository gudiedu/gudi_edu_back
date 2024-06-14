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
import kr.happyjob.study.classroom.model.SDayoffModel;
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
	      
	      List<SCourseDto> sStudentCourseInfo = sCourseService.sStudentCourseInfo(paramMap);
	      SCourseDto sStudentSelectedCourseInfo = sCourseService.sStudentSelectedCourseInfo(paramMap);
	      int attendanceDays = sCourseService.sAttendanceDays(paramMap);
	      int absenceDays = sCourseService.sAbsenceDays(paramMap);
	      List<SCourseDto> sAttendanceNotes = sCourseService.sAttendanceNotes(paramMap);
	      List<SDayoffModel> sDayoffInfo = sCourseService.sDayoffInfo(paramMap);
	      
	      //test
	      returnMap.put("sStudentCourseInfo", sStudentCourseInfo);
	      returnMap.put("sStudentSelectedCourseInfo", sStudentSelectedCourseInfo);
	      returnMap.put("attendanceDays", attendanceDays);
	      returnMap.put("absenceDays", absenceDays);
	      returnMap.put("sDayoffInfo", sDayoffInfo);
	      returnMap.put("sAttendanceNotes", sAttendanceNotes);
	      
	      logger.info("+ End " + className + ".sStudentAttendance");
	      
	      return returnMap;
	   }
	
	// 특정 강의 세부 정보 조회
		@RequestMapping("sCourseInfo.do")
		@ResponseBody
		 public Map<String, Object> sCourseInfo(Model model,
				 @RequestParam Map<String, Object> paramMap,
				 HttpServletRequest request,
		         HttpServletResponse response, HttpSession session) throws Exception {
			
				logger.info("+ Start " + className + ".sCourseInfo");
			    logger.info("   - paramMap : " + paramMap);
				
			    paramMap.put("currentLoginID",(String)session.getAttribute("loginId"));
			    
			    Map<String, Object> returnMap = new HashMap<String, Object>();
			    
			    SCourseDto sCourseInfo = sCourseService.sCourseInfo(paramMap);
			    
			    returnMap.put("infoResult", sCourseInfo);
			    		    
			    logger.info("+ End " + className + ".sCourseInfo");
			    
			    return returnMap;
			
		}
	
	// 특정 강의 세부 정보 조회
	@RequestMapping("sCourseDetail.do")
	@ResponseBody
	 public Map<String, Object> sCourseDetail(Model model,
			 @RequestParam Map<String, Object> paramMap,
			 HttpServletRequest request,
	         HttpServletResponse response, HttpSession session) throws Exception {
		
			logger.info("+ Start " + className + ".sCourseDetail");
		    logger.info("   - paramMap : " + paramMap);
			
		    paramMap.put("loginID",(String)session.getAttribute("loginId"));
		    
		    Map<String, Object> returnMap = new HashMap<String, Object>();
		    
		    SCourseDto sCourseDetail = sCourseService.sCourseDetail(paramMap);
		    
		    returnMap.put("detailResult", sCourseDetail);
		    
		    logger.info("+ End " + className + ".sCourseDetail");
		    
		    return returnMap;
		
	}
	
	
	
}