package kz.bitlab.practice2.practicespring2.controllers;

import kz.bitlab.practice2.practicespring2.services.Database;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    @GetMapping(value = "/home")
    public String homePage() {
        return "home";
    }

    @GetMapping(value = "/showStudents")
    public String carsPage(Model model){
        model.addAttribute("stu", Database.getStudents());
        return "showStudents";
    }

    @GetMapping(value="/add-student")
    public String pageAdd(){
        return "add-student";
    }

    @PostMapping(value="/addstudent")
    public String addStudent(@RequestParam(name = "student_name") String studentName,
                             @RequestParam(name = "student_surname") String studentSurname,
                             @RequestParam(name = "student_exam") int studentExam){
        System.out.println(studentName + " " + studentSurname + " " + studentExam+">>>>>>>>>>>>>>>");
        Database.addStudent(studentName,studentSurname,studentExam);

        return "redirect:/add-student";
    }


}
