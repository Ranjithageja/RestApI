package com.example.bus.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bus.model.BusManagement;

/*@Repository-is used to indicate that the class provides the mechanism for storage, retrieval, search, update and delete operation on objects  
JPA Repository is mainly used for managing the data in a Spring Boot Application*/
/*JpaRepository<BusManagement,Integer>*/


public interface BusManagementRepo extends JpaRepository<BusManagement, Integer> { 

}
