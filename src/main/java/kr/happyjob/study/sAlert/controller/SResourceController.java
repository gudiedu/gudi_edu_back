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

import kr.happyjob.study.sAlert.dto.SResourceDto;
import kr.happyjob.study.sAlert.service.SResourceService;

@Controller
@RequestMapping("/sAlert/")
public class SResourceController {
	
	@Autowired
	SResourceService sResourceService;
	
	// Set logger
	private final Logger logger = LogManager.getLogger(this.getClass());

	// Get class name for logger
	private final String className = this.getClass().toString();
	
	@RequestMapping("sListResources.do")
	@ResponseBody
	 public Map<String, Object> sListResources(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
	         HttpServletResponse response, HttpSession session) throws Exception {
		  
		  logger.info("+ Start " + className + ".sResources");
	      logger.info("   - paramMap : " + paramMap);
		
	      int currentPage = Integer.parseInt((String)paramMap.get("currentPage"));
	      int pageSize = Integer.parseInt((String)paramMap.get("pageSize"));
	      
	      int startPoint = (currentPage - 1) * pageSize;
	      
	      paramMap.put("startPoint", startPoint);
	      paramMap.put("pageSize", pageSize);
	      
	      Map<String, Object> returnMap = new HashMap<String, Object>();
	      
	      List<SResourceDto> listData = sResourceService.sListResources(paramMap);
	      int totalCnt = sResourceService.totalCntResource(paramMap);
	      
	      returnMap.put("listData", listData);
	      returnMap.put("totalCnt", totalCnt);
	      
	      logger.info("+ End " + className + ".sResources");
	      
	      return returnMap;
	   }
	
	@RequestMapping("sSelectResource.do")
	@ResponseBody
	   public Map<String, Object> sSelectResource(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
	         HttpServletResponse response, HttpSession session) throws Exception {
	      
	      logger.info("+ Start " + className + ".sSelectResource");
	      logger.info("   - paramMap : " + paramMap);
	      
	      Map<String, Object> returnMap = new HashMap<String, Object>();
	      
	      SResourceDto sqlReturn = sResourceService.sSelectResource(paramMap);
	    	  
	      returnMap.put("result", sqlReturn);
	      
	      logger.info("+ End " + className + ".sSelectResource");
	      
	      return returnMap;
	   }
	
	@RequestMapping("resourceFileDownload.do")
	@ResponseBody
	   public void resourceFileDownload(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
	         HttpServletResponse response, HttpSession session) throws Exception {
	      
	      logger.info("+ Start " + className + ".resourceFileDownload");
	      logger.info("   - paramMap : " + paramMap);
	      
	      SResourceDto sqlReturn = sResourceService.sSelectResource(paramMap);
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

	      logger.info("+ End " + className + ".resourceFileDownload");
	      
	      return;
	   }
}