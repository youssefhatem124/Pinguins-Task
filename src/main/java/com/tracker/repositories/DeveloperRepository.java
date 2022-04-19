package com.tracker.repositories;

import com.tracker.entities.Developer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface DeveloperRepository extends JpaRepository<Developer, Long> {

    Developer findByName(String name);
    @Transactional
    @Modifying
    @Query("delete from Developer d where d.name=:name")
    void deleteByName(@Param("name") String name);
}
