//package com.example.yourdestinyweb.models;
//
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import java.text.SimpleDateFormat;
//import java.util.*;
//
//import java.util.Collection;
//
//@Entity
//@Table(name = "usr")
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//public class User implements UserDetails {
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    Long id;
//
//    @Column(name = "username")
//    private String username;
//
//    @Column(name = "password")
//    private String password;
//
//
//    @Column(name = "birthday")
//    private Date birthday;
//    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
//    @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"))
//    @Enumerated(EnumType.STRING)
//    private Set<Role> roles;
//    //@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
//    //List<Appointment> cartItemList;
//
//    public User(String username,  Set<Role> roles) {
//        this.username = username;
//
//        this.roles = roles;
//    }
//
//
//
//    public User(String username, String password, Set<Role> roles) {
//        this.username = username;
//        this.password = password;
//        this.roles = roles;
//    }
//
//    public boolean isAdmin() {
//        return roles.contains(Role.ADMIN);
//    }
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return roles;
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return true;
//    }
//}
//