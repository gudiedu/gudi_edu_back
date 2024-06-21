package kr.happyjob.study.information.controller;

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
import org.springframework.web.multipart.MultipartHttpServletRequest;

import kr.happyjob.study.aAlert.model.AFileDTO;
import kr.happyjob.study.common.comnUtils.FileUtilCho;
import kr.happyjob.study.information.dto.AAttendanceDTO;
import kr.happyjob.study.information.service.AStudentAttendanceService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class AStudentAttendanceController {
	
	private final AStudentAttendanceService aStudentAttendanceService;
	
	private final Logger logger = LogManager.getLogger(this.getClass());
	
	/**
	 * 수강중인 강의 조회
	 * @author JongGon Woo
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/aInformation/student")
	public List<Map<String, Object>> searchLecture(@RequestParam Map<String, Object> paramMap) throws Exception{
		List<Map<String, Object>> result = aStudentAttendanceService.searchLecture(paramMap);
		logger.info(result);
		return result;
	}
	
	/**
	 * 특정 강의의 출석 현황 조회
	 * @author JongGon Woo
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/aInformation/student/attendance")
	public List<AAttendanceDTO> searchAttendance(@RequestParam Map<String, Object> paramMap) throws Exception{
		
		return aStudentAttendanceService.searchAttendance(paramMap);
	}
	
	/**
	 * 출석 상태 변경
	 * @author JongGon Woo
	 * @param paramMap
	 * @throws Exception
	 */
	@RequestMapping("/aInformation/student/attendance/status")
	public void updateStatus(@RequestParam Map<String, Object> paramMap) throws Exception{
		logger.info(paramMap);
		aStudentAttendanceService.updateAttendanceStatus(paramMap);
	}
	
	/**
	 * 출석 증빙 서류 업로드
	 * @author JongGon Woo
	 * @param paramMap
	 * @param request
	 * @param response
	 * @param session
	 * @throws Exception
	 */
	@RequestMapping("/aInformation/student/attendance/fileUpload")
	public void uploadFile(@RequestParam Map<String, Object> paramMap, HttpServletRequest request,
	         HttpServletResponse response, HttpSession session) throws Exception{
		logger.info(paramMap);
		aStudentAttendanceService.uploadAttendanceFile(paramMap, request);
		
	}
	
	/**
	 * 파일 다운로드
	 * @author JongGon woo
	 * @param model
	 * @param paramMap
	 * @param request
	 * @param response
	 * @param session
	 * @throws Exception
	 */
	@RequestMapping("/aInformation/student/attendance/downloadFile")
	public void downloadFile(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
	         HttpServletResponse response, HttpSession session) throws Exception {
	      
	      AFileDTO result = aStudentAttendanceService.downloadFile(paramMap);
	      
	      byte fileByte[] = FileUtils.readFileToByteArray(new File(result.getFile_server_path()));
	      
	      response.setContentType("application/octet-stream");
	      response.setContentLength(fileByte.length);
	      response.setHeader("Content-Disposition", "attachment; fileName=\"" + URLEncoder.encode(result.getFile_origin(),"UTF-8")+"\";");
	      response.setHeader("Content-Transfer-Encoding", "binary");
	      response.getOutputStream().write(fileByte); 
	      response.getOutputStream().flush();
	      response.getOutputStream().close();

	}
	
	/**
	 * 첨부파일 삭제
	 * @author JongGon Woo
	 * @param paramMap
	 * @throws Exception
	 */
	@RequestMapping("/aInformation/student/attendance/deleteFile")
	public void deleteFile(@RequestParam Map<String, Object> paramMap) throws Exception{
		aStudentAttendanceService.deleteFile(paramMap);
	}

}
