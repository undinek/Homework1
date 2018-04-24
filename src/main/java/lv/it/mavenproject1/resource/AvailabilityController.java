package lv.it.mavenproject1.resource;

import java.net.HttpURLConnection;
import java.net.URL;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lv.it.mavenproject1.domain.Response;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

//@Controller
//public class AvailabilityController {
//
//    HttpStatus status;
//
//    @GetMapping(value = "/h")
//    public Response getStatus() throws Exception {
//        URL url = new URL("");
//        HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
//        int statusCode = httpCon.getResponseCode();
//        String statusMessage = httpCon.getResponseMessage();
//        status = HttpStatus.valueOf(statusCode);
//        return new Response(statusMessage);
//    }
//    @RequestMapping("/f")
//    public String foo(@PathVariable String id, HttpServletRequest request) {
//        String urlTail = new AntPathMatcher()
//                .extractPathWithinPattern("/foo/fee", request.getRequestURI());
//        return urlTail;
//    }
//
//    @PostMapping(value = "/status")
//    public String setStatus(@PathVariable HttpStatus status) {
//        this.status = status;
//        if (status.value() != 200 && status.value() != 503) {
//            return "/hey";
//        } else {
//            return status.toString();
//        }
//    }
//}
@Controller
@RequestMapping("/status")
public class AvailabilityController {

    public static boolean available;

    @GetMapping
    @ResponseBody
    public void getStatus(HttpServletResponse httpServletResponse) {
        httpServletResponse.setStatus(available ? HttpServletResponse.SC_OK : HttpServletResponse.SC_SERVICE_UNAVAILABLE);
    }

    @PostMapping("/{value}")
    @ResponseBody
    public void setStatus(@PathVariable("value") boolean value) {
        available = value;
    }
}
