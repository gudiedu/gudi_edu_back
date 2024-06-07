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
import kr.happyjob.study.tCourse.model.QuestionVO;

@Service
public class QuestionReplyServiceImpl implements QuestionReplyService {

	    // Set logger
	 	private final Logger logger = LogManager.getLogger(this.getClass());
		
		// Get class name for logger
		private final String className = this.getClass().toString();


@Autowired
QuestionReplyDao QuestionReplyDao;

/** qna 하나조회 */
public QuestionReplyVO selectquestionreply(Map<String, Object> paramMap) throws Exception {
	 
	return QuestionReplyDao.selectquestionreply(paramMap);
}
/** qna 목록 조회 */
/*public List<questionreplyVO> listquestionreply(Map<String, Object> paramMap) throws Exception {
	
	return questionreplyDao.listquestionreply(paramMap);
} */

/** qna 목록 카운트 조회 */
/*public int totalcntquestionreply(Map<String, Object> paramMap) throws Exception {
	 
	return questionreplyDao.totalcntquestionreply(paramMap);
}*/

	/** 공지사항 등록 */
	public int insertquestionreply(Map<String, Object> paramMap) throws Exception {
		return QuestionReplyDao.insertquestionreply(paramMap);
}
	
/** qna 수정 */
public int updatequestionreply(Map<String, Object> paramMap) throws Exception {
	 
	return QuestionReplyDao.updatequestionreply(paramMap);
}


/** qna 삭제 */
public int deletequestionreply(Map<String, Object> paramMap) throws Exception {
	 
	return QuestionReplyDao.deletequestionreply(paramMap);
}
}


	
