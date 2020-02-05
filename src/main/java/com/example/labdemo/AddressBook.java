package com.example.labdemo;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class AddressBook {
    private List<BuddyInfo> buddyList = new ArrayList<BuddyInfo>();
    private Long id;

    public static void main(String[] args) {
        AddressBook newBook = new AddressBook();
        BuddyInfo buddy1 = new BuddyInfo("Sam", "18001234");
        BuddyInfo buddy2 = new BuddyInfo("Austin", "9876543");
        BuddyInfo buddy3 = new BuddyInfo("Nikola", "3456789");
        newBook.addBuddy(buddy1);
        newBook.addBuddy(buddy2);
        newBook.addBuddy(buddy3);
        System.out.println(newBook.toString());
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
    public List<BuddyInfo> getAddressList(){
        return this.buddyList;
    }
    public void setAddressList(List<BuddyInfo> buddyList){
        this.buddyList = buddyList;
    }
    public String toString(){
        String returnString = "";
        for(int i = 0; i < this.buddyList.size(); i++){
            returnString += (this.buddyList.get(i).getName() + ' ' + this.buddyList.get(i).getPhoneNumber() + "\n");
        }
        return returnString;
    }
}
