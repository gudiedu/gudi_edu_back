package kr.happyjob.study.sAlert.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.happyjob.study.sAlert.dao.SNoticeDao;
import kr.happyjob.study.sAlert.model.SNoticeModel;

@Service
public class SNoticeServiceImpl implements SNoticeService {

	@Autowired
	SNoticeDao sNoticeDao;
	
	/** 공지사항 목록 조회 */
	public List<SNoticeModel> sListNotice(Map<String, Object> paramMap) throws Exception {
		
		return sNoticeDao.sListNotice(paramMap);
	}
}
