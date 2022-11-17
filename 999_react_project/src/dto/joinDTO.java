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

public class joinDTO {
   private String userNickname;
   private String userMbti;
   private String postId;
   private String userEmail;
   private String postContents;
   private Date postDate;

}