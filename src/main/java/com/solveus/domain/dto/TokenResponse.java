package com.solveus.domain.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
public class TokenResponse {
    private String ACCESS_TOKEN;
    private String REFRESH_TOKEN;
}
