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

import kr.happyjob.study.sAlert.dto.SNoticeDto;
import kr.happyjob.study.sAlert.service.SNoticeService;

@Controller
@RequestMapping("/sAlert/")
public class SNoticeController {
	
	@Autowired
	SNoticeService sNoticeService;
	
	// Set logger
	private final Logger logger = LogManager.getLogger(this.getClass());

	// Get class name for logger
	private final String className = this.getClass().toString();
	
	@RequestMapping("sNoticeList.do")
	@ResponseBody
	 public Map<String, Object> sNoticeList(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
	         HttpServletResponse response, HttpSession session) throws Exception {
		  
		  logger.info("+ Start " + className + ".sNoticeList");
	      logger.info("   - paramMap : " + paramMap);
		
	      int currentPage = Integer.parseInt((String)paramMap.get("currentPage"));
	      int pageSize = Integer.parseInt((String)paramMap.get("pageSize"));
	      
	      int startPoint = (currentPage - 1) * pageSize;
	      
	      paramMap.put("startPoint", startPoint);
	      paramMap.put("pageSize", pageSize);
	      
	      Map<String, Object> returnMap = new HashMap<String, Object>();
	      
	      List<SNoticeDto> listData = sNoticeService.sListNotice(paramMap);
	      int totalCnt = sNoticeService.totalCntNotice(paramMap);
	      
	      returnMap.put("listData", listData);
	      returnMap.put("totalCnt", totalCnt);
	      
	      logger.info("+ End " + className + ".sNoticeList");
	      
	      return returnMap;
	   }
	
	@RequestMapping("sSelectNotice.do")
	@ResponseBody
	   public Map<String, Object> sSelectNotice(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
	         HttpServletResponse response, HttpSession session) throws Exception {
	      
	      logger.info("+ Start " + className + ".sSelectNotice");
	      logger.info("   - paramMap : " + paramMap);
	      
	      Map<String, Object> returnMap = new HashMap<String, Object>();
	      
	      SNoticeDto sqlReturn = sNoticeService.sSelectNotice(paramMap);
	    	 
	      returnMap.put("result", sqlReturn);
	      
	      logger.info("+ End " + className + ".sSelectNotice");
	      
	      return returnMap;
	   }
	
	@RequestMapping("noticeFileDownload.do")
	@ResponseBody
	   public void noticeFileDownload(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
	         HttpServletResponse response, HttpSession session) throws Exception {
	      
	      logger.info("+ Start " + className + ".noticeFileDownload");
	      logger.info("   - paramMap : " + paramMap);
	      
	      SNoticeDto sqlReturn = sNoticeService.sSelectNotice(paramMap);
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

	      logger.info("+ End " + className + ".noticeFileDownload");
	      
	      return;
	   }
}