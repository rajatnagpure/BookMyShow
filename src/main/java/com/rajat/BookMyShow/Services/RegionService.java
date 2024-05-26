package com.rajat.BookMyShow.Services;

import com.rajat.BookMyShow.Models.Region;
import com.rajat.BookMyShow.Repositories.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegionService {
    @Autowired
    private RegionRepository regionRepository;
    public long AddRegion(String name){
        Region region = new Region(name);
        regionRepository.save(region);
        return  region.getId();
    }
    public Region GetRegionById(long Id){
        return regionRepository.findById(Id).get();
    }
    public List<Region> GetAllRegions(){
        return regionRepository.findAll();
    }
}
