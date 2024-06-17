package kr.happyjob.study.support.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class tClassSurveyVO {


		private String loginID;
		private int course_no;
		private String course_name;
		private int course_quota;
		private String course_start_date;
		private String course_end_date;
	    
		private int survey_no;
		private int respondent_count;
		
	}

