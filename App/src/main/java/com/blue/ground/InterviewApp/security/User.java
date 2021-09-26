package com.blue.ground.InterviewApp.security;

import javax.persistence.*;

@Entity
@Table(name = "USERS")
public class User implements java.io.Serializable {

    @Id
    @SequenceGenerator(name = "USERS_SEQ", sequenceName = "USERS_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USERS_SEQ")
    @Column(name = "ID", unique = true, nullable = false, length = 10)
    private Long id;

    @Column(name = "USERNAME", nullable = false, length = 250)
    private String username;

    @Column(name = "PASSWORD", nullable = false, length = 250)
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
