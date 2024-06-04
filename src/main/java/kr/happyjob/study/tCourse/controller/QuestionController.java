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

import kr.happyjob.study.sampletest.model.SamplenoticeModel;
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
	   
	   
	   @RequestMapping("listnquestion.do")
	   @ResponseBody
	   public Map<String, Object> listnotice(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
	         HttpServletResponse response, HttpSession session) throws Exception {
	      
	      logger.info("+ Start " + className + ".listquestion");
	      logger.info("   - paramMap : " + paramMap);
	      
	      // 1 page : 0  2 page : 10   
	      
	      int currentpage = Integer.parseInt((String) paramMap.get("currentpage"));
	      int pagesize = Integer.parseInt((String) paramMap.get("pagesize"));
	      int startpoint = (currentpage - 1) * pagesize;
	      
	      paramMap.put("pagesize", pagesize);
	      paramMap.put("startpoint", startpoint);
	      
	      
	      Map<String, Object> returnmap = new HashMap<String, Object>();
	      
	      List<QuestionVO> listdate = questionService.listquestion(paramMap);
	      int totalcnt = questionService.totalcntquestion(paramMap);
	      
	      returnmap.put("listdate",listdate);
	      returnmap.put("totalcnt",totalcnt);
	      
	      logger.info("+ End " + className + ".listnotice");

	      return returnmap;
	   }

	   @RequestMapping("savequestion.do")
	   @ResponseBody
	   public Map<String, Object> savequestion(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
	         HttpServletResponse response, HttpSession session) throws Exception {
	      
	      logger.info("+ Start " + className + ".savequestion");
	      logger.info("   - paramMap : " + paramMap);
	      
	      // 1 page : 0  2 page : 10   
	      
	      String action = (String) paramMap.get("action");
	      int sqlreturn = 0;
	      String resultmsg = "";
	      
	      
	      paramMap.put("loginID",(String)session.getAttribute("loginId"));
	      
	      Map<String, Object> returnmap = new HashMap<String, Object>();
	      
	     /* if("I".equals(action)) {
	    	  sqlreturn = questionService.insertquestion(paramMap);    	  
	      } else 
	    	  */
	      
	    	if("U".equals(action)) {
	    	  sqlreturn = questionService.updatequestion(paramMap);
	      } else if("D".equals(action)) {
	    	  sqlreturn = questionService.deletequestion(paramMap);
	      } else {
	    	  returnmap.put("result",-1);
	          returnmap.put("resultmsg","잘못된 요청 입니다.");
	          return returnmap;		
	      }
	      
	      
	      if("U".equals(action)) {
	    	  if(sqlreturn >= 0) {
	    	     resultmsg = "수정 되었습니다.";
	    	  } else {
	    		 resultmsg = "수정 실패 되었습니다.";
	    	  }
	      }
	      
	      if("D".equals(action)) {
	    	  if(sqlreturn >= 0) {
	    	     resultmsg = "삭제 되었습니다.";
	    	  } else {
	    		 resultmsg = "식제 실패 되었습니다.";
	    	  }
	      }
	      
	      returnmap.put("result",sqlreturn);
	      returnmap.put("resultmsg",resultmsg);
	      
	      logger.info("+ End " + className + ".savenotice");

	      return returnmap;
	   }
	   
	   
	      @RequestMapping("selectquestion.do")
	      @ResponseBody
	      public Map<String, Object> selectquestion(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
	            HttpServletResponse response, HttpSession session) throws Exception {
	         
	         logger.info("+ Start " + className + ".selectquestion");
	         logger.info("   - paramMap : " + paramMap);
	         
	         
	         paramMap.put("loginID",(String)session.getAttribute("loginId"));
	         
	         Map<String, Object> returnmap = new HashMap<String, Object>();      
	         
	         QuestionVO sqlreturn = questionService.selectquestion(paramMap); 
	         
	         returnmap.put("result",sqlreturn);
	         
	         logger.info("+ End " + className + ".selectquestion");

	         return returnmap;
	      }  
	      
 }
	   
	   
	   
	   
