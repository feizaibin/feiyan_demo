package com.fzb.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
public class User implements Serializable {

    private Integer uid;
    private String uname;
    private String password;
    private String cld_app_key;
    private String cld_app_secret;
    private String syn_app_key;
    private String syn_app_secret;

}
