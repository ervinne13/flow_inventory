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

    public static final String ATTR_APP_NAME_HTML = "appNameHtml";
    public static final String ATTR_APP_NAME_MINI_HTML = "appNameMiniHtml";

    public static final String ATTR_APP_AUTHOR = "appAuthor";
    public static final String ATTR_APP_AUTHOR_WEBSITE = "appWebSite";

    public static final String ATTR_APP_VERSION_NAME = "appVersion";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        //  FIXME: put values on a properties file later
        request.setAttribute(ATTR_APP_NAME_HTML, "<span class=\"logo-lg\"><b>Inventory</b>etc</span>");
        request.setAttribute(ATTR_APP_NAME_MINI_HTML, "<span class=\"logo-mini\"><b>I</b>e</span>");

        request.setAttribute(ATTR_APP_AUTHOR, "Ervinne Sodusta");
        request.setAttribute(ATTR_APP_AUTHOR_WEBSITE, "https://www.facebook.com/ervinne.sodusta");
        request.setAttribute(ATTR_APP_VERSION_NAME, "0.1 Beta");

        System.out.println("Intercepted");

        return true;
    }

}
