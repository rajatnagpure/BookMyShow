package com.rajat.BookMyShow.Controllers;

import com.rajat.BookMyShow.Services.ShowService;
import com.rajat.BookMyShow.dto.CreateShowDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController("/show")
public class ShowController {
    @Autowired
    private ShowService showService;

    @PostMapping("/create")
    public ResponseEntity createShow(@RequestBody CreateShowDTO createShowDTO) throws Exception{
        return ResponseEntity.ok(showService.CreateShow(createShowDTO.getScreenId(), createShowDTO.getDate(), createShowDTO.getMovieId(), createShowDTO.getFeatures()));
    }
}
