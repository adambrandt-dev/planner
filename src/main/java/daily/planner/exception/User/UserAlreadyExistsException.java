package daily.planner.exception.User;

public class UserAlreadyExistsException extends RuntimeException {

    public UserAlreadyExistsException(String username, String email) {
        super(String.format(
                "User with username '%s' or email '%s' already exist in database",
                username,
                email
        ));
    }
}

