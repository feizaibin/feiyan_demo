package com.fzb.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Authority implements Serializable {

    private Integer aid;
    private String aname;
    private String description;

}
