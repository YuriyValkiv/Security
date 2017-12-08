package com.yura.security.controller;

import com.yura.security.entity.User;
import com.yura.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class RootController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/")
    public String getIndex(ModelMap modelMap) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            List<User> user = userService.getUserByName(userDetails.getUsername());
            modelMap.put("username", user.get(0).getName());
        }
        return "index";
    }
}
