package kr.happyjob.study.aAlert.service;

import java.util.List;
import java.util.Map;

import kr.happyjob.study.aAlert.model.ANoticeDTO;

public interface ANoticeService {
	public List<ANoticeDTO> searchNotice(Map<String, Object> paramMap);
	
	public Map<String, Object> selectNotice(Map<String, Object> paramMap);
}
