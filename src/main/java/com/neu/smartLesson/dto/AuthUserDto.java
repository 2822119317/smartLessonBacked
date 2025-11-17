package com.neu.smartLesson.dto;

import com.neu.smartLesson.model.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthUserDto {
    private Integer userId;
    private String username;
    private String fullName;
    private String email;
    private Role role;
}