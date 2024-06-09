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

import kr.happyjob.study.sAlert.dto.SQnaDto;
import kr.happyjob.study.sAlert.model.SQuestionModel;
import kr.happyjob.study.sAlert.service.SQnaService;


@Controller
@RequestMapping("/sAlert/")
public class SQnaController {
	
	@Autowired
	SQnaService sQnaService;
	
	// Set logger
	   private final Logger logger = LogManager.getLogger(this.getClass());
	
	// Get class name for logger
	   private final String className = this.getClass().toString();
	
	// 질문 내역 조회_created_at_240605_by Minji
	@RequestMapping("qna.do")
	@ResponseBody
	public Map<String, Object> sListQna (Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
	         HttpServletResponse response, HttpSession session) throws Exception {
		
		logger.info("+ Start " + className + ".sListQna");
		logger.info("   - paramMap : " + paramMap);
		
		// 페이지 네비게이터 변수 선언하기
		int currentPage = Integer.parseInt((String)paramMap.get("currentPage"));
		int pageSize = Integer.parseInt((String)paramMap.get("pageSize"));
		int startPoint = (currentPage -1) * pageSize;
		
		paramMap.put("pageSize", pageSize);
		paramMap.put("startPoint", startPoint);
		
		
		Map<String, Object> sQnaMap = new HashMap<String, Object>();
		
		List<SQnaDto> listQna = sQnaService.sListQna(paramMap);
		
		int totalCount = sQnaService.totalCountQna(paramMap);
		
		// listQna 
		sQnaMap.put("listQna", listQna);
		sQnaMap.put("totalCount", totalCount);
	
		logger.info("+ End " + className + ".sListQna");
		
		return sQnaMap;
		
	}
	
	// 질문 내역 1건 상세 조회
	@RequestMapping("sSelectedQna.do")
	@ResponseBody
	public Map<String, Object> sSelectedQna(Model model,
			@RequestParam Map<String, Object> paramMap, 
			HttpServletRequest request, HttpServletResponse response,
			HttpSession session) throws Exception {
		
			logger.info("+ Start " + className + ".sSelectedQna");
			logger.info("   - paramMap : " + paramMap);

			Map<String, Object> sQnaOneMap = new HashMap<String, Object>();
			
			SQnaDto sqlReturn = sQnaService.sSelectedQna(paramMap);
			
			sQnaOneMap.put("result", sqlReturn);
			
			logger.info("+ End " + className + ".sSelectedQna");
	      
	      return sQnaOneMap;
	}
	
	// Qna 작성하기
	@RequestMapping("sInsertQna.do")
	@ResponseBody
	public Map<String, Object> sInsertQna(@RequestParam Map<String, Object> paramMap, 
				HttpSession session, HttpServletRequest request) throws Exception{
		
		logger.info("+ Start " + className + ".sInsertQna");
		logger.info("   - paramMap : " + paramMap);
		
		String action = (String) paramMap.get("action");
	    int sqlreturn = 0;
	    String resultmsg = "";
		
		paramMap.put("loginID", (String)session.getAttribute("loginID"));
		
		Map<String, Object> returnmap = new HashMap<String, Object>();
		
		if("I".equals(action)) {
	    	  sqlreturn = sQnaService.insertQna(paramMap);    	  
	      } else {
	    	  returnmap.put("result",-1);
	          returnmap.put("resultmsg","잘못된 요청 입니다.");
	          
	          return returnmap;		
	      }
		
		
		if("I".equals(action)) {
	    	  if(sqlreturn >= 0) {
	    	     resultmsg = "저장 되었습니다.";
	    	  } else {
	    		 resultmsg = "저장 실패 되었습니다.";
	    	  }
	      }
	      
	      returnmap.put("result",sqlreturn);
	      returnmap.put("resultmsg",resultmsg);
	      
	      logger.info("+ End " + className + ".sInsertQna");

	      return returnmap;
		
	}
	
	// Qna 삭제하기
		@RequestMapping("sDeleteQna.do")
		@ResponseBody
		public Map<String, Object> sDeleteQna(@RequestParam Map<String, Object> paramMap, 
					HttpSession session, HttpServletRequest request) throws Exception{
			
			logger.info("+ Start " + className + ".sDeleteQna");
			logger.info("   - paramMap : " + paramMap);
			
			String action = (String) paramMap.get("action");
		    int sqlreturn = 0;
		    String resultmsg = "";
			
			paramMap.put("loginID", (String)session.getAttribute("loginID"));
			
			Map<String, Object> returnmap = new HashMap<String, Object>();
			
			if("D".equals(action)) {
		    	  sqlreturn = sQnaService.deleteQna(paramMap);
		      } else {
		    	  returnmap.put("result",-1);
		          returnmap.put("resultmsg","잘못된 요청 입니다.");
		          
		          return returnmap;		
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
		      
		      logger.info("+ End " + className + ".sDeleteQna");

		      return returnmap;
			
		}
	
	
}
