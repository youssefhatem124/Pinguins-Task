package com.tracker.service;

import com.tracker.dto.BugDto;
import com.tracker.dto.IssueDto;
import com.tracker.dto.StoryDto;
import com.tracker.entities.Issue;
import com.tracker.entities.Story;

import java.util.List;

public interface StoryService {
    List<StoryDto> getAllStories();

    StoryDto addStory(StoryDto storyDto);
    StoryDto getStoryByTitle(String title);
    StoryDto updateStory(String name, StoryDto storyDto);
    String deleteStoryByName(String name);
}