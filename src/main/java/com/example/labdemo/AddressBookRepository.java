package com.example.labdemo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "addressbook", path = "addressbook")
public interface AddressBookRepository  extends CrudRepository<AddressBook, Long> {
    AddressBook findById(long id);
    List<AddressBook> findByBookName(@Param("bookName") String bookName);
    List<AddressBook> findAll();
}