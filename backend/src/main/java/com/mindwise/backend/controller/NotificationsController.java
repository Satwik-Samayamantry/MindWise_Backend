package com.mindwise.backend.controller;

import com.mindwise.backend.model.Notifications;
import com.mindwise.backend.repository.NotificationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class NotificationsController {
    @Autowired
    private NotificationsRepository notificationsRepository;

    @PostMapping("/notification")
    Notifications newNotification(@RequestBody Notifications newNotification)
    {
        return notificationsRepository.save(newNotification);
    }

    @GetMapping("/notifications")
    List<Notifications> getAllNotifications()
    {
        return notificationsRepository.findAll();
    }

    @GetMapping("/getnotificationsbydocid")
    List<Notifications> getallnotificationsbydocid(@RequestParam("docID") Long docID)
    {
        List<Notifications> nlist = null;

        try
        {
            List<Notifications> NList = notificationsRepository.getAllByDoctorID(docID);
            return NList;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return nlist;
    }


    @GetMapping("/getnotificationsbypatientid")
    List<Notifications> getallnotificationsbypatientid(@RequestParam("patientID") Long patientID)
    {
        List<Notifications> nlist1 = null;

        try
        {
            List<Notifications> NList1 = notificationsRepository.getAllByPatientID(patientID);
            return NList1;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return nlist1;
    }

    @GetMapping("/getnotificationsbypatientidanddocid")
    List<Notifications> getallnotificationsbypatientidanddocid(@RequestParam("patientID") Long patientID, @RequestParam("doctorID") Long doctorID)
    {
        List<Notifications> nlist1 = null;

        try
        {
            List<Notifications> NList1 = notificationsRepository.getAllByPatientIDAndDoctorID(patientID, doctorID);
            return NList1;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return nlist1;
    }


}
