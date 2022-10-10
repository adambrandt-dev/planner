package daily.planner.controller.mapper;

import daily.planner.controller.dto.user.UserCreateDto;
import daily.planner.controller.dto.user.UserPatchDto;
import daily.planner.controller.dto.user.UserResponseDto;
import daily.planner.model.Role;
import daily.planner.model.User;

import java.util.stream.Collectors;

public class UserMapper {

    private static String DEFAULT_USER_IMAGE_PATH = "http://localhost:8080/user/defaultImage";
    private static String USER_IMAGE_PATH = "http://localhost:8080/user/%d/image";

    public static User mapToUser(UserCreateDto userCreateDto) {
        return User.builder()
                .username(userCreateDto.getUsername())
                .password(userCreateDto.getPassword())
                .email(userCreateDto.getEmail())
                .build();
    }

    public static UserResponseDto mapUserToUserResponseDto(User user) {
        String userImagePath = DEFAULT_USER_IMAGE_PATH;
        if (user.getImage() != null) {
            userImagePath = String.format(USER_IMAGE_PATH, user.getId());
        }
        return new UserResponseDto(
                user.getId(),
                user.getUsername(),
                user.getFirstname(),
                user.getLastname(),
                user.getEmail(),
                user.getAddress(),
                userImagePath,
                user.getRoles().stream()
                        .map(Role::getName)
                        .collect(Collectors.joining(", ")));
    }

    public static User updateUserFields(UserPatchDto userPatchDto, User user) {
        user.setFirstname(userPatchDto.getFirstname());
        user.setLastname(userPatchDto.getLastname());
        user.setEmail(userPatchDto.getEmail());
        user.setAddress(userPatchDto.getAddress());
        return user;
    }


}
