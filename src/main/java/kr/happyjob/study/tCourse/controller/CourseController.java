package kr.happyjob.study.tCourse.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.View;

import kr.happyjob.study.tCourse.model.CourseVO;
import kr.happyjob.study.tCourse.model.EnrollmentDTO;
import kr.happyjob.study.tCourse.model.SurveyVO;
import kr.happyjob.study.tCourse.service.CourseInfoService;
import kr.happyjob.study.tCourse.service.CourseService;

@Controller
@RequestMapping("/tCourse/")
public class CourseController {
	
	@Autowired
	CourseService courseService;
	
	@Autowired
	CourseInfoService courseInfoService;

   // Set logger
   private final Logger logger = LogManager.getLogger(this.getClass());

   // Get class name for logger
   private final String className = this.getClass().toString();
   
   @RequestMapping("listCourse")
   @ResponseBody
   public Map<String, Object> listCourse(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
         HttpServletResponse response, HttpSession session) throws Exception {
      
      logger.info("+ Start " + className + ".listCourse");
      logger.info("   - paramMap : " + paramMap);
      
      // 1 page : 0  2 page : 10   
      
      int currentpage = Integer.parseInt((String) paramMap.get("currentPage"));
      int pagesize = Integer.parseInt((String) paramMap.get("pageSize"));
      int startpoint = (currentpage - 1) * pagesize;
      
      String loginid = (String) session.getAttribute("loginId");
      
      
      paramMap.put("loginID", loginid);
      
      paramMap.put("pagesize", pagesize);
      paramMap.put("startpoint", startpoint);
      
      Map<String, Object> returnmap = new HashMap<String, Object>();
      
      List<CourseVO> listdata = courseService.listCourse(paramMap);
      int totalcnt = courseService.totalCourse(paramMap);
      
      returnmap.put("listdata",listdata);
      returnmap.put("totalcnt",totalcnt);
      
      logger.info("+ End " + className + ".listCourse");

      return returnmap;
   }
     
   @RequestMapping("saveCourse")
   @ResponseBody
   public Map<String, Object> saveCourse(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
         HttpServletResponse response, HttpSession session) throws Exception {
      
      logger.info("+ Start " + className + ".saveCourse");
      logger.info("   - paramMap : " + paramMap);
      
      String loginid = (String) session.getAttribute("loginId");
      
      
      paramMap.put("loginID", loginid);
      
      Map<String, Object> returnmap = courseService.saveCourse(paramMap);
      
      
      logger.info("+ End " + className + ".saveCourse");

      return returnmap;
   }
   
   @RequestMapping("detailCourse")
   @ResponseBody
   public Map<String, Object> detailCourse(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
	         HttpServletResponse response, HttpSession session) throws Exception {
	   
	   logger.info("+ Start " + className + ".saveCourse");
	   logger.info("   - paramMap : " + paramMap);
	   
	   Map<String, Object> returnmap = courseService.detailCourse(paramMap);
	   
	      
	   logger.info("+ End " + className + ".saveCourse");
	   
	   return returnmap;
   }
   
 @RequestMapping("survey")
 @ResponseBody
 public Map<String, Object> survey(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
	         HttpServletResponse response, HttpSession session) throws Exception {
	   
	   logger.info("+ Start " + className + ".survey");
	   logger.info("   - paramMap : " + paramMap);
	   
	   Map<String, Object> returnmap = new HashMap<>();
	   
	   List<SurveyVO> listdata = courseService.listSurvey(paramMap);
	   
	   returnmap.put("listdata",listdata);    
	      
	   logger.info("+ End " + className + ".survey");
	   
	   return returnmap;
 } 
   
   @RequestMapping("listCourseInfo")
   @ResponseBody
   public Map<String, Object> listCourseInfo(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
         HttpServletResponse response, HttpSession session) throws Exception {
      
      logger.info("+ Start " + className + ".listCourseInfo");
      logger.info("   - paramMap : " + paramMap);
      
      // 1 page : 0  2 page : 10   
      
      int currentpage = Integer.parseInt((String) paramMap.get("currentPage"));
      int pagesize = Integer.parseInt((String) paramMap.get("pageSize"));
      int startpoint = (currentpage - 1) * pagesize;
      
      paramMap.put("pagesize", pagesize);
      paramMap.put("startpoint", startpoint);
      String loginid = (String) session.getAttribute("loginId");
      
      paramMap.put("loginID", loginid);
      
      Map<String, Object> returnmap = new HashMap<String, Object>();
      
      List<CourseVO> listdata = courseInfoService.listCourseInfo(paramMap);
      int totalcnt = courseInfoService.totalCourseInfo(paramMap);
      
      returnmap.put("listdata",listdata);
      returnmap.put("totalcnt",totalcnt);
      
      logger.info("+ End " + className + ".listCourseInfo");

      return returnmap;
   }

   
   @RequestMapping("listEnrollment")
   @ResponseBody
	public Map<String, Object> listEnrollment(Model model, @RequestParam Map<String, Object> paramMap,
			HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {

		logger.info("+ Start " + className + ".listEnrollment");
		logger.info("   - paramMap : " + paramMap);

		int currentpage = Integer.parseInt((String) paramMap.get("currentPage"));
		int pagesize = Integer.parseInt((String) paramMap.get("pageSize"));
		int startpoint = (currentpage - 1) * pagesize;

		paramMap.put("pagesize", pagesize);
		paramMap.put("startpoint", startpoint);

		Map<String, Object> returnmap = new HashMap<String, Object>();

		List<EnrollmentDTO> listdata = courseInfoService.listEnrollment(paramMap);
		int totalcnt = courseInfoService.totalEnrollment(paramMap);

		returnmap.put("listdata", listdata);
		returnmap.put("totalcnt",totalcnt);

		logger.info("+ End " + className + ".listEnrollment");

		return returnmap;
	}

	@RequestMapping("updateEnroll")
	@ResponseBody
	public Map<String, Object> updateEnroll(Model model, @RequestParam Map<String, Object> paramMap,
			HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {

		logger.info("+ Start " + className + ".updateEnroll");
		logger.info("   - paramMap : " + paramMap);

		Map<String, Object> returnmap = courseInfoService.updateEnroll(paramMap);

		logger.info("+ End " + className + ".updateEnroll");

		return returnmap;
	}

// @RequestMapping("")
// @ResponseBody
// public Map<String, Object> listEnrollment(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
//	         HttpServletResponse response, HttpSession session) throws Exception {
//	   
//	   logger.info("+ Start " + className + ".saveCourse");
//	   logger.info("   - paramMap : " + paramMap);
//	   
//	    Map<String, Object> returnmap = new HashMap<String, Object>();
//	      
//	      
//	   logger.info("+ End " + className + ".saveCourse");
//	   
//	   return returnmap;
// }
	


	
	
	
	
}