package bom.bom.meetingroom.user;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;

@SpringBootTest
@RunWith(SpringRunner.class)
@ActiveProfiles(value = "test")
public class UserServiceTest {
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Autowired
    UserService userService;

    @MockBean
    UserRepository userRepository;

    @Test
    public void testSignUp() {
        UserDto userDto = new UserDto("jobata", "1234", "조현우", "부팀장", "백엔드");
        userService.signUp(userDto);
    }

    @Test
    public void testSignUpFail() {
        expectedException.expect(DataIntegrityViolationException.class);
        UserDto userDto = new UserDto("forest.grass", "1234", "이동준", "팀장", "백엔드");
        Mockito.when(userRepository.save(any())).thenThrow(DataIntegrityViolationException.class);
        userService.signUp(userDto);
    }

    @Test
    public void testFindUserByUserIdFail() {
        Mockito.when(userRepository.findByUserId(any())).thenReturn(Optional.empty());
        User user = userService.findUserByUserId("jobata");
        assertThat(user.getId()).isNull();
    }
}
