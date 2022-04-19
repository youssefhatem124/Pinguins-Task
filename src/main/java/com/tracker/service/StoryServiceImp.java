package com.tracker.service;
import com.tracker.dto.StoryDto;
import com.tracker.entities.Story;
import com.tracker.exceptions.NotFoundException;
import com.tracker.mapper.StoryMapper;
import com.tracker.repositories.IssueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StoryServiceImp implements StoryService{
    @Autowired
    private IssueRepository issueRepository;
    @Autowired
    IssueTypeService issueTypeService;

    @Override
    public List<StoryDto> getAllStories() {
        List<StoryDto> StoriesDto = Optional.ofNullable(issueRepository.findAllStories())
                .map(entities -> entities.stream().map(StoryMapper.INSTANCE::entityToDto)
                        .collect(Collectors.toList())).orElseThrow(() -> new NotFoundException("No issues Available."));
        return StoriesDto;
    }
    @Override
    public StoryDto addStory(StoryDto storyDto) {
        Story newstory = StoryMapper.INSTANCE.dtoToEntity(storyDto);
        issueRepository.save(newstory);
        return null;
    }





    @Override
    public StoryDto getStoryByTitle(String title) {
        Story story = (Story) Optional.ofNullable(issueRepository.findByTitle(title))
                .orElseThrow(() -> new NotFoundException("can't find developer with name: " + title));
        StoryDto storyDto = StoryMapper.INSTANCE.entityToDto(story);
        return storyDto;
    }

    @Override
    public StoryDto updateStory(String name, StoryDto storyDto) {
        Story story = (Story) Optional.ofNullable(issueRepository.findByTitle(name))
                .orElseThrow(() -> new NotFoundException("can't find developer with name: " + name));
        story = StoryMapper.INSTANCE.dtoToEntity(storyDto);
        Story updatedStory = issueRepository.save(story);
        return StoryMapper.INSTANCE.entityToDto(updatedStory);
    }

    @Override
    public String deleteStoryByName(String name) {
        Story story = (Story) Optional.ofNullable(issueRepository.findByTitle(name))
                .orElseThrow(() -> new NotFoundException("can't find developer with name: " + name));
        issueRepository.deleteByTitle(name);
        return "success deleted customer with name " + name;
    }
}
