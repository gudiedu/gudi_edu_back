package kr.happyjob.study.sAlert.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.happyjob.study.sAlert.dao.SNoticeDao;
import kr.happyjob.study.sAlert.dto.SNoticeDto;

@Service
public class SNoticeServiceImpl implements SNoticeService {

	@Autowired
	SNoticeDao sNoticeDao;
	
	/** 공지사항 목록 조회 */
	public List<SNoticeDto> sListNotice(Map<String, Object> paramMap) throws Exception {
		return sNoticeDao.sListNotice(paramMap);
	}
	
	/** 공지사항 목록 카운트 조회 */
	public int totalCntNotice(Map<String, Object> paramMap) throws Exception {	
		return sNoticeDao.totalCntNotice(paramMap);
	}
	
	/** 공지사항 한건조회 */
	public SNoticeDto sSelectNotice(Map<String, Object> paramMap) throws Exception {
		return sNoticeDao.sSelectNotice(paramMap);
	}
}
