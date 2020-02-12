package com.example.labdemo;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class AddressBook {
    private List<BuddyInfo> buddyList = new ArrayList<BuddyInfo>();
    private Long id;
    private String bookName;

    public static void main(String[] args) {
    }
    public AddressBook(){
    }
    public AddressBook(String bookName){
        this.setBookName(bookName);
    }
    public AddressBook(String bookName, List<BuddyInfo> buddyList){
        this.setBookName(bookName);
        this.setBuddyList(buddyList);
    }
    public void setBookName(String bookName){
        this.bookName = bookName;
    }
    public String getBookName(){
        return this.bookName;
    }

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public void addBuddy(BuddyInfo buddy) {
        this.buddyList.add(buddy);
    }
    public void removeBuddy(int index){
        buddyList.remove(index);
    }
    public int addressSize(){
        return this.buddyList.size();
    }

    @OneToMany(mappedBy = "addressBook", cascade = CascadeType.ALL)
    public List<BuddyInfo> getBuddyList(){
        return this.buddyList;
    }
    public void setBuddyList(List<BuddyInfo> buddyList){
        this.buddyList = buddyList;
    }
    public String createFullString(){
        String returnString = "";
        for(int i = 0; i < this.buddyList.size(); i++){
            returnString += (this.buddyList.get(i).getName() + ' ' + this.buddyList.get(i).getPhoneNumber() + "\n");
        }
        return returnString;
    }
}
