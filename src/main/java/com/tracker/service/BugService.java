package com.tracker.service;

import com.tracker.dto.BugDto;
import com.tracker.dto.IssueDto;
import com.tracker.entities.Bug;

import java.util.List;

public interface BugService {
    List<BugDto> getAllBugs();
    BugDto addBug(BugDto bugDto);
    BugDto getBugByTitle(String title);
    BugDto updateBug(String name, BugDto bugDto);
    String deleteBugByName(String name);
}
