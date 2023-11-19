package exercise.controller.users;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import exercise.model.Post;
import exercise.Data;

// BEGIN
@RestController
@RequestMapping("/api")
class PostsController{

    List<Post> data = Data.getPosts();

    @GetMapping("/users/{id}/posts")
    public List<Post> show(@PathVariable Integer id){
        return data.stream().filter(a ->a.getUserId() == id).toList();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/users/{id}/posts")
    public Post create(@PathVariable Integer id, @RequestBody Post posts){
        posts.setUserId(id);
        data.add(posts);
        return posts;
    }

}
// END
