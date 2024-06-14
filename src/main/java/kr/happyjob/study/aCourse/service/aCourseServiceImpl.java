package kr.happyjob.study.aCourse.service;

import java.util.List;
import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.happyjob.study.aCourse.dao.aCourseDao;
import kr.happyjob.study.aCourse.model.aCourseModel;

@Service
public class aCourseServiceImpl implements aCourseService  {
	// Set logger
		private final Logger logger = LogManager.getLogger(this.getClass());
		// Get class name for logger
		private final String className = this.getClass().toString();
		
		
		@Autowired
		private aCourseDao acourseDao;

		public List<aCourseModel> aCourseList(Map<String, Object> paramMap) throws Exception {
			// TODO Auto-generated method stub
			return acourseDao.aCourseList(paramMap);
		}
		
	
		public int aCourseInsert(String detail_name) throws Exception {
	        return acourseDao.aCourseInsert(detail_name);
	    }
		
		// 다음 강의 코드번호 추출
		public String nextCodeSelect() throws Exception{
			return acourseDao.nextCodeSelect();
		}
		
		// 공통코드에 있는 강의코드 수정
		public int codeUpdate(Map<String, Object> paramMap) throws Exception {
	        return acourseDao.codeUpdate(paramMap);
	    }
		
		// 공통코드에 있는 강의코드 삭제 
		public int codeDelete(String detail_code) throws Exception {
			return acourseDao.codeDelete(detail_code);
		}
		
		public List<aCourseModel> codeSearch(String word) throws Exception{;
			return acourseDao.codeSearch(word);
		}
		
		
		
		// 선택한 강의 코드번호 추출
//		public String codeSelect() throws Exception{
//			return acourseDao.codeSelect();
//				}
		
		
}
