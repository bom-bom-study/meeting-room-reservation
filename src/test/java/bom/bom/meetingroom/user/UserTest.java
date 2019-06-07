package bom.bom.meetingroom.user;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserTest {
    @Test
    public void testCreateUser() {
        User user = User.builder()
                .id("jobata")
                .pw("1234")
                .name("조현우")
                .position("부팀장")
                .department("백엔드")
                .build();
        assertThat(user.getId()).isEqualTo("jobata");
    }
}
