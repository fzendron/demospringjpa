package com.zendron.demo.repository;

import com.zendron.demo.model.People;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PeopleRepository extends JpaRepository<People, Long> {
}