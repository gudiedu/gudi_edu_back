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
	
	// Qna 답변 작성하기
			@RequestMapping("insertquestionreply.do")
			@ResponseBody
			public Map<String, Object> insertquestionreply(@RequestParam Map<String, Object> paramMap, 
						HttpSession session, HttpServletRequest request) throws Exception{
				
				logger.info("+ Start " + className + ".insertquestionreply");
				logger.info("   - paramMap : " + paramMap);

				Map<String, Object> returnMap = new HashMap<String, Object>();
				
				int sqlReturn = 0;
			    String resultMsg = "";
			    String reply_content = (String) paramMap.get("reply_content");
			    
			    
			    if (reply_content == null || reply_content.trim().isEmpty()) {
			        resultMsg = "답변 내용을 입력해 주세요.";
			        returnMap.put("result", -1); // 실패 상태 코드
			        returnMap.put("resultMsg", resultMsg);
			        logger.info("   - reply_content : " + reply_content);
			        logger.info("+ End " + className + ".insertquestionreply");
			        return returnMap;
			    }
			    
			    paramMap.put("reply_content", reply_content);
				paramMap.put("loginID", (String)session.getAttribute("loginId"));
				sqlReturn = questionReplyService.insertquestionreply(paramMap, request);
				
				
				if(sqlReturn >= 0){
			    	  resultMsg = "저장 되었습니다.";
			      }else{
			    	  resultMsg = "저장 실패 되었습니다.";
			      }
			      
				 returnMap.put("result", sqlReturn);
			     returnMap.put("resultMsg", resultMsg);
			      
			      logger.info("+ End " + className + ".insertquestionreply");

			      return returnMap;
				
			}
	   
				// Qna 답변 수정하기
				@RequestMapping("updatequestionreply.do")
				@ResponseBody
				public Map<String, Object> updatequestionreply(@RequestParam Map<String, Object> paramMap, HttpSession session,
						HttpServletRequest request) throws Exception {
			
					logger.info("+ Start " + className + ".updatequestionreply");
					logger.info("   - paramMap : " + paramMap);
			
					Map<String, Object> returnMap = new HashMap<String, Object>();
			
					int sqlReturn = 0;
					String resultMsg = "";
			
					paramMap.put("loginID", (String) session.getAttribute("loginId"));
					sqlReturn = questionReplyService.updatequestionreply(paramMap, request);
			
					if (sqlReturn >= 0) {
						resultMsg = "수정 되었습니다.";
					} else {
						resultMsg = "수정 실패 되었습니다.";
					}
			
					returnMap.put("result", sqlReturn);
					returnMap.put("resultMsg", resultMsg);
			
					logger.info("+ End " + className + ".updatequestionreply");
			
					return returnMap;
			
				}
			
			// Qna 삭제하기
			@RequestMapping("deletequestionreply.do")
			@ResponseBody
			public Map<String, Object> deletequestionreply(@RequestParam Map<String, Object> paramMap, 
						HttpSession session, HttpServletRequest request) throws Exception{
				
				logger.info("+ Start " + className + ".deletequestionreply");
				logger.info("   - paramMap : " + paramMap);
				
				Map<String, Object> returnMap = new HashMap<String, Object>();
				
			    int sqlReturn = 0;
			    String resultmsg = "";
				
				paramMap.put("loginID", (String)session.getAttribute("loginID"));
				sqlReturn = questionReplyService.deletequestionreply(paramMap, request);
				
				if (sqlReturn >= 0) {
					resultmsg = "삭제했습니다.";
				} else {
					resultmsg = "삭제에 실패했습니다.";
				}
		
				returnMap.put("result", sqlReturn);
				returnMap.put("resultMsg", resultmsg);
		
				logger.info("+ End " + className + ".deletequestionreply");
		
				return returnMap;
		
			}
	   
				/*//
				@RequestMapping("deletequestionreply.do")
				@ResponseBody
				public Map<String, Object> deleteQuestionReply(@RequestParam Map<String, Object> paramMap, HttpSession session) throws Exception {
			        Map<String, Object> returnMap = new HashMap<>();
			        int result = questionReplyService.deleteQuestionReply(paramMap);

			        if(result > 0) {
			            returnMap.put("result", 1);
			            returnMap.put("resultMsg", "삭제되었습니다.");
			        } else {
			            returnMap.put("result", -1);
			            returnMap.put("resultMsg", "삭제 실패했습니다.");
			        }

			        return returnMap;
			    }
				 */
				
				
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
	   
	   
	   
	   
