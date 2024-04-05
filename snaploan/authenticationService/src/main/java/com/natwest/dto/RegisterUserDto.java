package com.natwest.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RegisterUserDto {
    private String email;

    private String password;

    private String fullName;


}
