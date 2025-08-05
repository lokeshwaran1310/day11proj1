package com.example.issueTrackerOrm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.issueTrackerOrm.domain.Bug;
import com.example.issueTrackerOrm.service.BugService;

@RestController
@RequestMapping("/api/bugs")
public class BugController {
     @Autowired
     private BugService bugService;

     @GetMapping
     public List<Bug> getAllBugs(){
        List<Bug> l=bugService.getAllBugs();
        if(l.isEmpty()){
             throw new IllegalArgumentException("No Bugs");
        }
        return l;
     }
     @GetMapping("/status/{status}")
     public List<Bug> findByStatus(@PathVariable String status){    
       if (status== null || status.isEmpty()) {
            throw new IllegalArgumentException("Status should not be empty or null");
        }
        return bugService.findByStatus(status);
    }
    @GetMapping("/project/{project_id}")
    public List<Bug> findByProjectId(@PathVariable long project_id) {
         if (project_id <= 0) {
            throw new IllegalArgumentException("Project ID must be a positive number");
        }
        return bugService.findByProjectId(project_id);
    }
    @GetMapping("/assigned-to/{userid}")
    public List<Bug> findByAssignedToId(@PathVariable int userid) {
        if(userid<=0){
            throw new IllegalArgumentException("User ID must be a positive number");
        }
        return bugService.findByAssignedToId(userid);
    }
    @GetMapping("/unresolved/user/{userid}")
    public List<Bug> findUnresolvedBugsByUserId(@PathVariable Long userid) {
        if(userid<=0){
           throw new IllegalArgumentException("User ID must be a positive number");
        }
        return bugService.findUnresolvedBugsByUserId(userid);
    }
    @GetMapping("/count/project/{projectId}")
    public Long countBugsByProjectId(@PathVariable Long projectId) {
        if (projectId == null || projectId <= 0) {
            throw new IllegalArgumentException("Project ID must be a positive number");
        }
        return bugService.countBugsByProjectId(projectId);
    }
    @GetMapping("/{id}")
    public Bug findById(@PathVariable long id){
         if(id<=0){
           throw new IllegalArgumentException("ID must be a positive number");
        }
        return bugService.findById(id);
    }
    @PostMapping("/create")
    public Bug save(@RequestBody Bug bug){
        if (bug == null || bug.getTitle() == null || bug.getDescription() == null) {
            throw new IllegalArgumentException("Bug title and description cannot be null");
        }
        return bugService.save(bug);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable long id){
        if(id<=0){
            throw new IllegalArgumentException("ID must be a positive number");
        }
        bugService.deleteById(id);
        return ResponseEntity.ok("deleted the Bug Id:"+id);
    }
    @PutMapping("/update/{id}")
    public Bug updateBug(@PathVariable long id,@RequestBody Bug bg){
        if(id<=0){
            throw new IllegalArgumentException("ID must be a positive number");
        }
        bg.setBugid(id);
        return bugService.updateBug(bg);
    }



    
    

    
    
    
}
