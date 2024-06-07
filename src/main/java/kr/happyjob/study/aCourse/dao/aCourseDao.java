package kr.happyjob.study.aCourse.dao;

import java.util.List;
import java.util.Map;

import kr.happyjob.study.aCourse.model.aCourseModel;


public interface aCourseDao {
	/** 공통코드에 있는 강의코드 목록 조회 */
	public List<aCourseModel> aCourseList(Map<String, Object> paramMap) throws Exception;
	
	/** 공통코드에 있는 강의코드 추가 */
	public int aCourseInsert(String detail_name) throws Exception;
	
	// 다음 코드번호
	public String codeSelect() throws Exception;
	
	/*		
	*//** 공통코드에 있는 강의코드 수정 *//*
	public List<A_Datail_CodeModel> updatecourse(Map<String, Object> paramMap) throws Exception;
	
	*//** 공통코드에 있는 강의코드 삭제 *//*
	public List<A_Datail_CodeModel> deletecourse(Map<String, Object> paramMap) throws Exception;
	*/

}
