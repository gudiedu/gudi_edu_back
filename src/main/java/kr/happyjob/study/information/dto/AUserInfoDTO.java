package kr.happyjob.study.information.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter @Setter
@RequiredArgsConstructor
public class AUserInfoDTO {
	
	private String loginID;
	private String user_type;
	private String name;
	private String email;
	private String hp;
	
}
