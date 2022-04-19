package com.tracker.repositories;

import com.tracker.entities.Bug;
import com.tracker.entities.Issue;
import com.tracker.entities.Story;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface IssueRepository extends JpaRepository<Issue, Long> {

    Issue findByTitle(String title);
    @Transactional
    @Modifying
    void deleteByTitle( String name);
    @Query(value = "select * from ISSUE  where Issue_Type='bug'",nativeQuery = true)
    List<Bug> findAllBugs();
    @Query(value = "select * from ISSUE  where Issue_Type='story'",nativeQuery = true)
    List<Story> findAllStories();
}
