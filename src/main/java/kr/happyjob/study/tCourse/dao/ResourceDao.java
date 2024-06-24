package kr.happyjob.study.tCourse.dao;

import java.util.List;
import java.util.Map;

import kr.happyjob.study.tCourse.model.LearningMaterialsDTO;

public interface ResourceDao {
	
    public List<LearningMaterialsDTO> getResourceList(Map<String, Object> paramMap) throws Exception;
    
    public int countResourceList(Map<String, Object> paramMap) throws Exception;
    
    public int addResource(Map<String, Object> paramMap) throws Exception;
    
    public List<LearningMaterialsDTO> getCourseListByLoginID(String loginID) throws Exception;
    
    public int resourceSaveFile(LearningMaterialsDTO file) throws Exception; // 파일 저장
    
    
    // 학습자료 조회
    public LearningMaterialsDTO getResourceById(int resourceNo) throws Exception;
    
    public int updateResource(Map<String, Object> paramMap) throws Exception;
    
    public int deleteResource(int resourceNo) throws Exception;
    
    
    public String selectFilePath(Map<String, Object> paramMap); // 파일 경로 조회 메서드
        

    

}
