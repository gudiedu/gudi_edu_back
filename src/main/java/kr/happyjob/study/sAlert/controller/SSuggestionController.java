package kr.happyjob.study.sAlert.controller;

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

import kr.happyjob.study.sAlert.dto.SSuggestionDto;
import kr.happyjob.study.sAlert.service.SSuggestionService;

@Controller
@RequestMapping("/sAlert/")
public class SSuggestionController {
	
	@Autowired
	SSuggestionService SSuggestionService;
	
	// Set logger
	private final Logger logger = LogManager.getLogger(this.getClass());

	// Get class name for logger
	private final String className = this.getClass().toString();
	
	@RequestMapping("sSuggestionList.do")
	@ResponseBody
	 public Map<String, Object> sSuggestionList(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
	         HttpServletResponse response, HttpSession session) throws Exception {
		  
		  logger.info("+ Start " + className + ".sSuggestionList");
	      logger.info("   - paramMap : " + paramMap);
	      
	      paramMap.put("loginID",(String)session.getAttribute("loginId"));
	      
	      Map<String, Object> returnMap = new HashMap<String, Object>();
	      
	      List<SSuggestionDto> listData = SSuggestionService.sSuggestionList(paramMap);
	      
	      returnMap.put("listData", listData);
	      
	      logger.info("+ End " + className + ".sSuggestionList");
	      
	      return returnMap;
	   }
	
	@RequestMapping("sSelectSuggestion.do")
	@ResponseBody
	 public Map<String, Object> sSelectSuggestion(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
	         HttpServletResponse response, HttpSession session) throws Exception {
		  
		  logger.info("+ Start " + className + ".sSelectSuggestion");
	      logger.info("   - paramMap : " + paramMap);
	      
	      paramMap.put("loginID",(String)session.getAttribute("loginId"));
	      
	      Map<String, Object> returnMap = new HashMap<String, Object>();
	      
	      SSuggestionDto listData = SSuggestionService.sSelectSuggestion(paramMap);
	      
	      returnMap.put("listData", listData);
	      
	      logger.info("+ End " + className + ".sSelectSuggestion");
	      
	      return returnMap;
	   }
}