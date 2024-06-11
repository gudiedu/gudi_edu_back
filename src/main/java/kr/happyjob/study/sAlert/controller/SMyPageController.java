package kr.happyjob.study.sAlert.controller;

import java.util.HashMap;
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

import kr.happyjob.study.sAlert.dto.SMyPageDto;
import kr.happyjob.study.sAlert.service.SMyPageService;

@Controller
@RequestMapping("/sAlert/")
public class SMyPageController {
	
	@Autowired
	SMyPageService SMyPageService;
	
	// Set logger
	private final Logger logger = LogManager.getLogger(this.getClass());

	// Get class name for logger
	private final String className = this.getClass().toString();
	
	@RequestMapping("sMyPage.do")
	@ResponseBody
	 public Map<String, Object> sMyPage(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
	         HttpServletResponse response, HttpSession session) throws Exception {
		  
		  logger.info("+ Start " + className + ".sMyPage");
	      logger.info("   - paramMap : " + paramMap);
	      
	      paramMap.put("loginID",(String)session.getAttribute("loginId"));
	      
	      Map<String, Object> returnMap = new HashMap<String, Object>();
	      
	      SMyPageDto listData = SMyPageService.sMyPage(paramMap);
	      
	      returnMap.put("listData", listData);
	      
	      logger.info("+ End " + className + ".sMyPage");
	      
	      return returnMap;
	   }
	
	@RequestMapping("sUpdateMyPage.do")
	@ResponseBody
	 public Map<String, Object> sUpdateMyPage(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
	         HttpServletResponse response, HttpSession session) throws Exception {
		  
		  logger.info("+ Start " + className + ".sUpdateMyPage");
	      logger.info("   - paramMap : " + paramMap);
	      
	      int sqlReturn = 0;
	      String resultMsg = "";
	      
	      paramMap.put("loginID",(String)session.getAttribute("loginId"));
	      
	      Map<String, Object> returnMap = new HashMap<String, Object>();
	      
	      sqlReturn = SMyPageService.sUpdateMyPage(paramMap);
	      
	      if(sqlReturn >= 0){
	    	  resultMsg = "수정 되었습니다.";
	      }else{
	    	  resultMsg = "수정 실패 되었습니다.";
	      }
	      
	      returnMap.put("result", sqlReturn);
	      returnMap.put("resultMsg", resultMsg);
	      
	      logger.info(resultMsg);
	      
	      logger.info("+ End " + className + ".sUpdateMyPage");
	      
	      return returnMap;
	   }
}