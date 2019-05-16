package com.sanchez.topbloctest;

import resources.Classroom;
import resources.ExcelUtilities;
import resources.HttpRequest;
import resources.Student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

/**
 * Controls flow of program
 */
public class Driver {
    /**
     * Call instances of classes necessary to create classroom and control flow of program
     */
    public static void run(){
        ExcelUtilities excelReader = new ExcelUtilities();
        ArrayList<LinkedList<String>> studentInfoTable = excelReader.readExcelFile("src/main/assets/Student Info.xlsx");
        ArrayList<LinkedList<String>> testScoresTable = excelReader.readExcelFile("src/main/assets/Test Scores.xlsx");
        ArrayList<LinkedList<String>> retakeScoresTable = excelReader.readExcelFile("src/main/assets/Test Retake Scores.xlsx");

        Classroom classroomUtilities = new Classroom();

        ArrayList<Student> classroom = classroomUtilities.createStudentList(studentInfoTable);
        Collections.sort(classroom);
        classroomUtilities.populateStudentScores(classroom, testScoresTable, false);
        classroomUtilities.populateStudentScores(classroom, retakeScoresTable, true);


        int avg = classroomUtilities.averageTestScore(classroom);

        ArrayList<String> femaleCSIDs = classroomUtilities.getFemaleCSStudents(classroom);

        HttpRequest httpUtility = new HttpRequest();
        httpUtility.sendPost("http://3.86.140.38:5000/challenge", "oliver.d.sanchez@wmich.edu",
                "Oliver Sanchez", avg, femaleCSIDs);

    }
}
