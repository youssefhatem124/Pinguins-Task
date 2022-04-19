package com.tracker.service;

import com.tracker.dto.IssueDto;
import com.tracker.dto.StoryDto;
import com.tracker.entities.Issue;

import java.util.List;

public interface IssueService {

    List<IssueDto> getAllIssues();
    Issue getIssueById(Integer id);
    Issue updateIssue(String name,Issue issue);
    String deleteDeveloperByName(Integer id);
    IssueDto addIssue(IssueDto issueDto);

    List<StoryDto>getPlan();
    IssueDto getIssueByTitle(String title);

    IssueDto updateIssue(String name, IssueDto issueDto);

    String deleteIssueByName(String name);
}
