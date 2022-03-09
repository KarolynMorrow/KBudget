package org.launchcode.KBudget.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IncomeController {

    @GetMapping("income")
    @ResponseBody
    public String Income() {
        return "Is it working?";
    }

}
