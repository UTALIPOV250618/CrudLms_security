package peaksoft.crudlms_security.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import peaksoft.crudlms_security.model.Teacher;
import peaksoft.crudlms_security.service.TeacherService;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/teacher")
public class TeacherController {

    private final TeacherService service;


    @RequestMapping("/")
    public String getAllTeachers(Model model){
        List<Teacher> teacherList = service.getAllTeachers();
        model.addAttribute("teacherList",teacherList);
        return "teacher/teacher_page";
    }
    @RequestMapping("/new_teacher")
    public String addNewTeacher(Model model){
        Teacher teacher = new Teacher();
        model.addAttribute("teacher",teacher);
        return "teacher/new_teacher";
    }
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public String saveStudent(@ModelAttribute("teacher")Teacher teacher){
        service.saveTeacher(teacher);
        return "redirect:/teacher/";
    }
    @RequestMapping("/edit/{id}")
    public ModelAndView editTeacher(@PathVariable("id")long id){
        ModelAndView view = new ModelAndView("teacher/edit_teacher");
        Teacher teacher = service.getTeacherById(id);
        view.addObject("teacher",teacher);
        return view;
    }
    @RequestMapping("/delete/{id}")
    public String deleteTeacher(@PathVariable("id")long id){
        service.deleteTeacher(id);
        return "redirect:/teacher/";
    }
}
