package com.java_tuan4.kiemtra.Entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String username;

    @Column(unique = true)
    private String email;

    private String password;
    private String firstName;
    private String lastName;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthDay;

    private boolean isDeleted;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    public User(Long id, String username, String email, String password, String firstName, String lastName, Date birthDay, boolean isDeleted) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDay = birthDay;
        this.isDeleted = isDeleted;
    }

    // Getter cho isDeleted
    public boolean isDeleted() {
        return isDeleted;
    }

    // Setter cho isDeleted
    public void setDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }
}
