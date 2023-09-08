package com.harsha.controller;
import com.harsha.dao.UserDao;
import com.harsha.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class LoginController {

    @Autowired
    UserDao userDao;


    @GetMapping("/loginPage")
    public String getLoginPage(){
        return "Login";
    }


    @PostMapping("/validateUser")
    public String  authenticateUser(@RequestParam("uname")String username, @RequestParam("pword")String pasword, Model model, HttpServletResponse response) throws ClassNotFoundException {
        String message = "Invalid Username / Password ... Try Again...!";
        User user = new User(username,pasword);




        if(userDao.validateUser(user))
        {

            message = "Successs";


            model.addAttribute("message",message);
            System.out.println("success");


            return "Search";
        }

        model.addAttribute("message",message);
        return "Display";
    }



}