package resources;

import java.util.Comparator;

/**
 * Student class
 */
public class Student implements Comparable<Student>, Comparator<Student> {
    private int         studentId;
    private String      major;
    private Character   gender;
    private int         firstScore;
    private int         secondScore;
    private boolean     didRetake;

    /**
     * Constructor
     * @param id Student's ID
     * @param major Student's major
     * @param gender Student's gender
     * @param firstScore Student's first exam score
     * @param secondScore Student's second exam score
     */
    public Student(int id, String major, Character gender, int firstScore, int secondScore){
        this.studentId = id;
        this.major = major;
        this.gender = gender;
        this.firstScore = firstScore;
        this.secondScore = secondScore;
        this.didRetake = true;
    }

    /**
     * Constructor
     */
    public Student(){}

    /**
     * Student ID setter
     * @param studentId ID of student
     * @return true/false if valid parameter
     */
    public boolean setStudentId(int studentId) {
        boolean status = false;
        if(studentId >= 10000 && studentId <= 99999) {
            this.studentId = studentId;
            status = true;
        }
        else
            System.err.println("Student ID must be 5 digits long");
        return status;
    }

    /**
     * Major setter
     * @param major Student major
     */
    public void setMajor(String major) {
        this.major = major;
    }

    /**
     * Gender setter
     * @param gender Student gender
     * @return true/false if valid parameter
     */
    public boolean setGender(Character gender) {
        gender = Character.toUpperCase(gender);
        boolean status = false;
        if(gender == 'M' || gender == 'F') {
            this.gender = gender;
            status = true;
        }
        else
            System.err.println("Only M or F genders allowed");
        return status;
    }

    /**
     * First exam score setter
     * @param firstScore Student first exam score
     * @return true/false if valid parameter
     */
    public boolean setFirstScore(int firstScore) {
        boolean status = false;
        if(firstScore >= 0 && firstScore <= 100) {
            this.firstScore = firstScore;
            status = true;
        }
        else
            System.err.println("Test Score must be within valid range (0 - 100)");
        return status;
    }

    /**
     * Second exam score setter
     * @param secondScore Student second exam score
     * @return true/false if valid parameter
     */
    public boolean setSecondScore(int secondScore) {
        boolean status = false;
        if(secondScore >= 0 && secondScore <= 100) {
            status = true;
            this.didRetake = true;
            this.secondScore = secondScore;
        }
        else
            System.err.println("Test Score must be within valid range (0 - 100)");
        return status;
    }

    /**
     * Student ID getter
     * @return studentId
     */
    public int getStudentId() {
        return studentId;
    }

    /**
     * Major getter
     * @return major
     */
    public String getMajor() {
        return major;
    }

    /**
     * Gender getter
     * @return gender
     */
    public Character getGender() {
        return gender;
    }

    /**
     * First exam score getter
     * @return first exam score
     */
    public int getFirstScore() {
        return firstScore;
    }

    /**
     * Second exam score getter
     * @return second exam score
     */
    public int getSecondScore() {
        return secondScore;
    }

    public boolean getDidRetake() {
        return didRetake;
    }

    /**
     * Class comparator based on Student ID
     * @param o other Student
     * @return comparison value of students based on student ID
     */
    @Override
    public int compareTo(Student o) {
        return ((Integer) this.studentId).compareTo(o.studentId);
    }

    @Override
    public int compare(Student o1, Student o2) {
        return o1.getStudentId() - o2.getStudentId();
    }
}
