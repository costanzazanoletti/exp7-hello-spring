package com.experis.course.hellospring.controller;

import com.experis.course.hellospring.model.Student;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/students")
public class StudentController {

  @GetMapping
  public String studentList(Model model,
      @RequestParam(name = "name", required = false) String nameParam) {
    List<Student> filteredStudents =
        nameParam != null ? getFilteredStudents(nameParam) : getStudents();
    model.addAttribute("studentList", filteredStudents);
    return "student-list";
  }

  @GetMapping("/{code}") // students/123
  public String studentDetail(@PathVariable("code") String studentCode, Model model) {
    Student student = getStudentByCode(studentCode);
    model.addAttribute("student", student);
    return "student-detail";
  }


  // METODI PRIVATE
  private List<Student> getStudents() {
    Student[] studentsArray = {new Student("123", "Max"), new Student("456", "Will"),
        new Student("789", "Dustin")};
    return Arrays.asList(studentsArray);
  }

  private List<Student> getFilteredStudents(String search) {
    return getStudents().stream().filter(student -> student.getName().contains(search))
        .collect(Collectors.toList());

  }

  private Student getStudentByCode(String code) {

    for (Student student : getStudents()) {
      if (student.getCode().equals(code)) {
        return student;
      }
    }
    return null;
  }
}
