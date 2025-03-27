package andrea_freddi.U5_W2_D2_J.services;

import andrea_freddi.U5_W2_D2_J.entities.Blogpost;
import andrea_freddi.U5_W2_D2_J.exceptions.NotFoundException;
import andrea_freddi.U5_W2_D2_J.payloads.BlogpostsPayload;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class BlogpostService {

    private final List<Blogpost> blogposts = new ArrayList<>();

    public Blogpost save(BlogpostsPayload blogpost) {
        Blogpost newBlogpost = new Blogpost(blogpost.getCategory(), blogpost.getContent(), "https://picsum.photos/200/300", blogpost.getReadingTime(), blogpost.getTitle());
        blogposts.add(newBlogpost);
        return newBlogpost;
    }

    public List<Blogpost> getBlogposts() {
        return blogposts;
    }

    public Blogpost findById(UUID id) {
        Blogpost found = null;
        for (Blogpost blogpost : blogposts) {
            if (blogpost.getId().equals(id))
                found = blogpost;
        }
        if (found == null)
            throw new NotFoundException(String.valueOf(id));
        return found;
    }

    public void findByIdAndDelete(UUID id) {
        Blogpost found = null;
        for (Blogpost blogpost : blogposts) {
            if (blogpost.getId().equals(id))
                found = blogpost;
        }
        if (found == null)
            throw new NotFoundException(String.valueOf(id));
        blogposts.remove(found);
    }

    public Blogpost findByIdAndUpdate(UUID id, BlogpostsPayload blogpost) {
        Blogpost found = null;
        for (Blogpost currentBlogpost : blogposts) {
            if (currentBlogpost.getId().equals(id)) {
                found = currentBlogpost;
                found.setCategory(blogpost.getCategory());
                found.setContent(blogpost.getContent());
                found.setReadingTime(blogpost.getReadingTime());
            }
        }
        if (found == null)
            throw new NotFoundException(String.valueOf(id));
        return found;
    }
}
