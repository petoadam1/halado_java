package org.example;

import java.util.List;

public interface StudentRepository {
    List<StudentDto> findByCourseId(List<Long> courseIdList);
}
