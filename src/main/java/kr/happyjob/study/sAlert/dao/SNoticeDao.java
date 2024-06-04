package kr.happyjob.study.sAlert.dao;

import java.util.List;
import java.util.Map;

import kr.happyjob.study.sAlert.dto.SNoticeDto;

public interface SNoticeDao {

	/** 공지사항 목록 조회 */
	public List<SNoticeDto> sListNotice(Map<String, Object> paramMap) throws Exception;
}
