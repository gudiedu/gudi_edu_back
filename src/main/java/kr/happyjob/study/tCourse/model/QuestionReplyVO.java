package kr.happyjob.study.tCourse.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class QuestionReplyVO {
	
    private int reply_no;
    private int question_no;             
    private String loginID;
    private int file_no;   
    private int course_no;   
    private String reply_content; 
    private String name;            
    private String reply_created_at;
   
    private String question_title;   
    private String question_content; 
    private String question_created_at;

}
