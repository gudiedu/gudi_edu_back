package kr.happyjob.study.aAlert.dao;

import java.util.List;
import java.util.Map;

import kr.happyjob.study.aAlert.model.ANoticeDTO;

public interface ANoticeDAO {
	public List<ANoticeDTO> searchNotice(Map<String, Object> paramMap);
	
	public Map<String, Object> selectNotice(Map<String, Object> paramMap);
}
