package resources;

import org.junit.Test;

import static org.junit.Assert.*;

public class StudentTest {

    @Test
    public void setStudentId() {
        Student testStudent = new Student();
        assertTrue(testStudent.setStudentId(11111));
        assertFalse(testStudent.setStudentId(1));
    }

    @Test
    public void setGender() {
        Student testStudent = new Student();
        assertTrue(testStudent.setGender('M'));
        assertTrue(testStudent.setGender('F'));
        assertFalse(testStudent.setGender('L'));
        assertFalse(testStudent.setStudentId('Q'));
    }

    @Test
    public void setFirstScore() {
        Student testStudent = new Student();
        assertTrue(testStudent.setFirstScore(100));
        assertTrue(testStudent.setFirstScore(0));
        assertFalse(testStudent.setFirstScore(-10));
        assertFalse(testStudent.setFirstScore(110));
    }

    @Test
    public void setSecondScore() {
        Student testStudent = new Student();
        assertTrue(testStudent.setFirstScore(100));
        assertTrue(testStudent.setFirstScore(0));
        assertFalse(testStudent.setFirstScore(-10));
        assertFalse(testStudent.setFirstScore(110));
    }
}