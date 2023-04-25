package com.mindwise.backend.controller;

import com.mindwise.backend.model.DPMap;
import com.mindwise.backend.repository.DPMapRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class DPMapController {
    @Autowired
    private DPMapRepository dpmapRepository;

    @PostMapping("/assign-doctor")
    DPMap newDPMap(@RequestBody DPMap newDPMap)
    {
        Long pId = newDPMap.getPatientID();
        Long dId = newDPMap.getDoctorID();
        DPMap dpmap = dpmapRepository.getAllByPatientID(pId);
        if(dpmap!=null)
        {
            dpmap.setDoctorID(dId);
            return dpmapRepository.save(dpmap);
        }
        return  dpmapRepository.save(newDPMap);
    }

    @GetMapping("/get-maps")
    List<DPMap> getAllDPMaps()
    {
        // return "Hello World";
        return dpmapRepository.findAll();
    }

    @GetMapping("/getpatientsbydocid")
        // List<DoctorPatient> getAllPatientsbyDocID(@RequestParam("docID") Long docID)
    List<Long> getAllPatientsbyDocID(@RequestParam("docID") Long docID)
    {
//        List<DoctorPatient> plist= null;
        List<Long> plist= null;


        try
        {
            // List<DoctorPatient> PList = doctorpatientRepository.getPatientsbyDoctorID(docID);
            List<Long> PList = dpmapRepository.getPatientsbyDoctorID(docID);
            return PList;
        }


        catch (Exception e)
        {
            e.printStackTrace();
        }


        return plist;
    }


    @GetMapping("/getsummary")
    DPMap getSummaryfromPID(@RequestParam("patientID") Long patientID)
    {
        DPMap obj = null;


        try
        {
            DPMap info = dpmapRepository.getAllByPatientID((patientID));
            return info;
        }


        catch (Exception e)
        {
            e.printStackTrace();
        }


        return obj;
    }

    @GetMapping("/getdocidbypid")
    Long getdocidbypatid(@RequestParam("pid") Long patientID)
    {
        DPMap temp = dpmapRepository.getAllByPatientID(patientID);

        return temp.getDoctorID();
    }

}
