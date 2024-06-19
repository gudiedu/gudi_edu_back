package kr.happyjob.study.information.model;

import lombok.*;

@Getter
@Setter
public class SurveyModel {
	private int nextsurvey_no;
	private int survey_no;
	private String survey_name;
	private int total_questions;
	private int choice_questions;
	private int written_questions;
	
}
