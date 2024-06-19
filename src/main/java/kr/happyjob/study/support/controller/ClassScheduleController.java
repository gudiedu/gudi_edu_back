package kr.happyjob.study.support.controller;

import java.time.LocalDate;
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

import kr.happyjob.study.support.service.ClassScheduleService;



@Controller
@RequestMapping("/support/")
public class ClassScheduleController {

	@Autowired
	ClassScheduleService classScheduleService;
	
	// Set logger
	private final Logger logger = LogManager.getLogger(this.getClass());

	// Get class name for logger
	private final String className = this.getClass().toString();

	@RequestMapping("listClassSchedule")
	@ResponseBody
	public Map<String, Object> listClassSchedule(Model model, @RequestParam Map<String, Object> paramMap,
			HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {

		logger.info("+ Start " + className + ".listClassSchedule");
		logger.info("   - paramMap : " + paramMap);

		// 1 page : 0 2 page : 10

		int currentpage = Integer.parseInt((String) paramMap.get("currentPage"));
		int pagesize = Integer.parseInt((String) paramMap.get("pageSize"));
		int startpoint = (currentpage - 1) * pagesize;

		paramMap.put("pagesize", pagesize);
		paramMap.put("startpoint", startpoint);

		Map<String, Object> returnmap = new HashMap<String, Object>();
		
		returnmap.put("listdata", classScheduleService.listClassSchedule(paramMap));
		returnmap.put("totalcnt", classScheduleService.totalClassSchedule(paramMap));


		logger.info("+ End " + className + ".listClassSchedule");

		return returnmap;
	}
	
	@RequestMapping("keySchedule")
	@ResponseBody
	public Map<String, Object> keySchedule(Model model, @RequestParam Map<String, Object> paramMap,
			HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {
		
		logger.info("+ Start " + className + ".keySchedule");
		logger.info("   - paramMap : " + paramMap);


		Map<String, Object> returnmap = new HashMap<String, Object>();
		
		returnmap.put("schedule", classScheduleService.keySchedule(paramMap));


		logger.info("+ End " + className + ".keySchedule");

		return returnmap;
		
		
	}
	
	@RequestMapping("saveSchedule")
	@ResponseBody
	public Map<String, Object> saveSchedule(Model model, @RequestParam Map<String, Object> paramMap,
			HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {
		
		logger.info("+ Start " + className + ".saveSchedule");
		logger.info("   - paramMap : " + paramMap);
		
		Map<String, Object> returnmap = classScheduleService.saveSchedule(paramMap);

		logger.info("+ End " + className + ".saveSchedule");

		return returnmap;
		
		
	}
	
	@RequestMapping("apiHoliday")
	@ResponseBody
	public Map<String, Object> apiHoliday(Model model, @RequestParam Map<String, Object> paramMap,
			HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {
		
		logger.info("+ Start " + className + ".apiHoliday");
		logger.info("   - paramMap : " + paramMap);
		
		Map<String, Object> returnmap = new HashMap<String, Object>();
		
		returnmap = classScheduleService.apiHoliday(paramMap);

		logger.info("+ End " + className + ".apiHoliday");

		return returnmap;
		
		
	}
	
	

	

}
