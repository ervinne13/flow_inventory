/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flow.inventory.interceptors;

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
public class CommonViewAttributesInterceptor extends HandlerInterceptorAdapter {

    public static final String ATTR_APP_NAME_HTML = "commonAppNameHtml";
    public static final String ATTR_APP_NAME_MINI_HTML = "commonAppNameMiniHtml";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        //  FIXME: put values on a properties file later
        request.setAttribute(ATTR_APP_NAME_HTML, "<span class=\"logo-lg\"><b>Inventory</b>etc</span>");
        request.setAttribute(ATTR_APP_NAME_MINI_HTML, "<span class=\"logo-mini\"><b>I</b>e</span>");

        return true;
    }

}
