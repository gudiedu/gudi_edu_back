package kr.happyjob.study.tCourse.service;

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
	public int addResource(Map<String, Object> paramMap, HttpServletRequest request) throws Exception {
		// 파일 업로드
		Map<String, Object> fileInfo = resourceUploadFile(request);
		if (fileInfo != null) {
			// 파일 정보 저장
			paramMap.put("file_no", resourceSaveFile(fileInfo));
		}
		return resourceDao.addResource(paramMap);
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
	public LearningMaterialsDTO getResourceById(int resourceNo) throws Exception {
		return resourceDao.getResourceById(resourceNo);
	}

	
	
	
	@Override
	public int updateResource(Map<String, Object> paramMap, HttpServletRequest request) throws Exception {
	    logger.info("+ Start " + className + ".updateResource");

	    // 파일 업로드
	    Map<String, Object> fileInfo = resourceUploadFile(request);
	    if (fileInfo == null || fileInfo.isEmpty()) {
	        logger.warn("   - No file uploaded");
	    } else {
	        logger.info("   - File uploaded: " + fileInfo);
	        paramMap.put("file_no", resourceSaveFile(fileInfo));
	    }

	    logger.info("   - paramMap after file upload: " + paramMap);
	    int result = resourceDao.updateResource(paramMap);

	    logger.info("+ End " + className + ".updateResource");
	    return result;
	}
	
	
	
	
	
	@Override
	public int deleteResource(int resourceNo) throws Exception {
	    return resourceDao.deleteResource(resourceNo);
	}

}
