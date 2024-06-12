package kr.happyjob.study.tAlert.dao;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import kr.happyjob.study.tCourse.model.QuestionVO;

public interface QuestionDao{
	
	/** qna 목록 조회 */
	public List<QuestionVO> listquestion(Map<String, Object> paramMap) throws Exception;
	
	/** qna 목록 카운트 조회 */
	public int totalcntquestion(Map<String, Object> paramMap) throws Exception;
	
	/** qna 등록 */
	/*public int insertquestion(Map<String, Object> paramMap) throws Exception;*/
	
	/** qna 수정 */
	public int updatequestion(Map<String, Object> paramMap) throws Exception;
	
	/** qna 삭제 */
	public int deletequestion(Map<String, Object> paramMap) throws Exception;
	
	/** qna 한건조회 */
	public QuestionVO selectquestion(Map<String, Object> paramMap) throws Exception;
	
	/** qna 등록  파일 */
	/*public int insertquestionfile(Map<String, Object> paramMap) throws Exception;*/
	
	/** qna 수정  파일 */
	/*public int updatequestionfile(Map<String, Object> paramMap) throws Exception;
	*/
}
