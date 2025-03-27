package andrea_freddi.U5_W2_D2_J.entities;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Author {
    @Setter(AccessLevel.NONE)
    private UUID id;
    private String name;
    private String surname;
    private String email;
    private String dateOfBirth;
    private String avatar;

    public Author(String avatar, String dateOfBirth, String email, String name, String surname) {
        this.id = UUID.randomUUID();
        this.avatar = avatar;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.name = name;
        this.surname = surname;
    }
}
