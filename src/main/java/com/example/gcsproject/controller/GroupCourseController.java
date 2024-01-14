package com.example.gcsproject.controller;

import com.example.gcsproject.model.GroupCourse;
import com.example.gcsproject.repository.GroupCourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/groups")
public class GroupCourseController {

    private final GroupCourseRepository groupCourseRepository;

    @Autowired
    public GroupCourseController(GroupCourseRepository groupCourseRepository) {
        this.groupCourseRepository = groupCourseRepository;
    }

    @GetMapping
    public List<GroupCourse> getAllGroupCourses() {
        return groupCourseRepository.findAll();
    }

    @GetMapping("/{id}")
    public GroupCourse getGroupCourseById(@PathVariable Long id) {
        return groupCourseRepository.findById(id).orElse(null);
    }

    @PostMapping
    public GroupCourse createGroupCourse(@RequestBody GroupCourse groupCourse) {
        return groupCourseRepository.save(groupCourse);
    }

    @PutMapping("/{id}")
    public GroupCourse updateGroupCourse(@PathVariable Long id, @RequestBody GroupCourse updatedGroupCourse) {
        if (groupCourseRepository.existsById(id)) {
            updatedGroupCourse.setId(id);
            return groupCourseRepository.save(updatedGroupCourse);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteGroupCourse(@PathVariable Long id) {
        groupCourseRepository.deleteById(id);
    }


}