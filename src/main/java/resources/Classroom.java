package resources;

import java.util.*;

/**
 * Utility class to build a list of students representing a classroom
 */
public class Classroom{
    /**
     * Creates student objects from ArrayList of linked lists of strings
     * @param infoTable input table
     * @return ArrayList of students representing a classroom
     */
    public ArrayList<Student> createStudentList(ArrayList<LinkedList<String>> infoTable){
        ArrayList<Student> classroom = new ArrayList<>();
        for(int i = 1; i < infoTable.size(); i++){
            Student pupil = new Student();
            LinkedList<String> columns;
            columns = infoTable.get(i);
            pupil.setStudentId((int)(Double.parseDouble(columns.get(0))));
            pupil.setMajor(columns.get(1));
            pupil.setGender(columns.get(2).charAt(0));
            classroom.add(pupil);
        }
        return classroom;
    }

    /**
     * Fills in test scores for an ArrayList of students. Using binary search to find proper entries
     * based on Students ID
     * @param classroom ArrayList of students not containing test scores
     * @param scores ArrayList of Linked List of Scores
     * @param retake Condition on whether the input scores are retakes or not
     */
    public void populateStudentScores(ArrayList<Student> classroom, ArrayList<LinkedList<String>> scores, boolean retake){
        for (int i = 1; i < scores.size(); i++){
            int scoreID = (int)Double.parseDouble(scores.get(i).get(0));
            int score = (int)Double.parseDouble(scores.get(i).get(1));
            Student insertion = new Student();
            insertion.setStudentId(scoreID);
            if(retake)
                insertion.setSecondScore(score);
            else
                insertion.setFirstScore(score);

            int studentIndex = Collections.binarySearch(classroom, insertion);
            if(studentIndex >= 0) {
                if(retake)
                    classroom.get(studentIndex).setSecondScore(score);
                else
                    classroom.get(studentIndex).setFirstScore(score);
            }
        }
    }

    /**
     * Computes the average test scores for all students
     * @param classroom ArrayList of all students
     * @return average exam scored rounded to the closest int
     */
    public int averageTestScore(ArrayList<Student> classroom){
        int aggregate = 0;
        for (Student pupil: classroom) {
            if(pupil.getDidRetake()){
                if(pupil.getFirstScore() >= pupil.getSecondScore()){
                    aggregate += pupil.getFirstScore();
                }
                else
                    aggregate += pupil.getSecondScore();
            }
            else
                aggregate += pupil.getFirstScore();
        }
        return aggregate/classroom.size();
    }

    /**
     * reads and ArrayList of students and finds all female CS students
     * @param classroom an ArrayList of Students
     * @return an ArrayList of female CS students IDs as string
     */
    public ArrayList<String> getFemaleCSStudents(ArrayList<Student> classroom){
        ArrayList<String> femaleCS = new ArrayList<>();
        for(Student pupil: classroom) {
            if((pupil.getGender() == 'F') && (pupil.getMajor().equalsIgnoreCase("computer science"))){
                femaleCS.add(Integer.toString(pupil.getStudentId()));
            }
        }
        return femaleCS;
    }
}


