package andrea_freddi.U5_W2_D2_J.payloads;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BlogpostsPayload {
    private String category;
    private String title;
    private String content;
    private int readingTime;
}
