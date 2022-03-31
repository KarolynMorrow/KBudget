package org.launchcode.KBudget.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class MainController {

    @GetMapping("")
    public String showBudgetPage(Model model){
        model.addAttribute("title", "My Monthly Budget");
        return "index";
    }
}
