package kr.happyjob.study.tAlert.dao;

import java.io.File;
import java.util.List;
import java.util.Map;


import kr.happyjob.study.tAlert.model.tNoticeVO;


public interface tNoticeDao {
	
	
	public List<tNoticeVO> searchNotice(Map<String, Object> paramMap) throws Exception;
	
	public int totalcntNotice(Map<String, Object> paramMap) throws Exception;
	
	public tNoticeVO selectNotice(Map<String, Object> paramMap) throws Exception;
	
	public int insertNotice(Map<String, Object> paramMap) throws Exception;
	
	public int updateNotice(Map<String, Object> paramMap) throws Exception;
	
	public int saveFile(tNoticeVO file) throws Exception;
	
	public int deleteNotice(Map<String, Object> paramMap) throws Exception;

	public String selectFilePath(Map<String, Object> paramMap);

	public int deleteFileByNoticeNo(Map<String, Object> paramMap);
	
	public void deleteNoticeFile(Map<String, Object> paramMap) throws Exception;
}


	

