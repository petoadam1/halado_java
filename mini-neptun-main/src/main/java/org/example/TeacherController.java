package org.example;

import java.util.List;

public interface TeacherController {
    List<CourseDto> getAllCourseWithStudents(Long teacherId);
}
