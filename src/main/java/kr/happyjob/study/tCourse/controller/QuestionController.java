package kr.happyjob.study.tCourse.controller;

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


import kr.happyjob.study.tCourse.model.QuestionVO;
import kr.happyjob.study.tCourse.service.QuestionService;





@Controller
@RequestMapping("/tCourse/")
public class QuestionController {

	@Autowired 
	QuestionService questionService;
	
	   // Set logger
	   private final Logger logger = LogManager.getLogger(this.getClass());

	   // Get class name for logger
	   private final String className = this.getClass().toString();
	   
	   
	   @RequestMapping("listquestion.do")
	   @ResponseBody
	   public Map<String, Object> listquestion(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
	         HttpServletResponse response, HttpSession session) throws Exception {
	      
	      logger.info("+ Start " + className + ".listquestion");
	      logger.info("   - paramMap : " + paramMap);
	      
	      // 1 page : 0  2 page : 10   
	      
	      
	      int currentpage = Integer.parseInt((String) paramMap.get("currentPage"));
	      int pagesize = Integer.parseInt((String) paramMap.get("pageSize"));
	      int startpoint = (currentpage - 1) * pagesize;
	      
	      paramMap.put("pagesize", pagesize);
	      paramMap.put("startpoint", startpoint);
	      paramMap.put("pageSize", Integer.parseInt((String) paramMap.get("pageSize")));
	      
	      
	      Map<String, Object> returnmap = new HashMap<String, Object>();
	      
	      List<QuestionVO> listdata = questionService.listquestion(paramMap);
	      
	      
	      int totalcnt = questionService.totalcntquestion(paramMap);
	      
	      returnmap.put("listdata",listdata);
	      returnmap.put("totalcnt",totalcnt);
	      
	      logger.info("+ End " + className + ".listquestion");

	      return returnmap;
	   }

	  
 }
	   
	   
	   
	   
