package com.cqrs.CqrsPractical.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class UserRequest
{
    @NotBlank(message = "Name is required")
    @Size(min = 2, message = "Name must be at least 2 chars")
    private String name;

    @Email(message = "Invalid email")
    private String email;

    @Min(value = 18, message = "Age must be >= 18")
    private Integer age;

    @NotBlank(message = "City required")
    private String city;

    @Pattern(regexp = "\\d{10}", message = "Phone must be 10 digits")
    private String phone;
}
