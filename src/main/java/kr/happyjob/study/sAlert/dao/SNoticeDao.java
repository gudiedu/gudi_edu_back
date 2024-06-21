package kr.happyjob.study.sAlert.dao;

import java.util.List;
import java.util.Map;

import kr.happyjob.study.sAlert.dto.SNoticeDto;
public interface SNoticeDao {

	/** 공지사항 목록 조회 */
	public List<SNoticeDto> sListNotice(Map<String, Object> paramMap) throws Exception;
	
	/** 공지사항 목록 카운트 조회 */
	public int totalCntNotice(Map<String, Object> paramMap) throws Exception;
	
	/** 공지사항 한건조회 */
	public SNoticeDto sSelectNotice(Map<String, Object> paramMap) throws Exception;
}
