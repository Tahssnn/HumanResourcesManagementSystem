package kodlamaio.hrms.entities.dtos;

import java.time.LocalDate;

import lombok.Data;

@Data
public class RegisterForJobSeekerAuthDto extends AuthDto {

    private String firstName;
    private String lastName;
    private String nationalId;
    private LocalDate dateOfBirth;
    private String passwordConfirm;
}
