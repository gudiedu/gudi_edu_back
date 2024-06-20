package kr.happyjob.study.tCourse.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import kr.happyjob.study.common.comnUtils.FileUtilCho;
import kr.happyjob.study.tCourse.dao.ResourceDao;
import kr.happyjob.study.tCourse.model.LearningMaterialsDTO;

@Service
public class ResourceServiceImpl implements ResourceService {

	@Autowired
	private ResourceDao resourceDao;

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
		MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;
		String itemFilePath = "resource";
		FileUtilCho fileUpload = new FileUtilCho(multipartHttpServletRequest, "Y:/gudiedu_file", "/serverfile",
				itemFilePath);
		return fileUpload.uploadFiles(); // 파일 업로드
	}

	@Override
	public LearningMaterialsDTO getResourceById(int resourceNo) throws Exception {
		return resourceDao.getResourceById(resourceNo);
	}

	@Override
	public int updateResource(Map<String, Object> paramMap, HttpServletRequest request) throws Exception {
	    // 파일 업로드
	    Map<String, Object> fileInfo = resourceUploadFile(request);
	    if (fileInfo != null) {
	        // 파일 정보 저장
	        paramMap.put("file_no", resourceSaveFile(fileInfo));
	    }
	    return resourceDao.updateResource(paramMap);
	}
	
	@Override
	public int deleteResource(int resourceNo) throws Exception {
	    return resourceDao.deleteResource(resourceNo);
	}

}
