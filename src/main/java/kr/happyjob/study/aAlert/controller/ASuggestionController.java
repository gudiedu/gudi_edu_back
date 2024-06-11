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

import kr.happyjob.study.aAlert.model.ASuggestionDTO;
import kr.happyjob.study.aAlert.service.ASuggestionService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class ASuggestionController {
	
	private final ASuggestionService aSuggestionService;
	
	private final Logger logger = LogManager.getLogger(this.getClass());
	
	//임시 URL
	@RequestMapping("/aSuggestion")
	public List<ASuggestionDTO> searchSuggestion(Model model,@RequestParam Map<String, Object> paramMap) throws Exception{
		return aSuggestionService.searchSuggestion(paramMap);
	}
	
	@RequestMapping("/aSuggestion/select")
	public Map<String, Object> selectSuggestion(@RequestParam Map<String, Object> paramMap) throws Exception{
		logger.info(paramMap);
		return aSuggestionService.selectSuggestion(paramMap);
	}
	
	@RequestMapping("/aSuggestion/reply/new")
	public void insertReply(@RequestParam Map<String, Object> paramMap, HttpSession session, HttpServletRequest request) throws Exception{
		paramMap.put("loginID", (String)session.getAttribute("loginId"));
		aSuggestionService.insertReply(paramMap, request);
	}
	
	@RequestMapping("/aSuggestion/reply/update")
	public void updateReply(@RequestParam Map<String, Object> paramMap, HttpSession session, HttpServletRequest request) throws Exception{
		paramMap.put("loginID", (String)session.getAttribute("loginId"));
		aSuggestionService.updateReply(paramMap, request);
	}
	
	@RequestMapping("aSuggestion/reply/delete")
	public void deleteReply(@RequestParam Map<String, Object> paramMap, HttpSession session) throws Exception{
		aSuggestionService.deleteReply(paramMap);
	}
	
	@RequestMapping("aSuggestion/delete")
	public void deleteSuggestion(@RequestParam Map<String, Object> paramMap, HttpSession session) throws Exception{
		aSuggestionService.deleteSuggestion(paramMap);
	}
	
	@RequestMapping("/aSuggestion/fileDownload")
	public void noticeFileDownload(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
	         HttpServletResponse response, HttpSession session) throws Exception {
	      
	      Map<String, Object> result = aSuggestionService.downloadFile(paramMap);
	      
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
