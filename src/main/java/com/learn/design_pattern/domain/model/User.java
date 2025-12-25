package com.learn.design_pattern.domain.model;

import com.learn.design_pattern.domain.enums.UserType;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
    private String userId;
    private UserType userType;

}
