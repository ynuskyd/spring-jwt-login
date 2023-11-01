package com.akayk.keepin.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterDto {

    private String username;
    private String email;
    private String password;
}
