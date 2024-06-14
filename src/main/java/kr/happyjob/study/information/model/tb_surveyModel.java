package kr.happyjob.study.information.model;

import lombok.*;

@Data
public class tb_surveyModel {
	private int survey_no;
	private String survey_name;
	private int total_question;
	private int choice_questions;
	private int written_questions;
	

}
