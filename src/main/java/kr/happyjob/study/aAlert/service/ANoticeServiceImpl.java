package kr.happyjob.study.aAlert.service;

import java.io.File;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import kr.happyjob.study.aAlert.dao.ANoticeDAO;
import kr.happyjob.study.aAlert.model.AFileDTO;
import kr.happyjob.study.aAlert.model.ANoticeDTO;
import kr.happyjob.study.common.comnUtils.FileUtilCho;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ANoticeServiceImpl implements ANoticeService {

	private final ANoticeDAO aNoticeDAO;
	
	private final Logger logger = LogManager.getLogger(this.getClass());

	// Root path for file upload
	@Value("${fileUpload.rootPath}")
	private String rootPath;

	@Value("${fileUpload.virtualRootPath}")
	private String virtualRootPath;

	@Value("${fileUpload.noticePath}")
	private String noticePath;

	@Override
	public List<ANoticeDTO> searchNotice(Map<String, Object> paramMap) {
		return aNoticeDAO.searchNotice(paramMap);
	}

	@Override
	public Map<String, Object> selectNotice(Map<String, Object> paramMap) {
		return aNoticeDAO.selectNotice(paramMap);
	}

	@Override
	public int insertNotice(Map<String, Object> paramMap, HttpServletRequest request) throws Exception {
		
		Map<String, Object> fileInfo = fileUpload(request);
		paramMap.put("fileInfo", fileInfo);
		
		if(fileInfo.get("file_nm") != null && fileInfo.get("file_nm") != "") {
			int fileNo = saveFile(fileInfo);
			paramMap.put("fileExits","Y");
			paramMap.put("file_no", fileNo);
		}
		
		return aNoticeDAO.insertNotice(paramMap);
	}
	
	@Override
	public int updateNotice(Map<String, Object> paramMap, HttpServletRequest request) throws Exception {
		Map<String, Object> fileInfo = fileUpload(request);
		paramMap.put("fileInfo", fileInfo);
		
		if(fileInfo.get("file_nm") != null && fileInfo.get("file_nm") != "") {
			int fileNo = saveFile(fileInfo);
			paramMap.put("fileExits","Y");
			paramMap.put("file_no", fileNo);
		}
		
		return aNoticeDAO.updateNotice(paramMap);
	}
	
	@Override
	public int deleteNotice(Map<String, Object> paramMap) throws Exception {
		return aNoticeDAO.deleteNotice(paramMap);
	}
	
	private Map<String, Object> fileUpload(HttpServletRequest request) throws Exception{
		
		MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;
		
		String itemFilePath = noticePath + File.separator;
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
		
		aNoticeDAO.saveFile(file);
		
		return file.getFile_no();
	}
}
