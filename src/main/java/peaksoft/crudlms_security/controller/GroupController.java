package peaksoft.crudlms_security.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import peaksoft.crudlms_security.model.Group;
import peaksoft.crudlms_security.service.GroupService;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/group")
public class GroupController {

    private final GroupService service;

    @RequestMapping("/")
    public String getAllGroup(Model model){
        List<Group> groupList = service.getAllGroups();
        model.addAttribute("groupList",groupList);
        return "group/group_page";
    }

    @RequestMapping("/new_group")
    public String addGroup(Model model){
        Group group = new Group();
        model.addAttribute("group",group);
        return "group/new_group";
    }

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public String saveGroupObject(@ModelAttribute("group")Group group){
        service.saveGroup(group);
        return "redirect:/group/";
    }
    @RequestMapping("/edit/{id}")
    public ModelAndView editGroupObject(@PathVariable("id")long id){
        ModelAndView view =new ModelAndView("group/edit_group");
        Group group = service.getGroupById(id);
        view.addObject("group",group);
        return view;
    }
    @RequestMapping("/delete/{id}")
    public String deleteGroup(@PathVariable("id")long id){
        service.deleteGroup(id);
        return "redirect:/group/";
    }
}
