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
		
		MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;
		
		String itemFilePath = noticePath + File.separator;
		FileUtilCho fileUpload = new FileUtilCho(multipartHttpServletRequest, rootPath, virtualRootPath, itemFilePath);
		Map<String, Object> fileInfo = fileUpload.uploadFiles();
		
		paramMap.put("fileInfo", fileInfo);
		
		if(fileInfo.get("file_nm") == null || fileInfo.get("file_nm") == "") {
			paramMap.put("fileExits","N");
		} else {
			int file_no = aNoticeDAO.saveFile(paramMap);
			paramMap.put("file_no", file_no);
			paramMap.put("fileExits","Y");
		}
		
		return aNoticeDAO.insertNotice(paramMap);
	}
}
