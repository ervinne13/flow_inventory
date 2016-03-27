/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flow.inventory.adapters;

import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Ervinne Sodusta
 */
public class JsonView {

    public static ModelAndView Render(Object model, HttpServletResponse response) {
        MappingJackson2HttpMessageConverter jsonConverter = new MappingJackson2HttpMessageConverter();

        MediaType jsonMimeType = MediaType.APPLICATION_JSON;

        try {
            jsonConverter.write(model, jsonMimeType, new ServletServerHttpResponse(response));
        } catch (HttpMessageNotWritableException | IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
