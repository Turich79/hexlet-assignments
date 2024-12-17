package exercise.controller;

import exercise.dto.CommentDTO;
import exercise.model.Comment;
import exercise.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

import exercise.model.Post;
import exercise.repository.PostRepository;
import exercise.exception.ResourceNotFoundException;
import exercise.dto.PostDTO;

// BEGIN
@RestController
@RequestMapping("")
public class PostsController {
    @Autowired
    private PostRepository postRepository;

    @Autowired
    private CommentRepository commentRepository;

    @GetMapping("/posts")
    public List<PostDTO> index() {
        var users = postRepository.findAll();
        var result = users.stream()
                .map(this::toDTO)
                .toList();
        return result;
    }

    @GetMapping("/posts/{id}")
    @ResponseStatus(HttpStatus.OK)
    // Пользователь автоматически преобразуется в JSON
    public PostDTO show(@PathVariable Long id) {
        var post = postRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Post with id " + id + " not found"));

        var dto = new PostDTO();
        dto.setId(post.getId());
        dto.setTitle(post.getTitle());
        dto.setBody(post.getBody());
        var comments = commentRepository.findByPostId(post.getId()).stream().toList();
        var commentsDTO = toDTOComments(comments);
        dto.setComments(commentsDTO);
        return dto;
    }
    // Чтобы сделать работу удобнее
    // И избежать дублирования
    private PostDTO toDTO(Post post) {
        var dto = new PostDTO();
        dto.setId(post.getId());
        dto.setBody(post.getBody());
        dto.setTitle(post.getTitle());
        var comments = commentRepository.findByPostId(post.getId()).stream().toList();
        var commentsDTO = toDTOComments(comments);
        dto.setComments(commentsDTO);
        return dto;
    }

    private List<CommentDTO> toDTOComments (List<Comment> comments) {
        List<CommentDTO> commentsDTOS = new ArrayList<>();
        for (var str:comments) {
            var commentDTO = new CommentDTO();
            commentDTO.setId(str.getId());
            commentDTO.setBody(str.getBody());
            commentsDTOS.add(commentDTO);
        }
        return commentsDTOS;
    }
}
// END
