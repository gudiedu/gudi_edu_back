package kr.happyjob.study.tCourse.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TestReslutSubmissionDTO {

	private int submission_no; // 시험제출번호
	private String answer_selected; // 선택결과
	private int question_score; // 점수 
	private String loginID;
	private String name;
	private int result_no; // 시험결과번호
	private int enrollment_no; // 수강번호
	private String enrollment_confirmed; //승인여부
	private int result_score; // 총 점수
	
	
	private int course_no; // 강의번호
	private String course_name; // 강의명
	private String course_start_date; // 개강일
	private String course_end_date; // 종강일
	private int test_no; // 문제번호
	private String test_question; // 문제
	private String test_choice1; // 선택지1
	private String test_choice2; // 선택지2
	private String test_choice3; // 선택지3
	private String test_choice4; // 선택지4
	private String test_answer; // 정답
	private String test_score; // 배점
	private String test_category; // 시험 카테고리
	
	// 통계 정보를 위한 필드 추가
	private double average_score;  // 평균 점수
	private int highest_score;     // 최고 점수
	private int participant_count; // 응시자 수
	
	
	
    // 시험 목록
    private int question_count;   // 문제 개수
	
	
}
