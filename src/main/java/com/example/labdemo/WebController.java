package com.example.labdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class WebController {
    @Autowired
    private AddressBookRepository addressBookRepository;
    @Autowired
    private BuddyInfoRepository buddyInfoRepository;

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="Sam") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }
    @GetMapping("/main")
    public String main_page(Model model) {
        List<AddressBook> bookList = addressBookRepository.findAll();
        model.addAttribute("bookList", bookList);
        return "main";
    }
    @GetMapping("/test")
    public @ResponseBody String testRoute() {
        return "test";
    }
}