package peaksoft.crudlms_security.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import peaksoft.crudlms_security.model.Course;
import peaksoft.crudlms_security.service.CourseService;

import javax.lang.model.element.ModuleElement;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/course")
public class CourseController {

    private final CourseService service;

    @RequestMapping("/")
    public String getAllCourse(Model model){
        List<Course> courseList = service.getAllCourse();
        model.addAttribute("courseList",courseList);
        return "/course/course_page";
    }

    @RequestMapping("/new_course")
    public String addNewCourse(Model model){
        Course course = new Course();
        model.addAttribute("course",course);
        return "/course/new_course";
    }
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public String saveCourse(@ModelAttribute("course")Course course){
        service.save(course);
        return "redirect:/course/";
    }
    @RequestMapping("/edit/{id}")
    public ModelAndView editCourse(@PathVariable("id")long id){
        ModelAndView view = new ModelAndView("course/edit_course");
        Course course = service.getById(id);
        view.addObject("course",course);
        return view;
    }
    @RequestMapping("/delete/{id}")
    public String deleteCourse(@PathVariable("id")long id){
        service.deleteById(id);
        return "redirect:/course/";
    }
}
