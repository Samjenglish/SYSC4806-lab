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
    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="Sam") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }

    @Autowired
    AddressBookRepository addressBookRepository;
    @Autowired
    BuddyInfoRepository buddyInfoRepository;

    private void populateRepositoriesOnStartUp(){
        AddressBook book1 = new AddressBook("test book 1");
        AddressBook book2 = new AddressBook("test book 2");
        BuddyInfo bud1 = new BuddyInfo("Sam", "12");
        BuddyInfo bud2 = new BuddyInfo("Austin", "4312");
        BuddyInfo bud3 = new BuddyInfo("Nikola", "43");
        BuddyInfo bud4 = new BuddyInfo("Hailey", "23");
        BuddyInfo bud5 = new BuddyInfo("Diego", "8675");
        BuddyInfo bud6 = new BuddyInfo("Greg", "987978");
        book1.addBuddy(bud1);
        book1.addBuddy(bud2);
        book1.addBuddy(bud3);
        bud1.setAddressBook(book1);
        bud2.setAddressBook(book1);
        bud3.setAddressBook(book1);
        book2.addBuddy(bud4);
        book2.addBuddy(bud5);
        book2.addBuddy(bud6);
        bud4.setAddressBook(book2);
        bud5.setAddressBook(book2);
        bud6.setAddressBook(book2);
        addressBookRepository.save(book1);
        addressBookRepository.save(book2);
    }

    WebController(AddressBookRepository repository1, BuddyInfoRepository repository2) {
        this.addressBookRepository = repository1;
        this.buddyInfoRepository = repository2;
        populateRepositoriesOnStartUp();
    }

    // BuddyInfo
    @ResponseBody
    @GetMapping("/buddies")
    List<BuddyInfo> allBuddies() {
        return buddyInfoRepository.findAll();
    }

    // AddressBook
    @ResponseBody
    @GetMapping("/books")
    List<AddressBook> allAddressBooks() {
        return addressBookRepository.findAll();
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