package controllers;


import entites.BaseResponse;
import entites.PaymentRequest;
import entites.Users;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

    public static final String sharedKey = "SHARED_KEY";
    private static final String SUCCES_STATUS = "succes";
    private static final String ERROR_STATUS = "error";
    private static final int CODE_SUCCES = 100;
    private static final int AUTH_FAILURE = 102;

    @RequestMapping(value = "/user")
    public ModelAndView user(){
        return new ModelAndView("user", "command", new Users());
    }

    @RequestMapping(value = "/addUser")
    public String addStudent(@ModelAttribute("SpringWeb") Users user
                            , ModelMap model){
        model.addAttribute("name", user.getUserName());
        model.addAttribute("password", user.getPassword());
        model.addAttribute("userID", user.getId());
        return "result";
    }
}
