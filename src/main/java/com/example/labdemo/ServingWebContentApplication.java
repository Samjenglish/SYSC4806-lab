package com.example.labdemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ServingWebContentApplication {
	public static void main(String[] args) {
		SpringApplication.run(ServingWebContentApplication.class, args);
	}

	@Bean
	public CommandLineRunner demoData(AddressBookRepository addressBookRepository, BuddyInfoRepository buddyInfoRepository) {
		return args -> {
			AddressBook book1 = new AddressBook("Book1");
			AddressBook book2 = new AddressBook("Book2");
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
		};
	}
}


