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
        return  dpmapRepository.save(newDPMap);
    }

    @GetMapping("/get-maps")
    List<DPMap> getAllDPMaps()
    {
        // return "Hello World";
        return dpmapRepository.findAll();
    }


}
