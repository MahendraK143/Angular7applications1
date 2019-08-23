package com.stack.repository;

import com.stack.bean.StackBean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
//@CrossOrigin(origins = "http://localhost:4200")
public interface StackRepository extends JpaRepository<StackBean,Integer> {
    StackBean findStackByName(String name);
}
