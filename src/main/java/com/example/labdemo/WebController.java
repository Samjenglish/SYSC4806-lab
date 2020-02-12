package com.example.labdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class WebController {
    @Autowired
    private AddressBookRepository addressBookRepository;
    @Autowired
    private BuddyInfoRepository buddyInfoRepository;

    @GetMapping("/buddyinfoform")
    public String buddyinfoform(Model model) {
        List<AddressBook> bookList = addressBookRepository.findAll();
        model.addAttribute("books", bookList);
        return "buddyform.html";
    }
    @GetMapping("/addressbookform")
    public String addressbookForm(Model model) {
        return "addressbookform.html";
    }
    @PostMapping("/addressbook")
    public String createAddressBook(@RequestParam String bookName){
        AddressBook book = new AddressBook(bookName);
        addressBookRepository.save(book);
        return "sucaddressbook.html";
    }
    @PostMapping("/buddyinfo")
    public String createBuddyInfo(@RequestParam String bookId, @RequestParam String name, @RequestParam String phoneNumber){
        BuddyInfo buddy = new BuddyInfo(name, phoneNumber);
        AddressBook book = addressBookRepository.findById(Long.valueOf(bookId)).orElseThrow(() -> new ItemNotFoundException(Long.valueOf(bookId)));
        book.addBuddy(buddy);
        buddy.setAddressBook(book);
        addressBookRepository.save(book);
        return "sucbuddyinfo.html";
    }
    @GetMapping("/content")
    public String contentPage(Model model) {
        List<AddressBook> bookList = addressBookRepository.findAll();
        model.addAttribute("books", bookList);
        return "addressbookcontent.html";
    }
    @GetMapping("/spa")
    public String displayPage(Model model) {
        List<AddressBook> bookList = addressBookRepository.findAll();
        model.addAttribute("bookList", bookList);
        return "index.html";
    }

    @GetMapping("/test")
    public @ResponseBody String testRoute() {
        return "test";
    }
}