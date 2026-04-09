package com.codewithus.springassignment11;

import jakarta.validation.Valid;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@SpringBootApplication
public class SpringAssignment11Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringAssignment11Application.class, args);
    }

    @CrossOrigin(origins = "*")
    @RestController
    @RequestMapping("/api/courses")
    public static class CourseController {

        // Simulating a database with an in-memory list
        private final List<course> courseList = new ArrayList<>();

        public CourseController() {
            courseList.add(new course(1L, "CSC111F: Introduction to Computing", "Foundation"));
            courseList.add(new course(2L, "CSC121 F: Computer Literacy For Science2", "Foundation"));
            courseList.add(new course(3L, "CSC212: Data Structures", "Undergraduate"));
            courseList.add(new course(4L, "CSC211: Advanced Programming ", "Undergraduate"));
            courseList.add(new course(5L, "CSC121: Elementary Computer Programming ", "Undergraduate"));
            courseList.add(new course(6L, "CSC313: Object Oriented Programming", "Undergraduate"));
            courseList.add(new course(7L, "CSC411: Advanced Artificial Intelligence", "Honours"));
            courseList.add(new course(8L, "CSC513: Distributed And Parallel Computing", "Honours"));
            courseList.add(new course(9L, "CSC502: Research Methods ", "Honours"));
            courseList.add(new course(10L, "CSC501: Research Project ", "Honours"));
        }

        // ================= PART A =================
        // Grouped courses (Foundation, Undergraduate, Honours)

        @GetMapping("/department")
        public Map<String, List<course>> getDepartmentCourses() {
            // This automatically groups your active courses by their category!
            return courseList.stream()
                    .collect(Collectors.groupingBy(course::getCategory));
        }

        // ================= PART B =================
        // CRUD operations

        // READ ALL
        @GetMapping
        public List<course> getCourses() {
            return courseList;
        }

        // READ ONE (By ID)
        @GetMapping("/{id}")
        public course getCourse(@PathVariable Long id) {
            return courseList.stream()
                    .filter(c -> c.getId().equals(id))
                    .findFirst()
                    .orElse(null); // Returns nothing if the ID isn't found
        }

        // CREATE
        @PostMapping
        public String addCourse(@Valid @RequestBody course course) {
            courseList.add(course);
            return "Course added successfully";
        }

        // UPDATE
        @PutMapping("/{id}")
        public String updateCourse(@PathVariable Long id, @Valid @RequestBody course updatedCourse) {
            for (course c : courseList) {
                if (c.getId().equals(id)) {
                    c.setName(updatedCourse.getName());
                    c.setCategory(updatedCourse.getCategory());
                    return "Course updated successfully";
                }
            }
            return "Course not found.";
        }

        // DELETE
        @DeleteMapping("/{id}")
        public String deleteCourse(@PathVariable Long id) {
            boolean removed = courseList.removeIf(c -> c.getId().equals(id));
            return removed ? "Course deleted successfully" : "Course not found.";
        }
    }
}
