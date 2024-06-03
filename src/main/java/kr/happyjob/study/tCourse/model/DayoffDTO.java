package kr.happyjob.study.tCourse.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DayoffDTO {
	
	private int dayoff_no; //휴일번호
	private String dayoff_date; //휴일날짜
	private String dayoff_detail; //휴일설명

}
