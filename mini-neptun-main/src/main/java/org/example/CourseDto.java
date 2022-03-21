package org.example;

import java.util.List;

public class CourseDto {
    private Long id;
    private String name;
    private List<StudentDto> studentList;

    public CourseDto() {
    }

    public CourseDto(Long id, String name, List<StudentDto> studentList) {
        this.id = id;
        this.name = name;
        this.studentList = studentList;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<StudentDto> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<StudentDto> studentList) {
        this.studentList = studentList;
    }
}
