package bom.bom.meetingroom.user;

public interface UserService {
    void signUp(UserDto userDto);
    User findUserByUserId(String userId);
}
