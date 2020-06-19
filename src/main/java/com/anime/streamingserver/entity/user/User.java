package com.anime.streamingserver.entity.user;


import com.anime.streamingserver.entity.auth.AuthProvider;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    @JsonIgnore
    private String password;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private Boolean emailVerified;

    @NotNull
    @Enumerated(EnumType.STRING)
    private AuthProvider provider;

    private String providerId;

    private String roles = "";

    private String permissions = "";

    public User() {

    }

    public User(String username, String password, String roles, String permissions){
        this.username = username;
        this.password = password;
        this.roles = roles;
        this.permissions = permissions;
        this.emailVerified = false;
    }
}
