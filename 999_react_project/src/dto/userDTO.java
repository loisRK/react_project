package dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

public class userDTO {
	private String userEmail;
	private String userNickname;
	private String userPw;
	private String userName;
	private Date userBirth;
	private int userPostCnt;
	private int userReportCnt;
	private int userPublic;
	private String userMbti;
	
}
