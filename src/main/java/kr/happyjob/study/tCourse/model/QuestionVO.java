package kr.happyjob.study.tCourse.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class QuestionVO {
	
    private int question_no;         
    private int course_no;      
    private String loginID;
    private int file_no;
    private String question_title;   
    private String question_content; 
    private String name;            
    private String question_created_at;
//    private String writer;

}
