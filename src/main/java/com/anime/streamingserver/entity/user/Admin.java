package com.anime.streamingserver.entity.user;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    private int active;

    private String roles = "";

    private String permissions = "";

    public Admin() {

    }

    public Admin(String username, String password, String roles, String permissions){
        this.username = username;
        this.password = password;
        this.roles = roles;
        this.permissions = permissions;
        this.active = 1;
    }

}
