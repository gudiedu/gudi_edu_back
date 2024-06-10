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

import kr.happyjob.study.tCourse.model.QuestionReplyVO;
import kr.happyjob.study.tCourse.service.QuestionReplyService;






@Controller
@RequestMapping("/tCourse/")
public class QuestionReplyController {

	@Autowired 
	QuestionReplyService questionReplyService;
	
	 // Set logger
	   private final Logger logger = LogManager.getLogger(this.getClass());

	   // Get class name for logger
	   private final String className = this.getClass().toString();
	   
	   
	   @RequestMapping("listquestionreply.do")
	   @ResponseBody
	   public Map<String, Object> listquestion(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
	         HttpServletResponse response, HttpSession session) throws Exception {
	      
	      logger.info("+ Start " + className + ".listquestionreply");
	      logger.info("   - paramMap : " + paramMap);
	      
	      // 1 page : 0  2 page : 10   
	      
	     
	      Map<String, Object> returnmap = new HashMap<String, Object>();
	      
	      List<QuestionReplyVO> listdata = questionReplyService.listquestionreply(paramMap);
	      
	      
	      returnmap.put("listdata",listdata);
	      
	      logger.info("+ End " + className + ".listquestion");

	      return returnmap;
	   }
	

	   @RequestMapping("savequestionreply.do")
	   @ResponseBody
	   public Map<String, Object> savequestion(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
	         HttpServletResponse response, HttpSession session) throws Exception {
	      
	      logger.info("+ Start " + className + ".savequestionreply");
	      logger.info("   - paramMap : " + paramMap);
	      
	      // 1 page : 0  2 page : 10   
	      
	      String action = (String) paramMap.get("action");
	      int sqlreturn = 0;
	      String resultmsg = "";
	      
	      
	      paramMap.put("loginID",(String)session.getAttribute("loginId"));
	      
	      Map<String, Object> returnmap = new HashMap<String, Object>();
	      
	      if("I".equals(action)) {
	    	  sqlreturn = questionReplyService.insertquestionreply(paramMap);    	  
	      } else if("U".equals(action)) {
	    	  sqlreturn = questionReplyService.updatequestionreply(paramMap);
	      } else if("D".equals(action)) {
	    	  sqlreturn = questionReplyService.deletequestionreply(paramMap);
	      } else {
	    	  returnmap.put("result",-1);
	          returnmap.put("resultmsg","잘못된 요청 입니다.");
	          return returnmap;		
	      }
	      
	      if("I".equals(action)) {
	    	  if(sqlreturn >= 0) {
	    	     resultmsg = "저장 되었습니다.";
	    	  } else {
	    		 resultmsg = "저장을 실패했습니다.";
	    	  }
	      }
	      
	      if("U".equals(action)) {
	    	  if(sqlreturn >= 0) {
	    	     resultmsg = "수정 되었습니다.";
	    	  } else {
	    		 resultmsg = "수정을 실패했습니다.";
	    	  }
	      }
	      
	      if("D".equals(action)) {
	    	  if(sqlreturn >= 0) {
	    	     resultmsg = "삭제 되었습니다.";
	    	  } else {
	    		 resultmsg = "식제를 실패했습니다.";
	    	  }
	      }
	      
	      returnmap.put("result",sqlreturn);
	      returnmap.put("resultmsg",resultmsg);
	      
	      logger.info("+ End " + className + ".savequestion");

	      return returnmap;
	   }
	   
	   
	      @RequestMapping("selectquestionreply.do")
	      @ResponseBody
	      public Map<String, Object> selectquestion(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
	            HttpServletResponse response, HttpSession session) throws Exception {
	         
	         logger.info("+ Start " + className + ".selectquestion");
	         logger.info("   - paramMap : " + paramMap);
	         
	         
	         paramMap.put("loginID",(String)session.getAttribute("loginId"));
	         
	         Map<String, Object> returnmap = new HashMap<String, Object>();      
	         
	         QuestionReplyVO sqlreturn = questionReplyService.selectquestionreply(paramMap); 
	         
	         returnmap.put("result",sqlreturn);
	         
	         logger.info("+ End " + className + ".selectquestionreply");

	         return returnmap;
	      }  
	      
 }
	   
	   
	   
	   
