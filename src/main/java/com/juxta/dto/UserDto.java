package com.juxta.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Long id;

    @NotEmpty(message = "Please enter name!")
    private String name;

    @NotEmpty(message = "Please enter email!")
    @Email
    private String email;

    @NotEmpty(message = "Please enter password!")
    private String password;
}
