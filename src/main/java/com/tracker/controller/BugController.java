package com.tracker.controller;

import com.tracker.dto.BugDto;
import com.tracker.dto.IssueDto;
import com.tracker.service.BugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/Bugs")
public class BugController {

    @Autowired
    private BugService bugService;

    @PostMapping("/addBug")
    public ResponseEntity<IssueDto> addDBug(@Valid @RequestBody BugDto BugDto) {
        return ResponseEntity.ok(this.bugService.addBug(BugDto));
    }
    @GetMapping("/Bug/{name}")
    public ResponseEntity<IssueDto> geBugByName(@PathVariable String name) {
        return ResponseEntity.ok().body(this.bugService.getBugByTitle(name));
    }

    @GetMapping("/all")
    public ResponseEntity<List<BugDto>> getAllBugs() {
        return ResponseEntity.ok(this.bugService.getAllBugs());
    }
    @PutMapping("/updateBug/{name}")
    public ResponseEntity<IssueDto> updateBug(@PathVariable String name,@Valid @RequestBody BugDto BugDto) {
        return ResponseEntity.ok(this.bugService.updateBug(name, BugDto));
    }

    @DeleteMapping("/Bug/{name}")
    public ResponseEntity<String> deleteBugByName(@PathVariable String name) {
        String msg =this.bugService.deleteBugByName(name);
        return ResponseEntity.ok().body(msg);
    }
}

