package noetic.example.codetest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by DS hewapathirana.
 * Date: 9/22/2019
 * Time: 11:02 AM
 */
@RestController
@RequestMapping("/welcome")
public class WelcomeController {

    @GetMapping
    public  String welcome() {

        return "Employee Service started new";
    }
}
