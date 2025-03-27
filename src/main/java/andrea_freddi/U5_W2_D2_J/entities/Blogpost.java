package andrea_freddi.U5_W2_D2_J.entities;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Blogpost {
    @Setter(AccessLevel.NONE)
    private UUID id;
    private String category;
    private String title;
    private String cover;
    private String content;
    private int readingTime;

    public Blogpost(String category, String content, String cover, int readingTime, String title) {
        this.id = UUID.randomUUID();
        this.category = category;
        this.content = content;
        this.cover = cover;
        this.readingTime = readingTime;
        this.title = title;
    }
}
