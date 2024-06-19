package kr.happyjob.study.aAlert.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import kr.happyjob.study.aAlert.model.ANoticeDTO;

public interface ANoticeService {
	public List<ANoticeDTO> searchNotice(Map<String, Object> paramMap) throws Exception;
	
	public Map<String, Object> selectNotice(Map<String, Object> paramMap) throws Exception;
	
	public int insertNotice(Map<String, Object> paramMap, HttpServletRequest request) throws Exception;
	
	public int deleteNotice(Map<String, Object> paramMap) throws Exception;
	
	public int updateNotice(Map<String, Object> paramMap, HttpServletRequest request) throws Exception;
}
