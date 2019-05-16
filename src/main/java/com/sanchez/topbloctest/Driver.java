package com.sanchez.topbloctest;

import resources.Classroom;
import resources.ExcelUtilities;
import resources.Student;

import java.util.ArrayList;
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

        Classroom classroom = new Classroom();

        ArrayList<Student> classroomBuilder = classroom.createStudentList(studentInfoTable);
        classroom.populateStudentScores(classroomBuilder, testScoresTable, false);
        classroom.populateStudentScores(classroomBuilder, retakeScoresTable, true);

        for(int i = 0; i < classroomBuilder.size(); i++){
            System.out.print(classroomBuilder.get(i).getStudentId() + " " + classroomBuilder.get(i).getFirstScore() + " " +
                    classroomBuilder.get(i).getGender() + " " + classroomBuilder.get(i).getMajor() + " ");
            if(classroomBuilder.get(i).getDidRetake() == true){
                System.out.print(classroomBuilder.get(i).getSecondScore());
            }
            System.out.println();
        }

    }
}
