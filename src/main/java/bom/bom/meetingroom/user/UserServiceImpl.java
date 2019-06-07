package bom.bom.meetingroom.user;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void signUp(UserDto userDto) {
        if (isUserId(userDto.getId())) {
            throw new NullPointerException();
        }
        User user = User.builder()
                .id(userDto.getId())
                .pw(userDto.getPw())
                .name(userDto.getName())
                .position(userDto.getPosition())
                .department(userDto.getDepartment())
                .build();
        userRepository.save(user);
    }

    private boolean isUserId(String id) {
        return Optional.ofNullable(userRepository.findById(id)).isPresent();
    }
}
