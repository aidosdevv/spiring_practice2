package kz.bitlab.practice2.practicespring2.services;

import kz.bitlab.practice2.practicespring2.models.Student;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class Database {

    @Getter
    private static List<Student> students = new ArrayList<>();

    static{
        students.add(new Student(1L,"Aidos","Akhmetov",86,"B"));
        students.add(new Student(2L,"Yernar","Aldabergenov",50,"D"));
        students.add(new Student(3L,"Alibek","Kerimbekov",47,"F"));
        students.add(new Student(4L,"Yelzhas","Sultanov",75,"B+"));
        students.add(new Student(5L,"Madiyar","Zhurek",100,"A+"));
    }

    public static void addStudent(String studentName,String studentSurname,int studentExam){
        String studentMark = "abc";
        if(studentExam>=90 && studentExam<=100){
            studentMark = "A";
        }else if(studentExam>=80 && studentExam<=89){
            studentMark = "B";
        }else if(studentExam>=70 && studentExam<=79){
            studentMark = "C";
        }else if(studentExam>=60 && studentExam<=69){
            studentMark = "D";
        }else if(studentExam>=50 && studentExam<=59){
            studentMark = "D";
        }else if(studentExam<50){
            studentMark = "F";
        }
        Student newStudent = Student
                                .builder()
                                .id(students.size()+1L)
                                .name(studentName)
                                .surname(studentSurname)
                                .exam(studentExam)
                                .mark(studentMark).
                                build();
        students.add(newStudent);
    }


}
