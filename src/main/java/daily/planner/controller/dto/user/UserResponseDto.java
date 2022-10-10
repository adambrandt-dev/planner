package daily.planner.controller.dto.user;

import daily.planner.model.Address;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseDto {

    private Long id;
    private String username;
    private String firstname;
    private String lastname;
    private String email;
    private Address address;
    private String image;
    private String roles;

}