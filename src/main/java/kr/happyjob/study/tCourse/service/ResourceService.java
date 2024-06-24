package kr.happyjob.study.tCourse.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import kr.happyjob.study.tCourse.model.LearningMaterialsDTO;

public interface ResourceService {
	
   public List<LearningMaterialsDTO> getResourceList(Map<String, Object> paramMap) throws Exception;
   
   public int countResourceList(Map<String, Object> paramMap) throws Exception;
   
   public int addResource(Map<String, Object> paramMap, HttpServletRequest request) throws Exception;
   
   public List<LearningMaterialsDTO> getCourseListByLoginID(String loginID) throws Exception;
   
   public int resourceSaveFile(Map<String, Object> fileInfo) throws Exception; // 파일 저장 메서드
   
   
  
   
   
   
   // 학습자료 조회
   public LearningMaterialsDTO getResourceById(int resourceNo) throws Exception;
   
   public Map<String, Object> resourceUploadFile(HttpServletRequest request) throws Exception; // 파일 업로드 메서드
   
   public int updateResource(Map<String, Object> paramMap, HttpServletRequest request) throws Exception;
   
   
   public int deleteResource(int resourceNo) throws Exception;
   
   
}
