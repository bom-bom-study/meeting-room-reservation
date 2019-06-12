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
        User user = User.from(new UserDto("jobata", "1234", "조현우", "부팀장", "백엔드"));
        assertThat(user.getUserId()).isEqualTo("jobata");
    }
}
