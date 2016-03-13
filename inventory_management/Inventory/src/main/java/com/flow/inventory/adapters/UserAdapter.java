/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flow.inventory.adapters;

import com.flow.inventory.model.User;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 *
 * @author Ervinne Sodusta
 */
public class UserAdapter {

    public static UserDetails toUserDetails(User user) {

        return new UserDetails() {

            @Override
            public Collection<? extends GrantedAuthority> getAuthorities() {

                List<SimpleGrantedAuthority> auths = new java.util.ArrayList<>();
                Set<String> roles = user.getUserRoles();

                roles.stream().forEach((role) -> {
                    auths.add(new SimpleGrantedAuthority(role));
                    System.out.println("Role: " + role);
                });

                return auths;
            }

            @Override
            public String getPassword() {
                return user.getPassword();
            }

            @Override
            public String getUsername() {
                return user.getEmail();
            }

            @Override
            public boolean isAccountNonExpired() {
                return true;
            }

            @Override
            public boolean isAccountNonLocked() {
                return true;
            }

            @Override
            public boolean isCredentialsNonExpired() {
                return true;
            }

            @Override
            public boolean isEnabled() {
                return true;
            }
        };

    }

}
