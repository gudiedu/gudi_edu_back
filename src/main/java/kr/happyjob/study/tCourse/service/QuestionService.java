package kr.happyjob.study.tCourse.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import kr.happyjob.study.tCourse.model.QuestionVO;

public interface QuestionService {

	/** qna 목록 조회 */
	public List<QuestionVO> listquestion(Map<String, Object> paramMap) throws Exception;
	
	/** qna 목록 카운트 조회 */
	public int totalcntquestion(Map<String, Object> paramMap) throws Exception;
	

}
