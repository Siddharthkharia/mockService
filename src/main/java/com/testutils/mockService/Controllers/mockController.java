package com.testutils.mockService.Controllers;

import com.testutils.mockService.Entity.customResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mock")
public class mockController {

    @Autowired
    private customResponse customResponse;

    @GetMapping("/success/{status}")
    public String getSuccess(@PathVariable String status){
        return customResponse.getResponseFile(status);
    }
}
