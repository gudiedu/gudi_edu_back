package kr.happyjob.study.tCourse.service;

import java.io.File;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;



import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.happyjob.study.tCourse.dao.QuestionReplyDao;
import kr.happyjob.study.tCourse.model.QuestionReplyVO;


@Service
public class QuestionReplyServiceImpl implements QuestionReplyService {

	    // Set logger
	 	private final Logger logger = LogManager.getLogger(this.getClass());
		
		// Get class name for logger
		private final String className = this.getClass().toString();


@Autowired
QuestionReplyDao QuestionReplyDao;

	/** qna 질문 모달  조회 */
	public QuestionReplyVO selectquestionreply(Map<String, Object> paramMap) throws Exception {
	
		return QuestionReplyDao.selectquestionreply(paramMap);
 }
/** qna모달 답변 목록 조회 */
 public List<QuestionReplyVO> listquestionreply(Map<String, Object> paramMap) throws Exception {
	
	return QuestionReplyDao.listquestionreply(paramMap);
} 

/** qna 목록 카운트 조회 */
/*public int totalcntquestionreply(Map<String, Object> paramMap) throws Exception {
	 
	return questionreplyDao.totalcntquestionreply(paramMap);
}*/

	/** 답변 등록 */
	public int insertquestionreply(Map<String, Object> paramMap,  HttpServletRequest request) throws Exception {
		
		return QuestionReplyDao.insertquestionreply(paramMap);
 }
	
   /** 답변 수정 */
	public int updatequestionreply(Map<String, Object> paramMap, HttpServletRequest request) throws Exception {
		paramMap.put("is_updated", true);
		return QuestionReplyDao.updatequestionreply(paramMap);
 }


   /** 답변 삭제 */
	public int deletequestionreply(Map<String, Object> paramMap, HttpServletRequest request) throws Exception {
		logger.info("Service - deletequestionreply - paramMap: " + paramMap);
		return QuestionReplyDao.deletequestionreply(paramMap);
 }
	
	
	
	
}


	
