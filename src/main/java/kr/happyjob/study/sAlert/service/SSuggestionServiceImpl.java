package kr.happyjob.study.sAlert.service;

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

import kr.happyjob.study.sAlert.dao.SSuggestionDao;
import kr.happyjob.study.sAlert.dto.SSuggestionDto;
import kr.happyjob.study.common.comnUtils.FileUtilCho;

@Service
public class SSuggestionServiceImpl implements SSuggestionService {

	@Autowired
	SSuggestionDao sSuggestionDao;
	
	// Set logger
	private final Logger logger = LogManager.getLogger(this.getClass());

	//Root path for file upload
	@Value("${fileUpload.rootPath}")
	private String rootPath;
		
	@Value("${fileUpload.virtualRootPath}")
	private String virtualRootPath;
		
	@Value("${fileUpload.suggestionPath}")
	private String suggestionPath;
	
	/** 건의사항 목록 조회 */
	public List<SSuggestionDto> sSuggestionList(Map<String, Object> paramMap) throws Exception {
		return sSuggestionDao.sSuggestionList(paramMap);
	}
	
	/** 건의사항 등록 */
	public int sInsertSuggestion(Map<String, Object> paramMap, HttpServletRequest request) throws Exception {
		Map<String, Object> fileInfo = fileUpload(request);
		paramMap.put("fileInfo", fileInfo);
		
		if(fileInfo.get("file_nm") != null && fileInfo.get("file_nm") != "") {
			int fileNo = saveFile(fileInfo);
			paramMap.put("fileExits","Y");
			paramMap.put("file_no", fileNo);
		}
		
		return sSuggestionDao.sInsertSuggestion(paramMap);
	}
	
	/** 건의사항 수정 */
	public int sUpdateSuggestion(Map<String, Object> paramMap, HttpServletRequest request) throws Exception {
		Map<String, Object> fileInfo = fileUpload(request);
		paramMap.put("fileInfo", fileInfo);
		
		if(fileInfo.get("file_nm") != null && fileInfo.get("file_nm") != "") {
			int fileNo = saveFile(fileInfo);
			paramMap.put("fileExits","Y");
			paramMap.put("file_no", fileNo);
		}
		
		return sSuggestionDao.sUpdateSuggestion(paramMap);
	}
	
	/** 건의사항 삭제 */
	public int sDeleteSuggestion(Map<String, Object> paramMap) throws Exception {	
		
		// 트랜잭션 처리를 위해, 두 쿼리를 트랜잭션 내에서 실행
        try {
            // tb_suggestion_reply 테이블에서 참조된 데이터 삭제
        	sSuggestionDao.sDeleteSuggestionReply(paramMap);
            
            // tb_suggestion 테이블에서 데이터 삭제
            return sSuggestionDao.sDeleteSuggestion(paramMap);
        } catch (Exception e) {
            throw new Exception("삭제 중 오류 발생", e);
        }
	}
	
	/** 건의사항 파일 등록 */
	private Map<String, Object> fileUpload(HttpServletRequest request) throws Exception{
		
		MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;
		
		String itemFilePath = suggestionPath + File.separator;
		FileUtilCho fileUpload = new FileUtilCho(multipartHttpServletRequest, rootPath, virtualRootPath, itemFilePath);
		Map<String, Object> fileInfo = fileUpload.uploadFiles();
		
		return fileInfo;
	}
	
	private int saveFile(Map<String,Object> fileInfo) throws Exception{
		
		SSuggestionDto file = new SSuggestionDto();
//		SFileModel file = new SFileModel();
		
		file.setFile_origin(fileInfo.get("file_nm").toString());
		file.setFile_local_path(fileInfo.get("vrfile_loc").toString());
		file.setFile_server_path(fileInfo.get("file_loc").toString());
		file.setFile_extension(fileInfo.get("fileExtension").toString());
		file.setFile_size(Integer.parseInt(fileInfo.get("file_size").toString()));
		
		sSuggestionDao.saveFile(file);
		
		logger.info("파일번호: " + file.getFile_no());
		
		return file.getFile_no();
	}
	
	/** 건의사항 목록 카운트 조회 */
	public int totalCntResource(Map<String, Object> paramMap) throws Exception {	
		return sSuggestionDao.totalCntResource(paramMap);
	}
	
	/** 건의사항 한 건 조회 */
	public SSuggestionDto sSelectSuggestion(Map<String, Object> paramMap) throws Exception {
		return sSuggestionDao.sSelectSuggestion(paramMap);
	}
	
	/** 건의사항 답변 한 건 조회 */
	public SSuggestionDto sSelectSuggestionReply(Map<String, Object> paramMap) throws Exception {
		return sSuggestionDao.sSelectSuggestionReply(paramMap);
	}
	
}
