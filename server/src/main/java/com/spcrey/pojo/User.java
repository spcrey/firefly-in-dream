package com.spcrey.pojo;

import java.time.LocalDateTime;

import org.hibernate.validator.constraints.URL;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.groups.Default;
import jakarta.validation.constraints.Email;
import lombok.Data;

@Data
public class User {

    private Integer id;

    private String username;

    @JsonIgnore
    private String password;

    @Pattern(groups = Update.class, regexp = "^\\S{5,16}$")
    private String nickname;

    @Email(groups = Update.class)
    private String email;

    @URL
    private String userPic;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;
    
    public interface Update extends Default {}
}
