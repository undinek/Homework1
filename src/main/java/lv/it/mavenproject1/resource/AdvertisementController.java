package lv.it.mavenproject1.resource;

import lv.it.mavenproject1.domain.Response;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AdvertisementController {
    
    @GetMapping(value = "/")
    @ResponseBody
    public String testEndpoint(){
        return "Hello!";
    }
    
    @GetMapping(value = "/hey")
    @ResponseBody
    public Response nextTestEndpoint(){
        return new Response("Hey Ya");
    }
    
}
//Object Oriented Design Patterns - Gand of Four(Java version)
