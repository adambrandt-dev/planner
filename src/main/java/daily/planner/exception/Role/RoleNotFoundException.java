package daily.planner.exception.Role;

public class RoleNotFoundException extends RuntimeException {

    public RoleNotFoundException(String name) {
        super(String.format(
                "Role with name '%s' can not be found in the database",
                name
        ));
    }
}