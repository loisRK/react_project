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

public class postDTO {
	private int postId;
	private String userId;
	private String postContents;
	private int postLikeNum;
	private int postRefNum;
	private Date postDate;
}
