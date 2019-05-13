package resources;

public class Student {
    private int         studentId;
    private String      major;
    private Character   gender;
    private int         firstScore;
    private int         secondScore;
    private boolean     didRetake;

    public Student(int id, String major, Character gender, int firstScore, int secondScore){
        this.studentId = id;
        this.major = major;
        this.gender = gender;
        this.firstScore = firstScore;
        this.secondScore = secondScore;
        this.didRetake = true;
    }

    public Student(){}

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

    public void setMajor(String major) {
        this.major = major;
    }

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

    public int getStudentId() {
        return studentId;
    }

    public String getMajor() {
        return major;
    }

    public Character getGender() {
        return gender;
    }

    public int getFirstScore() {
        return firstScore;
    }

    public int getSecondScore() {
        return secondScore;
    }
}
