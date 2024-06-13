package kr.happyjob.study.tAlert.service;

import java.io.File;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import kr.happyjob.study.common.comnUtils.FileUtilCho;
import kr.happyjob.study.tAlert.dao.tNoticeDao;
import kr.happyjob.study.tAlert.model.tFileVO;
import kr.happyjob.study.tAlert.model.tNoticeVO;

@Service
public class tNoticeServiceImpl implements tNoticeService {

	// Set logger
	private final Logger logger = LogManager.getLogger(this.getClass());

	// Get class name for logger
	private final String className = this.getClass().toString();

	@Value("${fileUpload.rootPath}")
	private String rootPath;
	
	@Value("${fileUpload.virtualRootPath}")
	private String virtualRootPath;
	
	@Value("${fileUpload.noticePath}")
	private String noticePath;
	
	
	@Autowired
	tNoticeDao tNoticeDao;
		

	
	public List<tNoticeVO> searchNotice(Map<String, Object> paramMap) throws Exception {

		return tNoticeDao.searchNotice(paramMap);
		
	}

	public int totalcntNotice(Map<String, Object> paramMap) throws Exception {
		 
		return tNoticeDao.totalcntNotice(paramMap);
	}

	
	
	public Map<String, Object> selectNotice(Map<String, Object> paramMap) throws Exception {

		return tNoticeDao.selectNotice(paramMap);
	}

	
	public int insertNotice(Map<String, Object> paramMap, HttpServletRequest request) throws Exception {
		
		Map<String, Object> fileInfo = fileUpload(request);
		paramMap.put("fileInfo", fileInfo);
		
		if(fileInfo.get("file_nm") != null && fileInfo.get("file_nm") != "") {
			int fileNo = saveFile(fileInfo);
			paramMap.put("fileExits","Y");
			paramMap.put("file_no", fileNo);
		}
		
		return tNoticeDao.insertNotice(paramMap);
	}



	
	public int deleteNotice(Map<String, Object> paramMap) throws Exception {

		return tNoticeDao.deleteNotice(paramMap);
	}

	
	public int updateNotice(Map<String, Object> paramMap, HttpServletRequest request) throws Exception {

		
		Map<String, Object> fileInfo = fileUpload(request);
		paramMap.put("fileInfo", fileInfo);
		if(fileInfo.get("file_nm") != null && fileInfo.get("file_nm") != "") {
			int fileNo = saveFile(fileInfo);
			paramMap.put("fileExits","Y");
			paramMap.put("file_no", fileNo);
		}
		
		return tNoticeDao.updateNotice(paramMap);
	}

	private int saveFile(Map<String, Object> fileInfo) throws Exception{

		tFileVO file = new tFileVO();
				
				file.setFile_origin(fileInfo.get("file_nm").toString());
				file.setFile_local_path(fileInfo.get("vrfile_loc").toString());
				file.setFile_server_path(fileInfo.get("file_loc").toString());
				file.setFile_extension(fileInfo.get("fileExtension").toString());
				file.setFile_size(Integer.parseInt(fileInfo.get("file_size").toString()));
				
				tNoticeDao.saveFile(file);
				
				return file.getFile_no();
			}

	private Map<String, Object> fileUpload(HttpServletRequest request) throws Exception {

		MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;
		
		String itemFilePath = noticePath + File.separator;
		FileUtilCho fileUpload = new FileUtilCho(multipartHttpServletRequest, rootPath, virtualRootPath, itemFilePath);
		Map<String, Object> fileInfo = fileUpload.uploadFiles();
		
		return fileInfo;
	}

}
