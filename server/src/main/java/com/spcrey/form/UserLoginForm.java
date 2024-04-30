package com.spcrey.form;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class UserLoginForm {
    @NotNull
    @Pattern(regexp = "^\\S{3,16}$")
    private String username;
    @NotNull
    @Pattern(regexp = "^\\S{10,24}$")
    private String password;
}
