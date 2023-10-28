package com.example.project;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Member {
    @Id
    @Column(length=20, nullable = false, unique = true)
    private String username;

    @Column
    private String password;
}
