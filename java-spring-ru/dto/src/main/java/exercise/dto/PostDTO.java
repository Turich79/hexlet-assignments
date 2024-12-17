package exercise.dto;

import java.util.List;

import exercise.model.Comment;
import lombok.Getter;
import lombok.Setter;

// BEGIN
@Setter
@Getter
public class PostDTO {
    private Long id;
    private String title;
    private String body;
    private List<CommentDTO> comments;
//private List<Comment> comments;
}
// END
