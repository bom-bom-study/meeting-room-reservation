package bom.bom.meetingroom.user;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(SpringRunner.class)
@ActiveProfiles(value = "test")
public class UserServiceTest {
    @Autowired
    UserService userService;

    @MockBean
    UserRepository userRepository;

    @Test
    public void testSignUp() {
        when(userRepository.findById(any())).thenReturn(null);
        UserDto userDto = new UserDto("jobata", "1234", "조현우", "부팀장", "백엔드");
        userService.signUp(userDto);
    }

    @Test(expected = NullPointerException.class)
    public void testSignUpFail() {
        when(userRepository.findById(any())).thenReturn(Optional.of(User.builder().id("jobata").build()));
        UserDto userDto = new UserDto("jobata", "1234", "조현우", "부팀장", "백엔드");
        userService.signUp(userDto);
    }
}
