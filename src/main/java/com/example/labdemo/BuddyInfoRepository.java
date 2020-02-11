package com.example.labdemo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "buddyinfo", path = "buddyinfo")
public interface BuddyInfoRepository extends CrudRepository<BuddyInfo, Long> {
    List<BuddyInfo> findByName(@Param("name") String name);
    List<BuddyInfo> findByPhoneNumber(@Param("phoneNumber") String phoneNumber);
    BuddyInfo findById(long id);
    List<BuddyInfo> findAll();
}