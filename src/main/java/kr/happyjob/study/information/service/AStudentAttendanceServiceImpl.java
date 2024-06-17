package kr.happyjob.study.information.service;

import java.io.File;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import kr.happyjob.study.aAlert.model.AFileDTO;
import kr.happyjob.study.common.comnUtils.FileUtilCho;
import kr.happyjob.study.information.dao.AStudentAttendanceDAO;
import kr.happyjob.study.information.dto.AAttendanceDTO;
import kr.happyjob.study.information.dto.AUserInfoDTO;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AStudentAttendanceServiceImpl implements AStudentAttendanceService {
	
	private final AStudentAttendanceDAO aStudentAttendanceDAO;

	private final Logger logger = LogManager.getLogger(this.getClass());

	@Value("${fileUpload.rootPath}")
	private String rootPath;

	@Value("${fileUpload.virtualRootPath}")
	private String virtualRootPath;

	@Value("${fileUpload.attendancePath}")
	private String attendancePath;

	@Override
	public List<Map<String, Object>> searchLecture(Map<String, Object> paramMap) throws Exception {
		List<Map<String,Object>>result = aStudentAttendanceDAO.searchLecture(paramMap);
		Map<String, Object> studentName = aStudentAttendanceDAO.findStudentName(paramMap);
		result.add(studentName);
		
		return result;
	}
	
	@Override
	public List<AAttendanceDTO> searchAttendance(Map<String, Object> paramMap) throws Exception {
		return aStudentAttendanceDAO.searchAttendance(paramMap);
	}
	
	@Override
	public int updateAttendanceStatus(Map<String, Object> paramMap) throws Exception {
		return aStudentAttendanceDAO.updateAttendanceStatus(paramMap);
	}
	
	@Override
	public int uploadAttendanceFile(Map<String, Object> paramMap, HttpServletRequest request) throws Exception {
		Map<String, Object> fileInfo = fileUpload(request);
		paramMap.put("fileInfo", fileInfo);
		
		int fileNo = saveFile(fileInfo);
		paramMap.put("fileExits","Y");
		paramMap.put("file_no", fileNo);
		logger.info(paramMap);
		
		int isUpdate = aStudentAttendanceDAO.updateAttendanceStatus(paramMap);
		return isUpdate;
	}
	
	private Map<String, Object> fileUpload(HttpServletRequest request) throws Exception{
		
		MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;
		
		String itemFilePath = attendancePath + File.separator;
		FileUtilCho fileUpload = new FileUtilCho(multipartHttpServletRequest, rootPath, virtualRootPath, itemFilePath);
		Map<String, Object> fileInfo = fileUpload.uploadFiles();
		
		return fileInfo;
	}
	
	private int saveFile(Map<String,Object> fileInfo) throws Exception{
		
		AFileDTO file = new AFileDTO();
		
		file.setFile_origin(fileInfo.get("file_nm").toString());
		file.setFile_local_path(fileInfo.get("vrfile_loc").toString());
		file.setFile_server_path(fileInfo.get("file_loc").toString());
		file.setFile_extension(fileInfo.get("fileExtension").toString());
		file.setFile_size(Integer.parseInt(fileInfo.get("file_size").toString()));
		
		aStudentAttendanceDAO.saveFile(file);
		
		return file.getFile_no();
	}
	
	@Override
	public int deleteFile(Map<String, Object> paramMap) throws Exception {
		paramMap.put("fileDelete", true);
		
		return aStudentAttendanceDAO.updateAttendanceStatus(paramMap);
	}
	
	@Override
	public AFileDTO downloadFile(Map<String, Object> paramMap) throws Exception {
		
		return aStudentAttendanceDAO.downloadFile(paramMap);
	}

}
