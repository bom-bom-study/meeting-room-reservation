package bom.bom.meetingroom.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserDto {
    private String id;
    private String pw;
    private String name;
    private String position;
    private String department;
}
