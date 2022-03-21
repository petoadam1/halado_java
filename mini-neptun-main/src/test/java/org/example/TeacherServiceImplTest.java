package org.example;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.*;

public class TeacherServiceImplTest {

    @Test
    public void getMyStudents() {
        // GIVEN
        Long teacherId = 234L;

        CourseRepository courseRepository = mock(CourseRepository.class);
        List<CourseDto> findByTeacherResult = new ArrayList<>();
        findByTeacherResult.add(new CourseDto(1L, "demo course", new ArrayList()));
        when(courseRepository.findByTeacher(teacherId)).thenReturn(findByTeacherResult);

        StudentRepository studentRepository = mock(StudentRepository.class);
        List<StudentDto> findByCourseIdResult = new ArrayList();
        findByCourseIdResult.add( new StudentDto(1L, "name 1", "nc 1"));
        findByCourseIdResult.add( new StudentDto(2L, "name 2", "nc 2"));
        findByCourseIdResult.add( new StudentDto(3L, "name 3", "nc 3"));
        when(studentRepository.findByCourseId(anyList())).thenReturn(findByCourseIdResult);

        TeacherServiceImpl teacher = new TeacherServiceImpl(studentRepository, courseRepository, teacherId);

        // WHEN
        List<StudentDto> myStudents = teacher.getMyStudents();

        // THEN
        assertEquals(myStudents.size(), 3);

        verify(courseRepository, times(1)).findByTeacher(eq(teacherId));
        verify(studentRepository, times(1)).findByCourseId(anyList());
    }

    @Test
    public void shouldBeTired() {
        // GIVEN
        Long teacherId = 234L;
        CourseRepository courseRepository = mock(CourseRepository.class);
        when(courseRepository.getElementCount(teacherId)).thenReturn(125);
        StudentRepository studentRepository = mock(StudentRepository.class);
        TeacherServiceImpl teacher = new TeacherServiceImpl(studentRepository, courseRepository, teacherId);

        // WHEN THEN
        assertTrue(teacher.shouldBeTired());
    }

    @Test
    public void shouldBeTired_No() {
        // GIVEN
        Long teacherId = 234L;
        CourseRepository courseRepository = mock(CourseRepository.class);
        when(courseRepository.getElementCount(teacherId)).thenReturn(1);
        TeacherServiceImpl teacher = new TeacherServiceImpl(null, courseRepository, teacherId);

        // WHEN THEN
        assertFalse(teacher.shouldBeTired());
    }
}