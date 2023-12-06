package exercise.controller;

import exercise.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import exercise.model.Post;
import exercise.repository.PostRepository;
import exercise.exception.ResourceNotFoundException;
import exercise.dto.PostDTO;
import exercise.dto.CommentDTO;

// BEGIN
@RestController
@RequestMapping("/posts")
public class PostsController {
    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private PostRepository postRepository;

    @GetMapping("")
    public List<PostDTO> index() {
        var post = postRepository.findAll();
        var result = post.stream()
                .map(this::toPostDTO)
                .toList();
        return result;
    }

    @GetMapping("{/id}")
    public PostDTO show(@PathVariable long id) {
        var post = postRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Post with id " + id + " not found"));
        return toPostDTO(post);
    }

    public PostDTO toPostDTO(Post post) {
        var dto = new PostDTO();
        dto.setId(post.getId());
        dto.setBody(post.getBody());
        dto.setTitle(post.getTitle());

        var comment = commentRepository.findByPostId(post.getId());

        var commentsDTO = comment.stream()
                .map((comment1 -> {
                    var commentDTO = new CommentDTO();
                    commentDTO.setId(comment1.getId());
                    commentDTO.setBody(comment1.getBody());
                    return commentDTO;
                })).toList();
        dto.setComments(commentsDTO);
        return dto;

    }
}
// END
