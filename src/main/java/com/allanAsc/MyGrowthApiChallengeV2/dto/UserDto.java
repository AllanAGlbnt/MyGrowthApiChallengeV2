package com.allanAsc.MyGrowthApiChallengeV2.dto;


import com.allanAsc.MyGrowthApiChallengeV2.user.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserDto {
    private Long id;
    private String username;
    private String email;
    private String fullName;
    private String password;
    Set<Role> roles;
    private boolean enabled;


}
