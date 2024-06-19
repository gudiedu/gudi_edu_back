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
	
	/** 
	 *  공지사항 전체 조회
	 *  @author JongGon Woo
	 *  @param paramMap - 검색어
	 *  @return 공지사항 목록
	 */
	@RequestMapping("/aAlert")
	public List<ANoticeDTO> searchNotice(Model model,@RequestParam Map<String, Object> paramMap) throws Exception{
		List<ANoticeDTO> result =  aNoticeService.searchNotice(paramMap);
		return result;
	}
	
	/**
	 * 특정 공지사항 조회
	 * @author JongGon Woo
	 * @param model  
	 * @param paramMap - 공지사항 번호 및 조회,수정 여부를 결정하는 action 변수
	 * @return - 조회한 공지사항 정보
	 */
	@RequestMapping("/aAlert/notice")
	public Map<String, Object> selectNotice(Model model,@RequestParam Map<String, Object> paramMap) throws Exception{
		Map<String, Object> resultMap = aNoticeService.selectNotice(paramMap);
		logger.info(resultMap);
		return resultMap;
	}
	
	/** 
	 * 공지사항 저장
	 * @author JongGon WOo
	 * @param paramMap - 공지사항 제목, 공지사항 본문 
	 * @param session
	 * @param request - 업로드 파일
	 * @throws Exception
	 */
	@RequestMapping("/aAlert/notice/new")
	public void insertNotice(@RequestParam Map<String, Object> paramMap, HttpSession session, HttpServletRequest request) throws Exception{
		paramMap.put("loginID", (String)session.getAttribute("loginId"));
		aNoticeService.insertNotice(paramMap, request);
	}
	
	/**
	 * 공지사항 수정
	 * @author JongGon Woo
	 * @param paramMap - 공지사항 번호, 공지사항 제목, 공지사항 본문
	 * @param session
	 * @param request - 업로드 파일
	 * @throws Exception
	 */
	@RequestMapping("/aAlert/notice/update")
	public void updateNotice(@RequestParam Map<String, Object> paramMap, HttpSession session, HttpServletRequest request) throws Exception{
		paramMap.put("loginID", (String)session.getAttribute("loginId"));
		aNoticeService.updateNotice(paramMap, request);
	}
	
	/**
	 * 공지사항 삭제
	 * @author JongGon Woo
	 * @param paramMap - 삭제할 공지사항 번호
	 * @throws Exception
	 */
	@RequestMapping("/aAlert/notice/delete")
	public void deleteNotice(@RequestParam Map<String, Object> paramMap) throws Exception{
		aNoticeService.deleteNotice(paramMap);
	}
	
	/**
	 * 파일 다운로드
	 * @author JongGon Woo
	 * @param model
	 * @param paramMap - 다운로드 받을 파일이 있는 공지사항 번호
	 * @param request
	 * @param response
	 * @param session
	 * @throws Exception
	 */
	@RequestMapping("/aAlert/notice/fileDownload")
	public void noticeFileDownload(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
	         HttpServletResponse response, HttpSession session) throws Exception {
	      
	      Map<String, Object> result = aNoticeService.selectNotice(paramMap);
	      
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
