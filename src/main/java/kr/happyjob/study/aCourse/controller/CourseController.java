package kr.happyjob.study.aCourse.controller;

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

import kr.happyjob.study.aCourse.model.CourseModel;
import kr.happyjob.study.aCourse.service.CourseService;

@Controller
@RequestMapping("/course/")
public class CourseController {
	
	@Autowired
	CourseService courseService;
	
	   // Set logger
	private final Logger logger = LogManager.getLogger(this.getClass());

	   // Get class name for logger
	private final String className = this.getClass().toString();
	   
	// 강의 목록 리스트 출력
	@RequestMapping("CourseList.do")
	@ResponseBody
	public Map<String, Object> CourseList(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
               HttpServletResponse response, HttpSession session) throws Exception {
			logger.info("+ Start " + className + ".CourseList");
			logger.info("   - paramMap : " + paramMap);
			
			List<CourseModel> CourseListModel = courseService.CourseList(paramMap);
			
			Map<String, Object> resultMap = new HashMap<>();
			
			resultMap.put("listdate", CourseListModel);
			
			logger.info("+ End " + className + ".CourseList");
	
			return resultMap;
	}
	
	@RequestMapping("courseSearch.do")
	@ResponseBody
	public Map<String, Object> courseSearch(Model model, @RequestParam String word, HttpServletRequest request,
            HttpServletResponse response, HttpSession session) throws Exception {
				logger.info("+ Start " + className + ".courseSearch");
				logger.info("   - 검색단어 : " + word);
				
				List<CourseModel> courseListModel = courseService.courseSearch(word);
				
				Map<String, Object> resultMap = new HashMap<>();
				
				resultMap.put("listdate", courseListModel);
				
	
				logger.info("+ End " + className + ".courseSearch");
				return resultMap;
			}
	
	
	
}
