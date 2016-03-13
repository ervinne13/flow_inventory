/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flow.inventory.interceptors;

import static com.flow.inventory.interceptors.CommonViewAttributesInterceptor.ATTR_APP_NAME_HTML;
import static com.flow.inventory.interceptors.CommonViewAttributesInterceptor.ATTR_APP_NAME_MINI_HTML;
import com.flow.inventory.model.User;
import com.flow.inventory.service.UserService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 *
 * @author Ervinne Sodusta
 */
public class AuthenticatedViewAttritubesInterceptor extends HandlerInterceptorAdapter {

    public static final String ATTR_AUTHENTICATED_USER = "authenticatedUser";

    @Autowired
    private UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        User authenticatedUser = userService.getCurrentlyAuthenticatedUser();

        if (authenticatedUser != null) {
            request.setAttribute(ATTR_AUTHENTICATED_USER, authenticatedUser);
        }

        return true;
    }

}
