package daily.planner.controller.dto.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserCreateDto {

    @NotNull(message = "Can't be null")
    @NotBlank(message = "Username is mandatory")
    @Length(
            min = 4,
            message = "Length should be greater than {min}"
    )
    private String username;

    @NotNull(message = "Can't be null")
    @NotBlank(message = "Name is mandatory")
    @Length(
            min = 6,
            message = "Length should be greater than {min}"
    )
    private String password;

    @NotNull(message = "Can't be null")
    @NotBlank(message = "Name is mandatory")
    @Email(message = "Syntax error")
    private String email;

}
