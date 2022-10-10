package daily.planner.controller.dto.user;

import daily.planner.model.Address;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserPatchDto {

    private String firstname;
    private String lastname;

    @NotBlank(message = "Name is mandatory")
    @Email(message = "Syntax error")
    private String email;

    private Address address;
}
