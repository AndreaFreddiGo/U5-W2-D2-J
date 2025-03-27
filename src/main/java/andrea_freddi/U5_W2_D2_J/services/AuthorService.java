package andrea_freddi.U5_W2_D2_J.services;

import andrea_freddi.U5_W2_D2_J.entities.Author;
import andrea_freddi.U5_W2_D2_J.exceptions.BadRequestException;
import andrea_freddi.U5_W2_D2_J.exceptions.NotFoundException;
import andrea_freddi.U5_W2_D2_J.payloads.AuthorsPayload;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class AuthorService {

    private final List<Author> authors = new ArrayList<>();

    public Author save(AuthorsPayload author) {
        Author newAuthor = new Author("https://ui-avatars.com/api/?name=" + author.getName() + "+" + author.getSurname(), author.getDateOfBirth(), author.getEmail(), author.getName(), author.getSurname());
        authors.add(newAuthor);
        return newAuthor;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public Author findById(UUID id) {
        Author found = null;
        for (Author author : authors) {
            if (author.getId().equals(id))
                found = author;
        }
        if (found == null)
            throw new NotFoundException(String.valueOf(id));
        return found;
    }

    public void findByIdAndDelete(UUID id) {
        Author found = null;
        for (Author author : authors) {
            if (author.getId().equals(id))
                found = author;
        }
        if (found == null)
            throw new NotFoundException(String.valueOf(id));
        authors.remove(found);
    }

    public Author findByIdAndUpdate(UUID id, AuthorsPayload author) {
        Author found = null;
        for (Author currentAuthor : authors) {
            if (currentAuthor.getId().equals(id)) {
                found = currentAuthor;
                if (!found.getEmail().equals(author.getEmail())) {
                    for (Author current : authors)
                        if (current.getEmail().equals(author.getEmail()))
                            throw new BadRequestException("Email + " + author.getEmail() + " già in uso");
                }
                found.setName(author.getName());
                found.setSurname(author.getSurname());
                found.setEmail(author.getEmail());
                found.setDateOfBirth(author.getDateOfBirth());
                found.setAvatar("https://ui-avatars.com/api/?name=" + author.getName() + "+" + author.getSurname());
            }
        }
        if (found == null)
            throw new NotFoundException(String.valueOf(id));
        return found;
    }
}
