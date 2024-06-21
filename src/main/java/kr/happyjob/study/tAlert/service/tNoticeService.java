package kr.happyjob.study.tAlert.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import kr.happyjob.study.tAlert.model.tNoticeVO;

public interface tNoticeService {
	
	
	/** 공지사항 목록 조회 */
	public List<tNoticeVO> searchNotice(Map<String, Object> paramMap) throws Exception;
	
	/**공지사항 카운트*/
	public int totalcntNotice(Map<String, Object> paramMap) throws Exception;
	
	/** 공지사항 한건조회 */
	public tNoticeVO selectNotice(Map<String, Object> paramMap) throws Exception;
	
	/** 공지사항 입력 */
	public int insertNotice(Map<String, Object> paramMap, HttpServletRequest request) throws Exception;
	
	/** 공지사항 삭제 */
	public int deleteNotice(Map<String, Object> paramMap) throws Exception;
	
	/** 공지사항 수정 */
	public int updateNotice(Map<String, Object> paramMap, HttpServletRequest request) throws Exception; 

	public void deleteNoticeFile(Map<String, Object> paramMap) throws Exception;
	
	
	

	}
	


