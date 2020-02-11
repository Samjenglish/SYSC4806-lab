package com.example.labdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/api")
public class restAPIController {
    @Autowired
    private AddressBookRepository addressBookRepository;
    @Autowired
    private BuddyInfoRepository buddyInfoRepository;

    @GetMapping("/buddyinfo")
    public List<BuddyInfo> getAllBuddies() {
        return  buddyInfoRepository.findAll();
    }
    @GetMapping("/buddyinfo/{id}")
    public BuddyInfo getBuddy(@PathVariable(value = "id") Long buddyId) {
       return  buddyInfoRepository.findById(buddyId).orElseThrow(() -> new ItemNotFoundException(buddyId));
    }
    @PostMapping("/buddyinfo")
    public BuddyInfo createBuddyInfo(@Valid @RequestBody BuddyInfo buddy){
        return buddyInfoRepository.save(buddy);
    }
    @GetMapping("/addressbook")
    public List<AddressBook> getAllAddressBooks() {
        return  addressBookRepository.findAll();
    }
    @GetMapping("/addressbook/{id}")
    public AddressBook getAddressBook(@PathVariable(value = "id") Long bookId) {
        return  addressBookRepository.findById(bookId).orElseThrow(() -> new ItemNotFoundException(bookId));
    }
    @PostMapping("/addressbook")
    public AddressBook createAddressBook(@Valid @RequestBody AddressBook book){
        return addressBookRepository.save(book);
    }
    @PostMapping("/addressbook/{bookId}")
    public AddressBook updateAddressBook(@Valid @RequestBody AddressBook book){
        return addressBookRepository.save(book);
    }
}