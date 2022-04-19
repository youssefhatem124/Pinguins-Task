package com.tracker.service;

import com.tracker.dto.IssueDto;
import com.tracker.dto.StoryDto;
import com.tracker.entities.Developer;
import com.tracker.entities.Issue;
import com.tracker.entities.Story;
import com.tracker.enums.Status;
import com.tracker.exceptions.NotFoundException;
import com.tracker.mapper.IssueMapper;
import com.tracker.mapper.StoryMapper;
import com.tracker.repositories.DeveloperRepository;
import com.tracker.repositories.IssueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;


@Service
public class IssueServiceImpl implements IssueService {


    @Autowired
    private IssueRepository issueRepository;
    @Autowired
    IssueTypeService issueTypeService;

    @Autowired
    DeveloperRepository developerRepository;

    @Override
    public List<IssueDto> getAllIssues() {
        List<IssueDto> issuesDtos = Optional.ofNullable(issueRepository.findAll())
                .map(entities -> entities.stream().map(IssueMapper.INSTANCE::entityToDto)
                .collect(Collectors.toList())).orElseThrow(() -> new NotFoundException("No issues Available."));
        return issuesDtos;
    }

    @Override
    public Issue getIssueById(Integer id) {
        return null;
    }

    @Override
    public Issue updateIssue(String name, Issue issue) {
        return null;
    }

    @Override
    public String deleteDeveloperByName(Integer id) {
        return null;
    }

    @Override
    public IssueDto addIssue(IssueDto issueDto) {
            Issue newIssue = IssueMapper.INSTANCE.dtoToEntity(issueDto);
            issueRepository.save(newIssue);


        return null;
    }

    @Override
    public List<StoryDto> getPlan() {
        int i = 0;
        List<Story>stories=issueRepository.findAllStories().stream().filter(story -> Objects.equals(story.getStatus(),Status.Estimated)).collect(Collectors.toList());;
        List<Developer>developers=developerRepository.findAll();
        for(Story story:stories)
        {
            if(i<developers.size())
            {
                int sum=0;
          Developer d =developers.get(i);
          if(d.getStories().size()>0) {
              for (Story story1 : d.getStories()) {
                  sum += story1.getEstimatedPointValue();
              }
          }
                sum+=story.getEstimatedPointValue();
          if(d.getStories() == null && sum<=10 )
            story.setDeveloper(d);
            story.setStatus(Status.Estimated);
           List<Story>storyList= d.getStories();
           if(storyList .size()==0)
           {
               List<Story>storyList1 = new ArrayList<>();
               storyList1.add(story);
               d.setStories(storyList1);
               story.setStatus(Status.Estimated);
               story.setDeveloper(d);
               developerRepository.save(d);
           }
           else
           {
               storyList.add(story);
               d.setStories(storyList);
               story.setDeveloper(d);
               developerRepository.save(d);
           }
            }
             if(i==developers.size() -1)
            {
                i=-1;
            }
            i++;
        issueRepository.save(story);
        }

        List<StoryDto> StoriesDto = Optional.ofNullable(issueRepository.findAllStories())
                .map(entities -> entities.stream().map(StoryMapper.INSTANCE::entityToDto)
                        .collect(Collectors.toList())).orElseThrow(() -> new NotFoundException("No issues Available."));
        return StoriesDto;
    }


    @Override
    public IssueDto getIssueByTitle(String title) {
        Issue issue = Optional.ofNullable(issueRepository.findByTitle(title))
                                      .orElseThrow(() -> new NotFoundException("can't find developer with name: " + title));
        IssueDto issueDto = IssueMapper.INSTANCE.entityToDto(issue);
        return issueDto;
    }

    @Override
    public IssueDto updateIssue(String name, IssueDto issueDto) {
        Issue issue = Optional.ofNullable(issueRepository.findByTitle(name))
                .orElseThrow(() -> new NotFoundException("can't find developer with name: " + name));
        issue = IssueMapper.INSTANCE.dtoToEntity(issueDto);
        Issue updatedIssue = issueRepository.save(issue);
        return IssueMapper.INSTANCE.entityToDto(updatedIssue);
    }

    @Override
    public String deleteIssueByName(String name) {
        Issue issue = Optional.ofNullable(issueRepository.findByTitle(name))
                                      .orElseThrow(() -> new NotFoundException("can't find developer with name: " + name));
        issueRepository.deleteByTitle(name);
        return "success deleted customer with name " + name;
    }





}
