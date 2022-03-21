package org.example;

import java.util.List;

public interface CourseRepository {
    List<CourseDto> findByTeacher(Long teacherId);
    int getElementCount(Long teacherId);
}
