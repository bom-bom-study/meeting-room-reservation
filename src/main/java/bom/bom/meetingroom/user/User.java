package bom.bom.meetingroom.user;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Builder
@Getter
@Entity
public class User {
    @Id
    private String id;
    private String pw;
    private String name;
    private String position;
    private String department;
}
