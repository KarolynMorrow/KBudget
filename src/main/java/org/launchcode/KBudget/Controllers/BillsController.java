package org.launchcode.KBudget.Controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BillsController {

    @GetMapping("bills")
    @ResponseBody
    public String bill(){
        return "this is a bill";
    }
}
