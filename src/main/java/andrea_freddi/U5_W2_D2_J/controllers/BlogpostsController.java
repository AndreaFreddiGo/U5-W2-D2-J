package andrea_freddi.U5_W2_D2_J.controllers;

import andrea_freddi.U5_W2_D2_J.entities.Blogpost;
import andrea_freddi.U5_W2_D2_J.payloads.BlogpostsPayload;
import andrea_freddi.U5_W2_D2_J.services.BlogpostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/blogposts")
public class BlogpostsController {
    @Autowired
    BlogpostService blogpostService;

    // 1. - POST http://localhost:3001/blogposts (+ req.body)
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED) // <-- 201
    public Blogpost save(@RequestBody BlogpostsPayload body) {
        return blogpostService.save(body);
    }

    // 2. - GET http://localhost:3001/blogposts
    @GetMapping
    public List<Blogpost> getBlogposts() {
        return blogpostService.getBlogposts();
    }

    // 3. - GET http://localhost:3001/blogposts/{id}
    @GetMapping("/{id}")
    public Blogpost findById(@PathVariable UUID id) {
        return blogpostService.findById(id);
    }

    // 4. - PUT http://localhost:3001/blogposts/{id} (+ req.body)
    @PutMapping("/{id}")
    public Blogpost findByIdAndUpdate(@PathVariable UUID id, @RequestBody BlogpostsPayload body) {
        return blogpostService.findByIdAndUpdate(id, body);
    }

    // 5. - DELETE http://localhost:3001/blogposts/{id}
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT) // <-- 204
    public void findByIdAndDelete(@PathVariable UUID id) {
        blogpostService.findByIdAndDelete(id);
    }
}
