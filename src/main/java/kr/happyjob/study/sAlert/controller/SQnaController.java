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
	@RequestMapping("sQnaList.do")
	@ResponseBody
	public Map<String, Object> sQnaList (Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
	         HttpServletResponse response, HttpSession session) throws Exception {
		
		logger.info("+ Start " + className + ".sQnaList");
		logger.info("   - paramMap : " + paramMap);
		
		// 페이지 네비게이터 변수 선언하기
		int currentPage = Integer.parseInt((String)paramMap.get("currentPage"));
		int pageSize = Integer.parseInt((String)paramMap.get("pageSize"));
		int startPoint = (currentPage -1) * pageSize;
		
		paramMap.put("pageSize", pageSize);
		paramMap.put("startPoint", startPoint);
		
		logger.info("pageSize : " + pageSize);
		logger.info("startPoint : " + startPoint);
		
		
		Map<String, Object> returnMap = new HashMap<String, Object>();
		
		List<SQnaDto> listQna = sQnaService.sQnaList(paramMap);
		
		int totalCnt = sQnaService.totalCountQna(paramMap);
		
		// listQna
		returnMap.put("listQna", listQna);
		returnMap.put("totalCnt", totalCnt);
	
		logger.info("+ End " + className + ".sQnaList");
		
		return returnMap;
		
	}
	
	// Qna 작성하기
		@RequestMapping("sQnaInsert.do")
		@ResponseBody
		public Map<String, Object> sQnaInsert(@RequestParam Map<String, Object> paramMap, 
					HttpSession session, HttpServletRequest request) throws Exception{
			
			logger.info("+ Start " + className + ".sQnaInsert");
			logger.info("   - paramMap : " + paramMap);

			Map<String, Object> returnMap = new HashMap<String, Object>();
			
			int sqlReturn = 0;
		    String resultMsg = "";
			
			paramMap.put("loginID", (String)session.getAttribute("loginId"));
			sqlReturn = sQnaService.sQnaInsert(paramMap, request);
			
			if(sqlReturn >= 0){
		    	  resultMsg = "저장 되었습니다.";
		      }else{
		    	  resultMsg = "저장 실패 되었습니다.";
		      }
		      
			 returnMap.put("result", sqlReturn);
		     returnMap.put("resultMsg", resultMsg);
		      
		      logger.info("+ End " + className + ".sQnaInsert");

		      return returnMap;
			
		}
	
	// 질문 내역 1건 상세 조회
	@RequestMapping("sQnaSelected.do")
	@ResponseBody
	public Map<String, Object> sQnaSelected(Model model,
			@RequestParam Map<String, Object> paramMap, 
			HttpServletRequest request, HttpServletResponse response,
			HttpSession session) throws Exception {
		
			logger.info("+ Start " + className + ".sQnaSelected");
			logger.info("   - paramMap : " + paramMap);

			Map<String, Object> returnMap = new HashMap<String, Object>();
			
			SQnaDto sQnaSelectedOne = sQnaService.sQnaSelected(paramMap);
			returnMap.put("result", sQnaSelectedOne);
			
			logger.info("+ End " + className + ".sSelectedQna");
	      
	      return returnMap;
	}
	
	// 강의 등록을 위한 수강생 강의명 가져오기
	@RequestMapping("sQnaGetCourseName.do")
	@ResponseBody
	public Map<String, Object> sQnaGetCourseName(Model model,
			@RequestParam Map<String, Object> paramMap,
			HttpServletRequest request, HttpServletResponse response,
			HttpSession session) throws Exception{
		
		logger.info("+ Start " + className + ".sQnaGetCourseName");
		logger.info("   - paramMap : " + paramMap);
		
		Map<String, Object> returnMap = new HashMap<String, Object>();
		
		paramMap.put("loginID", (String)session.getAttribute("loginId"));
		
		List<SQnaDto> sQnaGetCourseName = sQnaService.sQnaGetCourseName(paramMap);
		returnMap.put("sQnaGetCourseName", sQnaGetCourseName);
		
		logger.info("+ End " + className + ".sQnaGetCourseName");
		
		return returnMap;
	}
	
	// Qna 삭제하기
		@RequestMapping("sQnaDelete.do")
		@ResponseBody
		public Map<String, Object> sQnaDelete(@RequestParam Map<String, Object> paramMap, 
					HttpSession session, HttpServletRequest request) throws Exception{
			
			logger.info("+ Start " + className + ".sDeleteQna");
			logger.info("   - paramMap : " + paramMap);
			
			String action = (String) paramMap.get("action");
		    int sqlreturn = 0;
		    String resultmsg = "";
			
			paramMap.put("loginID", (String)session.getAttribute("loginID"));
			
			Map<String, Object> returnmap = new HashMap<String, Object>();
			
			if("D".equals(action)) {
		    	  sqlreturn = sQnaService.sQnaDelete(paramMap);
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
