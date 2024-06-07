package kr.happyjob.study.sAlert.dao;

import java.util.Map;

import kr.happyjob.study.sAlert.dto.SMyPageDto;
public interface SMyPageDao {

	/** 내 정보 조회 */
	public SMyPageDto sMyPage(Map<String, Object> paramMap) throws Exception;
	
	/** 내 정보 수정 */
	public int sUpdateMyPage(Map<String, Object> paramMap) throws Exception;
}
