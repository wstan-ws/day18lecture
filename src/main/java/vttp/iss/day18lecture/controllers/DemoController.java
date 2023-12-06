package vttp.iss.day18lecture.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/demo")
public class DemoController {
    
    @GetMapping(path = "/hello")
    public ResponseEntity<?> hello() {
        try {
            return new ResponseEntity<>("Hello, Springboot is okay", HttpStatusCode.valueOf(200));
        } catch (Exception ex) {
            return new ResponseEntity<>("Error running Springboot", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
