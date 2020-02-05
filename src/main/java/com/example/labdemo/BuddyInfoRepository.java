package com.example.labdemo;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

public interface BuddyInfoRepository extends PagingAndSortingRepository<BuddyInfo, Long> {
    List<BuddyInfo> findByName(@Param("name") String name);
    List<BuddyInfo> findByPhoneNumber(@Param("phoneNumber") String phoneNumber);
    BuddyInfo findById(long id);
}