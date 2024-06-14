package kr.happyjob.study.tAlert.controller;

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

import kr.happyjob.study.tAlert.model.tNoticeVO;
import kr.happyjob.study.tAlert.service.tNoticeService;


@Controller
@RequestMapping("/tAlert/")
public class tNoticeController {

	@Autowired
	tNoticeService tNoticeService;
	
	   // Set logger
	   private final Logger logger = LogManager.getLogger(this.getClass());

	   // Get class name for logger
	   private final String className = this.getClass().toString();
	   
	
	   //공지사항 조회 검색
	   @RequestMapping("searchNotice.do")
	   @ResponseBody
	   public Map<String, Object> searchNotice(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
		         HttpServletResponse response, HttpSession session) throws Exception {
		      
		      logger.info("+ Start " + className + ".searchNotice");
		      logger.info("   - paramMap : " + paramMap);
		      
		      // 1 page : 0  2 page : 10   
		      
		      int currentpage = Integer.parseInt((String) paramMap.get("currentPage"));
		      int pagesize = Integer.parseInt((String) paramMap.get("pageSize"));
		      int startpoint = (currentpage - 1) * pagesize;
		      
		      paramMap.put("pagesize", pagesize);
		      paramMap.put("startpoint", startpoint);
		      paramMap.put("pageSize", Integer.parseInt((String) paramMap.get("pageSize")));
		      
		      
		      Map<String, Object> returnmap = new HashMap<String, Object>();
		      
		      List<tNoticeVO> listdata = tNoticeService .searchNotice(paramMap);
		      
		      
		      int totalcnt = tNoticeService .totalcntNotice(paramMap);
		      
		      returnmap.put("listdata",listdata);
		      returnmap.put("totalcnt",totalcnt);
		      
		      logger.info("+ End " + className + ".listquestion");

		      return returnmap;
		   }

	   // 공지사항 등록
	    @RequestMapping("insertNotice.do")
		@ResponseBody
		public Map<String, Object> insertNotice(@RequestParam Map<String, Object> paramMap, 
					HttpSession session, HttpServletRequest request) throws Exception{
			
			logger.info("+ Start " + className + ".insertNotice");
			logger.info("   - paramMap : " + paramMap);

			
			Map<String, Object> returnMap = new HashMap<String, Object>();
			
			int sqlReturn = 0;
		    String resultMsg = "";
		    
		    
		    logger.info("   - loginID from session: " + session.getAttribute("loginId"));
		    			
			paramMap.put("loginID",(String)session.getAttribute("loginId"));
			
			 logger.info("   - paramMap after adding loginID: " + paramMap); // 추가된 로그
			
			
			sqlReturn = tNoticeService.insertNotice(paramMap, request);
		
			
			if(sqlReturn >= 0){
		    	  resultMsg = "저장 되었습니다.";
		      }else{
		    	  resultMsg = "저장 실패 되었습니다.";
		      }
		      
			 returnMap.put("result", sqlReturn);
		     returnMap.put("resultMsg", resultMsg);
		      
		      logger.info("+ End " + className + ".insertNotice");

		      return returnMap;
			
		}  
	    
	    @RequestMapping("selectNotice.do")
		@ResponseBody
		 public Map<String, Object> sSelectNotice(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
		         HttpServletResponse response, HttpSession session) throws Exception {
			  
			  logger.info("+ Start " + className + ".selectNotice");
		      logger.info("   - paramMap : " + paramMap);
		      
		      Map<String, Object> returnMap = new HashMap<String, Object>();
		      
		      tNoticeVO listData = tNoticeService.selectNotice(paramMap);
		      
		      returnMap.put("result", listData);
		      
		      logger.info("+ End " + className + ".sSelectNotice");
		      
		      return returnMap;
		   }
	    
	   
	    @RequestMapping("deleteNotice.do")
		@ResponseBody
		 public Map<String, Object> sDeleteNotice(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
		         HttpServletResponse response, HttpSession session) throws Exception {
			  
			  logger.info("+ Start " + className + ".deleteNotice");
		      logger.info("   - paramMap : " + paramMap);
		      
		      Map<String, Object> returnMap = new HashMap<String, Object>();
		      
		      int sqlReturn = 0;
		      String resultMsg = "";
		      
		      sqlReturn = tNoticeService.deleteNotice(paramMap);
		      
		      if(sqlReturn >= 0){
		    	  resultMsg = "삭제 되었습니다.";
		      }else{
		    	  resultMsg = "삭제 실패 되었습니다.";
		      }
		      
		      returnMap.put("result", sqlReturn);
		      returnMap.put("resultMsg", resultMsg);
		      
		      logger.info("+ End " + className + ".deleteNotice");
		      
		      return returnMap;
		   }
		
		
	    @RequestMapping("noticeFileDownload.do")
		@ResponseBody
		   public void noticeFileDownload(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
		         HttpServletResponse response, HttpSession session) throws Exception {
		      
		      logger.info("+ Start " + className + ".noticeFileDownload");
		      logger.info("   - paramMap : " + paramMap);
		      
		      tNoticeVO sqlReturn = tNoticeService.selectNotice(paramMap);
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