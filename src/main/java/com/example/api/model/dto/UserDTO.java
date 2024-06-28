package com.example.api.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NegativeOrZero;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTO {
    @NotBlank(message = "The 'name' field cannot be empty")
    @NotNull(message = "The 'name' field cannot be null")
    private String name;
    @NotBlank(message = "The 'lastName' field cannot be empty")
    @NotNull(message = "The 'lastName' field cannot be null")
    @JsonProperty("last_name")
    private String lastName;
    private int age;
    @NotBlank(message = "The 'email' field cannot be empty")
    @NotNull(message = "The 'email' field cannot be null")
    @Email(message = "The 'email' must be email")
    private String email;
    @NotBlank(message = "The 'userName' field cannot be empty")
    @NotNull(message = "The 'userName' field cannot be null")
    @JsonProperty("user_name")
    private String userName;
    @NotBlank(message = "The 'password' field cannot be empty")
    @NotNull(message = "The 'password' field cannot be null")
    private String password;
}
