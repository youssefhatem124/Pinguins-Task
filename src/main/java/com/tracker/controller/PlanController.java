package com.tracker.controller;

import com.tracker.dto.IssueDto;
import com.tracker.dto.StoryDto;
import com.tracker.service.IssueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class PlanController {
    @Autowired
    private IssueService issueService;

    @GetMapping("/plan")
    public ResponseEntity<List<StoryDto>> Getplan() {
        return ResponseEntity.ok().body(this.issueService.getPlan());
    }
}
