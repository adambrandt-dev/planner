package daily.planner.exception.User;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(Long id) {
        super(String.format(
                "User with id = %d can not be found in the database",
                id
        ));
    }

    public UserNotFoundException(String username) {
        super(String.format(
                "User with username '%s' can not be found in the database",
                username
        ));
    }
}
