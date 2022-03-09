package org.launchcode.KBudget.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class MainController {

    @GetMapping("")
    public String showBudgetPage(){
        System.out.println("main controller");
        return "index";
    }
}
