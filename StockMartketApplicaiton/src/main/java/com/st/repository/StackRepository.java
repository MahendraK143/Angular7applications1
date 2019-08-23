package com.st.repository;

import com.st.bean.StackBean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
public interface StackRepository extends JpaRepository<StackBean,Long> {
    StackBean findStackByName(String name);
}
