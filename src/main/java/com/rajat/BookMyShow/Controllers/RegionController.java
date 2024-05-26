package com.rajat.BookMyShow.Controllers;

import com.rajat.BookMyShow.Models.Region;
import com.rajat.BookMyShow.Services.RegionService;
import com.rajat.BookMyShow.dto.AddRegionDTO;
import com.rajat.BookMyShow.dto.GetRegionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController("/region")
public class RegionController {
    @Autowired
    private RegionService regionService;

    @PostMapping("/add")
    public ResponseEntity addRegion(@RequestBody AddRegionDTO addRegionDTO){
        return ResponseEntity.ok(regionService.AddRegion(addRegionDTO.getName()));
    }
    @GetMapping
    public ResponseEntity getRegion(@PathVariable long regionId){
        Region region = regionService.GetRegionById(regionId);
        GetRegionDTO getRegionDTO = new GetRegionDTO(region.getName(), region.getTheaters());
        return ResponseEntity.ok(getRegionDTO);
    }
    @GetMapping("/all")
    public ResponseEntity getAllRegions(){
        return ResponseEntity.ok(regionService.GetAllRegions());
    }
}
