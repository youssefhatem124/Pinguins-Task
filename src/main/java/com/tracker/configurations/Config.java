package com.tracker.configurations;

import com.tracker.entities.Bug;
import com.tracker.entities.Issue;
import com.tracker.entities.Story;
import com.tracker.enums.IssueType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class Config {

//    private Map<Enum, Issue> issueStrategies;
//
////    @Autowired
////    Bug bug;
//    @Autowired
//    Story story;
//
//    @Bean(name = "populateIssueStrategies")
//    public Map<Enum, Issue> populateIssueStrategies(){
//        issueStrategies = new HashMap<>();
////        issueStrategies.put(IssueType.BUG, bug);
//        issueStrategies.put(IssueType.STORY, story);
//        return issueStrategies;
//
//    }

}
