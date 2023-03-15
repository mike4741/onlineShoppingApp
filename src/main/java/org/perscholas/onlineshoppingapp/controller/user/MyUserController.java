package org.perscholas.onlineshoppingapp.controller.user;

import lombok.extern.slf4j.Slf4j;
import org.perscholas.onlineshoppingapp.models.User.MyUser;
import org.perscholas.onlineshoppingapp.service.user.MyUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//@RequestMapping("/user")
@Slf4j
public class MyUserController {

    private final MyUserService myUserService;

    public MyUserController(MyUserService myUserService) {
        this.myUserService = myUserService;
    }

    @PostMapping("/myUser")
    public String updateOrCreateUser(@ModelAttribute("myUser") MyUser user, Model model) throws Exception {
        log.info("call user controller"+ user.getEmail());
        MyUser myUser = myUserService.createOrUpdate(user);
//        model.addAttribute("myUser",myUser);
        model.addAttribute("message", "success");

        return "myUser";
    }




}
