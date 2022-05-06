package peaksoft.crudlms_security.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import peaksoft.crudlms_security.model.Student;
import peaksoft.crudlms_security.service.StudentService;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/student")
public class StudentController {

    private final StudentService service;

    @RequestMapping("/")
    public String getAllStudents(Model model){
        List<Student> studentList = service.getAllStudents();
        model.addAttribute("studentList",studentList);
        return "student/student_page";
    }
    @RequestMapping("/new_student")
    public String addNewStudent(Model model){
        Student student = new Student();
        model.addAttribute("student",student);
        return "student/new_student";
    }
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public String saveStudent(@ModelAttribute("student")Student student){
        service.saveStudent(student);
        return "redirect:/student/";
    }
    @RequestMapping("/edit/{id}")
    public ModelAndView editStudent(@PathVariable("id")long id){
        ModelAndView view = new ModelAndView("student/edit_student");
        Student student = service.getStudentById(id);
        view.addObject("student",student);
        return view;
    }
    @RequestMapping("/delete/{id}")
    public String deleteStudent(@PathVariable("id")long id){
        service.deleteStudent(id);
        return "redirect:/student/";
    }

}
