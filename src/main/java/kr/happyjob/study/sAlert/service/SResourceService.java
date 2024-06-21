package kr.happyjob.study.sAlert.service;

import java.util.List;
import java.util.Map;

import kr.happyjob.study.sAlert.dto.SResourceDto;

public interface SResourceService {
	
	/** 학습자료 목록 조회 */
	public List<SResourceDto> sListResources(Map<String, Object> paramMap) throws Exception;
	
	/** 학습자료 목록 카운트 조회 */
	public int totalCntResource(Map<String, Object> paramMap) throws Exception;
	
	/** 학습자료 한건조회 */
	public SResourceDto sSelectResource(Map<String, Object> paramMap) throws Exception;
}