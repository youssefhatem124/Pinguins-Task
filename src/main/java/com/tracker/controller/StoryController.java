package com.tracker.controller;

import com.tracker.dto.BugDto;
import com.tracker.dto.IssueDto;
import com.tracker.dto.StoryDto;
import com.tracker.service.BugService;
import com.tracker.service.StoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/stories")
public class StoryController {

    @Autowired
    private StoryService storyService;

    @PostMapping("/addStory")
    public ResponseEntity<IssueDto> addStory(@Valid @RequestBody StoryDto storyDto) {
        return ResponseEntity.ok(this.storyService.addStory(storyDto));
    }
    @GetMapping("/Story/{name}")
    public ResponseEntity<IssueDto> getStoryByName(@PathVariable String title) {
        return ResponseEntity.ok().body(this.storyService.getStoryByTitle(title));
    }

    @GetMapping("/all")
    public ResponseEntity<List<StoryDto>> getAllstories() {
        return ResponseEntity.ok(this.storyService.getAllStories());
    }
    @PutMapping("/updateStory/{name}")
    public ResponseEntity<IssueDto> updateStory(@PathVariable String name,@Valid @RequestBody StoryDto storyDto) {
        return ResponseEntity.ok(this.storyService.updateStory(name, storyDto));
    }

    @DeleteMapping("/Story/{name}")
    public ResponseEntity<String> deleteStoryByName(@PathVariable String name) {
        String msg =this.storyService.deleteStoryByName(name);
        return ResponseEntity.ok().body(msg);
    }
}
