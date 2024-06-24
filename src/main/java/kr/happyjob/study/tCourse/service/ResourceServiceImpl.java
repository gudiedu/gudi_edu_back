package kr.happyjob.study.tCourse.service;

import java.io.File;
import java.net.URLEncoder;
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
import kr.happyjob.study.tCourse.dao.ResourceDao;
import kr.happyjob.study.tCourse.model.LearningMaterialsDTO;

@Service
public class ResourceServiceImpl implements ResourceService {

	@Autowired
	private ResourceDao resourceDao;
	
	
	// 로거 설정
	private final Logger logger = LogManager.getLogger(this.getClass());
	
    // 로거를 위한 클래스 이름 가져오기
    private final String className = this.getClass().toString();
	

    
	// 파일 업로드 경로 설정
	@Value("${fileUpload.rootPath}")
	private String rootPath;
	
	@Value("${fileUpload.virtualRootPath}")
	private String virtualRootPath;
	
	@Value("${fileUpload.resourcePath}")
	private String resourcePath;
    
    
    
    
    
    
    
    
	@Override
	public List<LearningMaterialsDTO> getResourceList(Map<String, Object> paramMap) throws Exception {
		return resourceDao.getResourceList(paramMap);
	}

	@Override
	public int countResourceList(Map<String, Object> paramMap) throws Exception {
		return resourceDao.countResourceList(paramMap);
	}

	@Override
	public List<LearningMaterialsDTO> getCourseListByLoginID(String loginID) throws Exception {
		return resourceDao.getCourseListByLoginID(loginID);
	}

	
	@Override
	public LearningMaterialsDTO getResourceById(int resourceNo) throws Exception {
	    LearningMaterialsDTO resource = resourceDao.getResourceById(resourceNo);
	    
	    // 파일 경로를 그대로 반환
	    // file_server_path 변환 로직 제거
	    return resource;
	}
	
	
	
	
	@Override
	public int addResource(Map<String, Object> paramMap, HttpServletRequest request) throws Exception {
	    // 파일 업로드 처리
	    Map<String, Object> fileInfo = fileUpload(request); // 파일 업로드 시도
	    if (fileInfo != null && !fileInfo.isEmpty()) { // 파일이 있는 경우만 파일 정보 저장
	        paramMap.put("file_no", saveFile(fileInfo)); // 파일 정보 저장
	    }
	    return resourceDao.addResource(paramMap);
	}

	
	
	
	
	
	
	
	
	
    @Override
    public Map<String, Object> resourceUploadFile(HttpServletRequest request) throws Exception {
    	
        logger.info("+ Start " + className + ".resourceUploadFile");

        MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;
        String itemFilePath = resourcePath + File.separator; // 파일이 저장될 폴더명
        logger.info("   - Root path: " + rootPath + ", Item file path: " + itemFilePath);
        
        FileUtilCho fileUpload = new FileUtilCho(multipartHttpServletRequest, rootPath, virtualRootPath, itemFilePath);
        Map<String, Object> fileInfo = fileUpload.uploadFiles(); // 파일 업로드

        if (fileInfo == null || fileInfo.isEmpty()) {
            logger.error("   - Error: fileInfo is null or empty");
        } else {
            logger.info("   - Uploaded file info: " + fileInfo);
        }
        logger.info("+ End " + className + ".resourceUploadFile");

        return fileInfo;
    }
    
    
    @Override
    public int resourceSaveFile(Map<String, Object> fileInfo) throws Exception {
    	LearningMaterialsDTO file = new LearningMaterialsDTO();
    	file.setFile_origin(fileInfo.get("file_nm").toString());
    	file.setFile_local_path(fileInfo.get("vrfile_loc").toString());
    	file.setFile_server_path(fileInfo.get("file_loc").toString());
    	file.setFile_extension(fileInfo.get("fileExtension").toString());
    	file.setFile_size(Integer.parseInt(fileInfo.get("file_size").toString()));
    	resourceDao.resourceSaveFile(file); // 파일 저장
    	return file.getFile_no();
    }
    
    
    
	
    @Override
    public int updateResource(Map<String, Object> paramMap, HttpServletRequest request) throws Exception {
        logger.info("+ Start " + className + ".updateResource");

        // 파일 업로드
        Map<String, Object> fileInfo = resourceUploadFile(request);
        if (fileInfo == null || fileInfo.isEmpty()) {
            logger.warn("   - No file uploaded");
            paramMap.put("fileExits", false);
        } else {
            logger.info("   - File uploaded: " + fileInfo);
            paramMap.put("file_no", resourceSaveFile(fileInfo));
            paramMap.put("fileExits", true);
        }      
        
        logger.info("   - paramMap after file upload: " + paramMap);
        if (paramMap.get("resource_no") == null) {
            throw new Exception("resource_no가 필요합니다.");
        }
        
        int result = resourceDao.updateResource(paramMap);

        logger.info("+ End " + className + ".updateResource");
        return result;
    }
    
    
    
    
    
    
    // 파일 업로드 메서드 추가
    private Map<String, Object> fileUpload(HttpServletRequest request) throws Exception { // 추가된 부분 시작
        MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;
        String itemFilePath = resourcePath + File.separator;
        FileUtilCho fileUpload = new FileUtilCho(multipartHttpServletRequest, rootPath, virtualRootPath, itemFilePath);
        return fileUpload.uploadFiles();
    } // 추가된 부분 끝
    
    
    
    
    
    // 파일 저장 메서드 추가
    private int saveFile(Map<String, Object> fileInfo) throws Exception { // 추가된 부분 시작
        LearningMaterialsDTO file = new LearningMaterialsDTO();
        file.setFile_origin(fileInfo.get("file_nm").toString());
        file.setFile_local_path(fileInfo.get("vrfile_loc").toString());
        file.setFile_server_path(fileInfo.get("file_loc").toString());
        file.setFile_extension(fileInfo.get("fileExtension").toString());
        file.setFile_size(Integer.parseInt(fileInfo.get("file_size").toString()));
        resourceDao.resourceSaveFile(file); 
        return file.getFile_no();
    } // 추가된 부분 끝
    
    
    
    
    
	@Override
	public int deleteResource(int resourceNo) throws Exception {
	    return resourceDao.deleteResource(resourceNo);
	}
    
    
  
}
