package lv.it.mavenproject1.resource;

import java.util.Map;
import lv.it.mavenproject1.dao.AdvertisementRepository;
import lv.it.mavenproject1.dao.UserRepository;
import lv.it.mavenproject1.domain.Advertisement;
import lv.it.mavenproject1.domain.Response;
import lv.it.mavenproject1.domain.User;
import lv.it.mavenproject1.service.AdvertisementService;
import lv.it.mavenproject1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AdvertisementController {

    @Autowired
    private UserService userService;

    @Autowired
    private AdvertisementService advertisementService;

    @Autowired
    private AdvertisementRepository advertisementRepository;

    @Autowired
    private UserRepository userRepository;

    public void addToDb() {
        for (Advertisement advertisement : advertisementService.hardcodedAdvertisementList) {
            advertisementRepository.save(advertisement);
        }
        
        for (User user : userService.userList) {
            userRepository.save(user);
        }
    }

    @GetMapping(value = "/")
    @ResponseBody
    public String testEndpoint() {
        return "Hello!";
    }

    @GetMapping(value = "/hey")
    @ResponseBody
    public Response nextTestEndpoint() {
        return new Response("Hey Ya");
    }

    @GetMapping("/main") //galvenaa lapa
    public String getUI(Map<String, Object> model) {
        model.put("message", "Hello User!");
        addToDb();
        return "main";
    }

    @RequestMapping("/reverse")//atgriezh reverse ads
    public String reverseList(Map<String, Object> model) {
        model.put("ads", advertisementService.getAdvertisementListReverse());
        return "reverse";
    }

    @GetMapping("/create")//izveido ad
    public String advertisementCreationForm(Model model) {
        model.addAttribute("advertisement", new Advertisement());
        return "create";
    }

    @PostMapping("/add")//pievieno ad listam un db
    public String addAdvertisement(@ModelAttribute("advertisement") Advertisement advertisement, Map<String, Object> model) {
        advertisementService.hardcodedAdvertisementList.add(0, advertisement);
        model.put("advetisement", advertisement);
        advertisementRepository.save(advertisement);
        return "result";
    }

    @GetMapping("/author/{name}") //atrod advertisements for Author and User data
    public String getAuthorAdvertisements(Map<String, Object> model,
            @PathVariable String name) {
        model.put("advertisementList",
                advertisementRepository.findByAuthor(name));
        model.put("userList", userRepository.findByName(name));
        return "author";
    }

    @GetMapping("/adduser")//izveido User  //izveidot html
    public String userCreationFormdb(Model model) {
        model.addAttribute("user", new User());
        return "adduser";
    }

    @PostMapping("/userdb")//pievieno user datubaazei
    public String userSubmit(Map<String, Object> model,
            @ModelAttribute User user) {
        userRepository.save(user);
        model.put("user", user);
        return "userresult";
    }

    @GetMapping("/userdb/{name}")//find user by name in db //izveidot html
    public String getUserdb(Map<String, Object> model,
            @PathVariable String name) {
        model.put("userList", userRepository.findByName(name));
        return "userui";
    }

}
