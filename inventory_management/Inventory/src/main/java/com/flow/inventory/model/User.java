package com.flow.inventory.model;
// Generated Mar 10, 2016 2:37:53 PM by Hibernate Tools 4.3.1

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User implements java.io.Serializable {

    private long id;
    private String email;
    private boolean isActive;
    private String displayName;
    private String password;
    private String description;
    private String imageUrl;

    private Set<UserRole> userRoles = new HashSet<>();

    public User() {
    }

    public User(String email, boolean isActive, String displayName, String password) {
        this.userRoles = new HashSet(0);
        this.email = email;
        this.isActive = isActive;
        this.displayName = displayName;
        this.password = password;
    }

    public User(String email, boolean isActive, String displayName, String password, Set userRoles) {
        this.userRoles = new HashSet(0);
        this.email = email;
        this.isActive = isActive;
        this.displayName = displayName;
        this.password = password;
        this.userRoles = userRoles;
    }

    @Id
    @GeneratedValue
    @Column(name = "id")
    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "email")
    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "is_active")
    public boolean isIsActive() {
        return this.isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    @Column(name = "display_name")
    public String getDisplayName() {
        return this.displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    @Column(name = "password")
    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @OneToMany(mappedBy = "user", targetEntity = UserRole.class, fetch = FetchType.LAZY)
    public Set getUserRoles() {
        return this.userRoles;
    }

    public void setUserRoles(Set userRoles) {
        this.userRoles = userRoles;
    }

    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        //  TODO: Remove hardcoding later
        return "/resources/img/ervinne.jpg";
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

}
