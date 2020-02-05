package com.example.labdemo;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "addressbooks", path = "addressbooks")
public interface AddressBookRepository  extends PagingAndSortingRepository<AddressBook, Long> {
    AddressBook findById(long id);
    List<AddressBook> findByBookName(@Param("bookName") String bookName);
    List<AddressBook> findAll();
}