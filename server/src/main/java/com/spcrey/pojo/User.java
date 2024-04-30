package com.spcrey.pojo;

import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.groups.Default;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class User {

    private Integer id;

    @NotNull
    @Pattern(regexp = "^\\S{5,16}$")
    private String username;

    @Pattern(regexp = "^\\S{5,16}$")
    @JsonIgnore
    private String password;

    @NotNull(groups = Update.class)
    @Pattern(regexp = "^\\S{5,16}$")
    private String nickname;

    @NotNull(groups = Update.class)
    @Email
    private String email;

    private String userPic;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;
    
    public interface Update extends Default {}
}
