package kr.happyjob.study.sAlert.controller;

import java.io.File;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
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
	SSuggestionService sSuggestionService;
	
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
	      
	      int currentPage = Integer.parseInt((String)paramMap.get("currentPage"));
	      int pageSize = Integer.parseInt((String)paramMap.get("pageSize"));
	      
	      int startPoint = (currentPage - 1) * pageSize;
	      
	      paramMap.put("startPoint", startPoint);
	      paramMap.put("pageSize", pageSize);
	      
	      Map<String, Object> returnMap = new HashMap<String, Object>();
	      
	      List<SSuggestionDto> listData = sSuggestionService.sSuggestionList(paramMap);
	      int totalCnt = sSuggestionService.totalCntResource(paramMap);
	      
	      returnMap.put("listData", listData);
	      returnMap.put("totalCnt", totalCnt);
	      
	      logger.info("+ End " + className + ".sSuggestionList");
	      
	      return returnMap;
	   }
	
	@RequestMapping("sInsertSuggestion.do")
	@ResponseBody
	 public Map<String, Object> sInsertSuggestion(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
	         HttpServletResponse response, HttpSession session) throws Exception {
		  
		  logger.info("+ Start " + className + ".sInsertSuggestion");
	      logger.info("   - paramMap : " + paramMap);
	      
	      Map<String, Object> returnMap = new HashMap<String, Object>();
	      
	      int sqlReturn = 0;
	      String resultMsg = "";
	      
	      paramMap.put("loginID", (String)session.getAttribute("loginId"));
	      sqlReturn = sSuggestionService.sInsertSuggestion(paramMap, request);
	      
	      if(sqlReturn >= 0){
	    	  resultMsg = "저장 되었습니다.";
	      }else{
	    	  resultMsg = "저장 실패 되었습니다.";
	      }
	      
	      returnMap.put("result", sqlReturn);
	      returnMap.put("resultMsg", resultMsg);
	      
	      logger.info("+ End " + className + ".sInsertSuggestion");
	      
	      return returnMap;
	   }
	
	@RequestMapping("sDeleteSuggestion.do")
	@ResponseBody
	 public Map<String, Object> sDeleteSuggestion(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
	         HttpServletResponse response, HttpSession session) throws Exception {
		  
		  logger.info("+ Start " + className + ".sDeleteSuggestion");
	      logger.info("   - paramMap : " + paramMap);
	      
	      String loginId = (String)session.getAttribute("loginId");
	      paramMap.put("loginID", loginId);
	      
	      Map<String, Object> returnMap = new HashMap<String, Object>();
	      
	      int sqlReturn = 0;
	      String resultMsg = "";
	      
	      sqlReturn = sSuggestionService.sDeleteSuggestion(paramMap);
	      
	      if(sqlReturn >= 0){
	    	  resultMsg = "삭제 되었습니다.";
	      }else{
	    	  resultMsg = "삭제 실패 되었습니다.";
	      }
	      
	      returnMap.put("result", sqlReturn);
	      returnMap.put("resultMsg", resultMsg);
	      
	      logger.info("+ End " + className + ".sDeleteSuggestion");
	      
	      return returnMap;
	   }
	
	@RequestMapping("sSelectSuggestion.do")
	@ResponseBody
	 public Map<String, Object> sSelectSuggestion(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
	         HttpServletResponse response, HttpSession session) throws Exception {
		  
		  logger.info("+ Start " + className + ".sSelectSuggestion");
	      logger.info("   - paramMap : " + paramMap);
	      
	      String loginId = (String)session.getAttribute("loginId");
	      
	      Map<String, Object> returnMap = new HashMap<String, Object>();
	      
	      SSuggestionDto listData = sSuggestionService.sSelectSuggestion(paramMap);
	      
	      returnMap.put("result", listData);
	      returnMap.put("loginId", loginId);
	      
	      logger.info("+ End " + className + ".sSelectSuggestion");
	      
	      return returnMap;
	   }
	
	@RequestMapping("sSelectSuggestionReply.do")
	@ResponseBody
	 public Map<String, Object> sSelectSuggestionReply(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
	         HttpServletResponse response, HttpSession session) throws Exception {
		  
		  logger.info("+ Start " + className + ".sSelectSuggestionReply");
	      logger.info("   - paramMap : " + paramMap);
	      
	      Map<String, Object> returnMap = new HashMap<String, Object>();
	      
	      SSuggestionDto listData = sSuggestionService.sSelectSuggestionReply(paramMap);
	      
	      returnMap.put("result", listData);
	      
	      logger.info("+ End " + className + ".sSelectSuggestionReply");
	      
	      return returnMap;
	   }
	
	@RequestMapping("suggestionFileDownload.do")
	@ResponseBody
	   public void suggestionFileDownload(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
	         HttpServletResponse response, HttpSession session) throws Exception {
	      
	      logger.info("+ Start " + className + ".suggestionFileDownload");
	      logger.info("   - paramMap : " + paramMap);
	      
	      SSuggestionDto sqlReturn = sSuggestionService.sSelectSuggestion(paramMap);
	      //sqlReturn.getFile_name()
	      //sqlReturn.getPhygical_path() //실제 파일 경로를 되돌려줌
	      
	      byte fileByte[] = FileUtils.readFileToByteArray(new File(sqlReturn.getFile_server_path()));
	      
	      response.setContentType("application/octet-stream");
	      response.setContentLength(fileByte.length);
	      response.setHeader("Content-Disposition", "attachment; fileName=\"" + URLEncoder.encode(sqlReturn.getFile_origin(),"UTF-8")+"\";");
	      response.setHeader("Content-Transfer-Encoding", "binary");
	      response.getOutputStream().write(fileByte); 
	      response.getOutputStream().flush();
	      response.getOutputStream().close();

	      logger.info("+ End " + className + ".suggestionFileDownload");
	      
	      return;
	   }
	
	@RequestMapping("suggestionReplyFileDownload.do")
	@ResponseBody
	   public void suggestionReplyFileDownload(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
	         HttpServletResponse response, HttpSession session) throws Exception {
	      
	      logger.info("+ Start " + className + ".suggestionFileDownload");
	      logger.info("   - paramMap : " + paramMap);
	      
	      SSuggestionDto sqlReturn = sSuggestionService.sSelectSuggestionReply(paramMap);
	      //sqlReturn.getFile_name()
	      //sqlReturn.getPhygical_path() //실제 파일 경로를 되돌려줌
	      
	      byte fileByte[] = FileUtils.readFileToByteArray(new File(sqlReturn.getFile_server_path()));
	      
	      response.setContentType("application/octet-stream");
	      response.setContentLength(fileByte.length);
	      response.setHeader("Content-Disposition", "attachment; fileName=\"" + URLEncoder.encode(sqlReturn.getFile_origin(),"UTF-8")+"\";");
	      response.setHeader("Content-Transfer-Encoding", "binary");
	      response.getOutputStream().write(fileByte); 
	      response.getOutputStream().flush();
	      response.getOutputStream().close();

	      logger.info("+ End " + className + ".suggestionFileDownload");
	      
	      return;
	   }
}