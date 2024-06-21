package kr.happyjob.study.information.model;
import lombok.*;

@Getter
@Setter
public class SurveyChoiceContentModel {
	private int question_choiced;
	private int choice_no;
	private String choice_result;
	private String category_name;

}
