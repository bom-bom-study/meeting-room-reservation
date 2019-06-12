package bom.bom.meetingroom.user;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "user_id", unique = true)
    private String userId;
    private String pw;
    private String name;
    private String position;
    private String department;

    private User(UserDto userDto) {
        this.userId = userDto.getUserId();
        this.pw = userDto.getPw();
        this.name = userDto.getName();
        this.position = userDto.getPosition();
        this.department = userDto.getDepartment();
    }

    public static User from(UserDto userDto) {
        return new User(userDto);
    }
}
