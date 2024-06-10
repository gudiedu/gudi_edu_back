package kr.happyjob.study.tCourse.service;


import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import kr.happyjob.study.tCourse.model.QuestionReplyVO;


public interface QuestionReplyService {

	/** qna 답변 모달 조회 */
	public QuestionReplyVO selectquestionreply(Map<String, Object> paramMap) throws Exception;
	
	/** qna 모달 답변부분 리스트로 조회 */
	public List<QuestionReplyVO> listquestionreply(Map<String, Object> paramMap) throws Exception;
	
	/** qna 목록 카운트 조회 */
	/*public int totalcntquestion(Map<String, Object> paramMap) throws Exception;*/
	
	/** qna reply 등록 */
	public int insertquestionreply(Map<String, Object> paramMap) throws Exception;
	
	/** qna reply 수정 */
	public int updatequestionreply(Map<String, Object> paramMap) throws Exception;
	
	/** qna reply 삭제 */
	public int deletequestionreply(Map<String, Object> paramMap) throws Exception;
	
	/** qna 등록  파일 */
	/*public int insertquestionfile(Map<String, Object> paramMap) throws Exception;*/
	
	/** qna 수정  파일 */
	/*public int updatequestionfile(Map<String, Object> paramMap) throws Exception;
	*/
}
