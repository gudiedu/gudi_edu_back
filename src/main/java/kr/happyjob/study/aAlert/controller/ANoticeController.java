package kr.happyjob.study.aAlert.controller;

import java.io.File;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.happyjob.study.aAlert.model.ANoticeDTO;
import kr.happyjob.study.aAlert.service.ANoticeService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class ANoticeController {
	private final ANoticeService aNoticeService;
	
	private final Logger logger = LogManager.getLogger(this.getClass());
	
	//임시 URL
	@RequestMapping("/aAlert")
	public List<ANoticeDTO> searchNotice(Model model,@RequestParam Map<String, Object> paramMap){
		List<ANoticeDTO> result =  aNoticeService.searchNotice(paramMap);
		return result;
	}
	
	//임시 URL
	@RequestMapping("/aAlert/notice")
	public Map<String, Object> selectNotice(Model model,@RequestParam Map<String, Object> paramMap){
		Map<String, Object> resultMap = aNoticeService.selectNotice(paramMap);
		logger.info(resultMap);
		return resultMap;
	}
	
	//임시 URL
	@RequestMapping("/aAlert/notice/new")
	public void insertNotice(@RequestParam Map<String, Object> paramMap, HttpSession session, HttpServletRequest request) throws Exception{
		paramMap.put("loginID", (String)session.getAttribute("loginId"));
		aNoticeService.insertNotice(paramMap, request);
	}
	
	@RequestMapping("/aAlert/notice/update")
	public void updateNotice(@RequestParam Map<String, Object> paramMap, HttpSession session, HttpServletRequest request) throws Exception{
		paramMap.put("loginID", (String)session.getAttribute("loginId"));
		aNoticeService.updateNotice(paramMap, request);
	}
	
	//임시 URL
	@RequestMapping("/aAlert/notice/delete")
	public void deleteNotice(@RequestParam Map<String, Object> paramMap) throws Exception{
		aNoticeService.deleteNotice(paramMap);
	}
	
	@RequestMapping("/aAlert/notice/fileDownload")
	public void noticeFileDownload(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
	         HttpServletResponse response, HttpSession session) throws Exception {
	      
	      Map<String, Object> result = aNoticeService.selectNotice(paramMap);
	      //sqlReturn.getFile_name()
	      //sqlReturn.getPhygical_path() //실제 파일 경로를 되돌려줌
	      
	      byte fileByte[] = FileUtils.readFileToByteArray(new File(result.get("file_server_path").toString()));
	      
	      response.setContentType("application/octet-stream");
	      response.setContentLength(fileByte.length);
	      response.setHeader("Content-Disposition", "attachment; fileName=\"" + URLEncoder.encode(result.get("file_origin").toString(),"UTF-8")+"\";");
	      response.setHeader("Content-Transfer-Encoding", "binary");
	      response.getOutputStream().write(fileByte); 
	      response.getOutputStream().flush();
	      response.getOutputStream().close();

	   }
}
