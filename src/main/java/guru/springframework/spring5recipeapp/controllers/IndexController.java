package guru.springframework.spring5recipeapp.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class IndexController {



    @RequestMapping({"", "/", "/index", "/index.html"})
    public String getIndexPage(Model model) {
        System.out.println("Some Message to say...hello");
        return "index";
    }
}
