package vttp.iss.day18lecture.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import vttp.iss.day18lecture.model.Announcement;

@Service
public class AnnouncementService {

    List<Announcement> list = new ArrayList<>();

    public void saveAnnouncement(Announcement announcement) {

        list.add(announcement);
        System.out.println(list.size());
    }

    public List<Announcement> getAnnouncement() {
        return list;
    }


    
}
