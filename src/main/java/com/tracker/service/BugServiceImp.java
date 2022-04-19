package com.tracker.service;

import com.tracker.dto.BugDto;
import com.tracker.entities.Bug;
import com.tracker.exceptions.NotFoundException;
import com.tracker.mapper.BugMapper;
import com.tracker.repositories.IssueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class BugServiceImp implements BugService {


    @Autowired
    private IssueRepository issueRepository;
    //    change
    @Autowired
    IssueTypeService issueTypeService;

    @Override
    public List<BugDto> getAllBugs() {
        List<BugDto> BugsDto = Optional.ofNullable(issueRepository.findAllBugs())
                .map(entities -> entities.stream().map(BugMapper.INSTANCE::entityToDto)
                        .collect(Collectors.toList())).orElseThrow(() -> new NotFoundException("No issues Available."));
        return BugsDto;
    }
    @Override
    public BugDto addBug(BugDto bugDto) {
        Bug newBug = BugMapper.INSTANCE.dtoToEntity(bugDto);
        issueRepository.save(newBug);
        return null;
    }





    @Override
    public BugDto getBugByTitle(String title) {
        Bug bug = (Bug) Optional.ofNullable(issueRepository.findByTitle(title))
                .orElseThrow(() -> new NotFoundException("can't find developer with name: " + title));
        BugDto bugDto = BugMapper.INSTANCE.entityToDto(bug);
        return bugDto;
    }

    @Override
    public BugDto updateBug(String name, BugDto bugDto) {
        Bug bug = (Bug) Optional.ofNullable(issueRepository.findByTitle(name))
                .orElseThrow(() -> new NotFoundException("can't find developer with name: " + name));
        bug = BugMapper.INSTANCE.dtoToEntity(bugDto);
        Bug updatedBug = issueRepository.save(bug);
        return BugMapper.INSTANCE.entityToDto(updatedBug);
    }

    @Override
    public String deleteBugByName(String name) {
        Bug bug = (Bug) Optional.ofNullable(issueRepository.findByTitle(name))
                .orElseThrow(() -> new NotFoundException("can't find developer with name: " + name));
        issueRepository.deleteByTitle(name);
        return "success deleted customer with name " + name;
    }

}
