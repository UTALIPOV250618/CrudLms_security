package peaksoft.crudlms_security.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/")
public class MainController {

    @RequestMapping
    public String viewMainPage(){
        return "main_page";
    }
}
