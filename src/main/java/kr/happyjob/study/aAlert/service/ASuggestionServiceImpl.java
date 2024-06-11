package kr.happyjob.study.aAlert.service;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import kr.happyjob.study.aAlert.dao.ASuggestionDAO;
import kr.happyjob.study.aAlert.model.AFileDTO;
import kr.happyjob.study.aAlert.model.ASuggestionDTO;
import kr.happyjob.study.common.comnUtils.FileUtilCho;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ASuggestionServiceImpl implements ASuggestionService{
	
	private final ASuggestionDAO aSuggestionDAO;
	
	private final Logger logger = LogManager.getLogger(this.getClass());
	
	@Value("${fileUpload.rootPath}")
	private String rootPath;

	@Value("${fileUpload.virtualRootPath}")
	private String virtualRootPath;

	@Value("${fileUpload.suggestionPath}")
	private String suggestionPath;
	
	@Override
	public List<ASuggestionDTO> searchSuggestion(Map<String, Object> paramMap) throws Exception {
		return aSuggestionDAO.searchSuggestion(paramMap);
	}
	
	@Override
	public Map<String, Object> selectSuggestion(Map<String, Object> paramMap) throws Exception {
		Map<String, Object> resultMap = new HashMap<>();
		Map<String, Object> suggestionReply = new HashMap<>();
		Map<String, Object> suggestion = aSuggestionDAO.selectSuggestion(paramMap);
		
		if(paramMap.get("suggestion_answered").toString().equals("Y")){
			suggestionReply = aSuggestionDAO.selectSuggestionReply(paramMap);
		}
		
		resultMap.put("suggestion", suggestion);
		resultMap.put("suggestionReply", suggestionReply);
		
		logger.info(resultMap);
		return resultMap;
	}
	
	@Override
	public int insertReply(Map<String, Object> paramMap, HttpServletRequest request) throws Exception {
		Map<String, Object> fileInfo = fileUpload(request);
		paramMap.put("fileInfo", fileInfo);
		
		if(fileInfo.get("file_nm") != null && fileInfo.get("file_nm") != "") {
			int fileNo = saveFile(fileInfo);
			paramMap.put("fileExits","Y");
			paramMap.put("file_no", fileNo);
		}
		paramMap.put("action", "I");
		int isInsert = aSuggestionDAO.insertReply(paramMap);
		aSuggestionDAO.updateSuggestion(paramMap);
		
		return isInsert;
	}
	
	@Override
	public int updateReply(Map<String, Object> paramMap, HttpServletRequest request) throws Exception {
		Map<String, Object> fileInfo = fileUpload(request);
		paramMap.put("fileInfo", fileInfo);
		
		if(fileInfo.get("file_nm") != null && fileInfo.get("file_nm") != "") {
			int fileNo = saveFile(fileInfo);
			paramMap.put("fileExits","Y");
			paramMap.put("file_no", fileNo);
		}
		
		int isUpdate = aSuggestionDAO.updateReply(paramMap);
		
		return isUpdate;
	}
	
	@Override
	public int deleteReply(Map<String, Object> paramMap) throws Exception {
		paramMap.put("action", "D");
		int isDelete = aSuggestionDAO.deleteReply(paramMap);
		aSuggestionDAO.updateSuggestion(paramMap);
		return isDelete;
	}
	
	@Override
	public int deleteSuggestion(Map<String, Object> paramMap) throws Exception {
		int isDelete = aSuggestionDAO.deleteSuggestion(paramMap);
		return isDelete;
	}
	
	@Override
	public Map<String, Object> downloadFile(Map<String, Object> paramMap) throws Exception {
		return aSuggestionDAO.downloadFile(paramMap);
	}
	
	private Map<String, Object> fileUpload(HttpServletRequest request) throws Exception{
		
		MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;
		
		String itemFilePath = suggestionPath + File.separator;
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
		
		aSuggestionDAO.saveFile(file);
		
		return file.getFile_no();
	}
}
