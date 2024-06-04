package kr.happyjob.study.aAlert.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import kr.happyjob.study.aAlert.dao.ANoticeDAO;
import kr.happyjob.study.aAlert.model.ANoticeDTO;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ANoticeServiceImpl implements ANoticeService{
	
	private final ANoticeDAO aNoticeDAO;
	
	@Override
	public List<ANoticeDTO> searchNotice(Map<String, Object> paramMap) {
		return aNoticeDAO.searchNotice(paramMap);
	}
	
	@Override
	public Map<String, Object> selectNotice(Map<String, Object> paramMap) {
		return aNoticeDAO.selectNotice(paramMap);
	}
}
