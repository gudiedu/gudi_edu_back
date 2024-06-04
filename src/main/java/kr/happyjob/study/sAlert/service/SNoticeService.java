package kr.happyjob.study.sAlert.service;

import java.util.List;
import java.util.Map;

import kr.happyjob.study.sAlert.model.SNoticeDto;

public interface SNoticeService {
	
	/** 공지사항 목록 조회 */
	public List<SNoticeDto> sListNotice(Map<String, Object> paramMap) throws Exception;
}