package kr.happyjob.study.sAlert.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.happyjob.study.sAlert.dto.SResourceDto;
import kr.happyjob.study.sAlert.dao.SResourceDao;

@Service
public class SResourceServiceImpl implements SResourceService {

	@Autowired
	SResourceDao SResourceDao;
	
	/** 학습자료 목록 조회 */
	public List<SResourceDto> sListResources(Map<String, Object> paramMap) throws Exception {
		return SResourceDao.sListResources(paramMap);
	}
	
	/** 학습자료 목록 카운트 조회 */
	public int totalCntResource(Map<String, Object> paramMap) throws Exception {	
		return SResourceDao.totalCntResource(paramMap);
	}
	
	/** 학습자료 한건조회 */
	public SResourceDto sSelectResource(Map<String, Object> paramMap) throws Exception {
		return SResourceDao.sSelectResource(paramMap);
	}
}
