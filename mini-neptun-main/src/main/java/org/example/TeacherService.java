package org.example;

import java.util.List;

public interface TeacherService {
    List<StudentDto> getMyStudents();

    boolean shouldBeTired();
}
