package kr.happyjob.study.sAlert.dao;

import java.util.List;
import java.util.Map;

import kr.happyjob.study.sAlert.dto.SSuggestionDto;
public interface SSuggestionDao {

	/** 건의사항 목록 조회 */
	public List<SSuggestionDto> sSuggestionList(Map<String, Object> paramMap) throws Exception;
	
	/** 건의사항 등록 */
	public int sInsertSuggestion(Map<String, Object> paramMap) throws Exception;
	
	/** 건의사항 파일등록 */
	public int saveFile(SSuggestionDto file);
	
	/** 건의사항 목록 카운트 조회 */
	public int totalCntResource(Map<String, Object> paramMap) throws Exception;
	
	/** 건의사항 한 건 조회 */
	public SSuggestionDto sSelectSuggestion(Map<String, Object> paramMap) throws Exception;
	
	/** 건의사항 답변 한 건 조회 */
	public SSuggestionDto sSelectSuggestionReply(Map<String, Object> paramMap) throws Exception;
	
}
