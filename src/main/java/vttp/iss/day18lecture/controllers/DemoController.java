package vttp.iss.day18lecture.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

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

    @GetMapping(path = "/hellotest")
    @ResponseBody // Must have responsebody here to work
    public String hellotest() {
        try {
            return "Hello, Springboot is okay";
        } catch (Exception ex) {
            return "Error running Springboot";
        }
    }

    @GetMapping(path = "/healthz")
    public ModelAndView getHealthz() {

        ModelAndView mav = new ModelAndView();

        try {
            mav.setStatus(HttpStatusCode.valueOf(200));
            mav.setViewName("healthy");
        } catch (Exception ex) {
            mav.setStatus(HttpStatusCode.valueOf(500));
            mav.setViewName("unhealthy");
        }

        return mav;
    }
}
