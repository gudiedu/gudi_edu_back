package kr.happyjob.study.support.controller;

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

import kr.happyjob.study.support.model.tClassSurveyResultDTO;
import kr.happyjob.study.support.model.tClassSurveyVO;
import kr.happyjob.study.support.service.tClassSurveyService;





@Controller
@RequestMapping("/support/")
public class tClassSurveyController {

	@Autowired 
	tClassSurveyService tClassSurveyService;
	
	   // Set logger
	   private final Logger logger = LogManager.getLogger(this.getClass());

	   // Get class name for logger
	   private final String className = this.getClass().toString();
	   
	   
	   @RequestMapping("searchClassSurvey.do")
	   @ResponseBody
	   public Map<String, Object> searchClassSurvey(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
	         HttpServletResponse response, HttpSession session) throws Exception {
	      
	      logger.info("+ Start " + className + ".searchClassSurvey");
	      logger.info("   - paramMap : " + paramMap);
	      
	      // 1 page : 0  2 page : 10   
	      
	      
	      int currentpage = Integer.parseInt((String) paramMap.get("currentPage"));
	      int pagesize = Integer.parseInt((String) paramMap.get("pageSize"));
	      int startpoint = (currentpage - 1) * pagesize;
	      paramMap.put("loginID", session.getAttribute("loginId"));
	      paramMap.put("pagesize", pagesize);
	      paramMap.put("startpoint", startpoint);
	      paramMap.put("pageSize", Integer.parseInt((String) paramMap.get("pageSize")));
	      
	      
	      Map<String, Object> returnmap = new HashMap<String, Object>();
	      
	      List<tClassSurveyVO> listdata = tClassSurveyService.searchClassSurvey(paramMap);
	      
	      
	      int totalcnt = tClassSurveyService.totalcntClassSurvey(paramMap);
	      
	      returnmap.put("listdata",listdata);
	      returnmap.put("totalcnt",totalcnt);
	      
	      logger.info("+ End " + className + ".searchClassSurvey");

	      return returnmap;
	   }

	  
	   @RequestMapping("fetchSurveyResults.do")
	    @ResponseBody
	    public Map<String, Object> fetchSurveyResults(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
	         HttpServletResponse response, HttpSession session) throws Exception {
	      
		   logger.info("+ Start " + className + ".fetchSurveyResults");
		    logger.info("   - paramMap : " + paramMap);

		    String courseNoStr = (String) paramMap.get("course_no");
		    if (courseNoStr == null || courseNoStr.trim().isEmpty() || "null".equals(courseNoStr)) {
		        throw new IllegalArgumentException("course_no parameter is missing or empty");
		    }

		    int courseNo;
		    try {
		        courseNo = Integer.parseInt(courseNoStr);
		    } catch (NumberFormatException e) {
		        throw new IllegalArgumentException("Invalid course_no: " + courseNoStr, e);
		    }

	        
	        paramMap.put("course_no", courseNo);

	        Map<String, Object> returnmap = new HashMap<String, Object>();
	      
	        List<tClassSurveyResultDTO> surveyResults = tClassSurveyService.fetchSurveyResults(paramMap);
	      
	        returnmap.put("surveyResults", surveyResults);
	      
	        logger.info("+ End " + className + ".fetchSurveyResults");

	        return returnmap;
	    }
	}