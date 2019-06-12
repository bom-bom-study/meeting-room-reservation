package bom.bom.meetingroom.user;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void signUp(UserDto userDto) {
        User user = User.from(userDto);
        try {
            userRepository.save(user);
        } catch (DataIntegrityViolationException dive) {
            throw dive;
        }
    }

    public User findUserByUserId(String userId) {
       return userRepository.findByUserId(userId).orElse(new User());
    }
}
