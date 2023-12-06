package vttp.iss.day18lecture.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;
import vttp.iss.day18lecture.model.Announcement;
import vttp.iss.day18lecture.services.AnnouncementService;

@Controller
@RequestMapping(path = "/announcements")
public class AnnouncementController {

    @Autowired
    AnnouncementService announcementSvc;

    @GetMapping(path = "/create")
    public String announcementCreationForm(Model model) {

        Announcement announcement = new Announcement();

        model.addAttribute("announcement", announcement);

        return "announcementcreate";
    }

    @PostMapping(path = "/processannouncement")
    public String postAnnouncement(@Valid @ModelAttribute ("announcement") Announcement announcement, BindingResult result) {

        if (result.hasErrors()) {
            return "announcementcreate";
        }

        announcementSvc.saveAnnouncement(announcement);

        return "success";
    }

    @GetMapping(path = "/list")
    public String getAnnouncements(Model model) {

        List<Announcement> list = announcementSvc.getAnnouncement();

        System.out.println(list.size());

        model.addAttribute("list", list);

        return "list";
    }
    
}
