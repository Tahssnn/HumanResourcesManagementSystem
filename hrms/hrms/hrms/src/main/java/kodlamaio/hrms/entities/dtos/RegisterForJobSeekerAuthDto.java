package kodlamaio.hrms.entities.dtos;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterForJobSeekerAuthDto extends AuthDto {

    private String firstName;
    private String lastName;
    private String nationalId;
    private Date dateOfBirth;
    private String repeatPassword;
}
