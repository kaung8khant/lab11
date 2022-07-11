package edu.miu.cs.cs425.eregistrarwebapi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class StudentRequest {
    @NotEmpty(message = "Student Number is required")
    private String studentNumber;

    @NotEmpty(message = "First Name is required")
    private String firstName;

    private String middleName;

    @NotEmpty(message = "Last Name is required")
    private String lastName;

    private Double cgpa;
    
    private LocalDate enrollmentDate;

    private Boolean isInternational;
}
