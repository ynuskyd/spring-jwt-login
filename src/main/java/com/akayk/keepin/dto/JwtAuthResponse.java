package com.akayk.keepin.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JwtAuthResponse {

    private String authenticationToken;
    private String username;
}
