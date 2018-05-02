package lv.it.mavenproject1.resource;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import lv.it.mavenproject1.domain.Advertisement;
import lv.it.mavenproject1.domain.Response;
import lv.it.mavenproject1.service.AdvertisementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AdvertisementController {

    ArrayList<Advertisement> myAds;
    @Autowired
    private AdvertisementService advertisementService;

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

    @GetMapping("/main")
    public String getUI(Map<String, Object> model) {
        ArrayList<Advertisement> ads = myAds;
        model.put("message", "Hello User!");
        model.put("ads", ads);
        return "main";
    }

    @GetMapping("/list")
    public String makeList(Map<String, Object> model) {
        myAds = new ArrayList<>();
        if (myAds.isEmpty()) {
            myAds = advertisementService.newAdvertisements();
        }
        ArrayList<Advertisement> ads = myAds;
        model.put("message", "Advertisements are added");
        model.put("ads", ads);
        return "list";
    }

    @PostMapping("/main")
    public String getAuthorAdvertisement(@ModelAttribute("advertisement") Advertisement advertisement,
            Map<String, Object> model) {
        ArrayList<Advertisement> ads = author(advertisement.getAuthor());

        if (ads.size() > 0) {
            model.put("ads", ads);
            return "author";
        } else {
            return "main";
        }
    }

    @RequestMapping("/reverse")
    public String reverseList(Map<String, Object> model) {
        ArrayList<Advertisement> ads = (ArrayList<Advertisement>) reverse();
        model.put("ads", ads);
        return "reverse";
    }

    public List<Advertisement> reverse() {
        //atgriež datus sakārtotus pretēji numerācijai
        ArrayList<Advertisement> ads;
        ads = myAds;
        List<Advertisement> reverseAdvertisements;
        List<Advertisement> adsClone = new ArrayList<>(ads.subList(0, ads.size()));
        Collections.reverse(adsClone);
        reverseAdvertisements = (ArrayList) adsClone;

        return reverseAdvertisements;
    }

    public ArrayList<Advertisement> author(String name) {
        //atgriež šī autora sludinājumus
        ArrayList<Advertisement> ads;
        ads = myAds;
        ArrayList<Advertisement> advertisements = new ArrayList<>();
        int i = 0;
        while (i < ads.size()) {
            Advertisement ad = ads.get(i);
            if (ad.getAuthor().equals(name)) {
                advertisements.add(ad);
            }
            i++;
        }
        return advertisements;
    }

    @GetMapping("/add")
    public String AdvertisementForm(Model model) {
        //   model.addAttribute("add", new Advertisement());
        return "add";
    }

    @PostMapping("/add")
    public String addAdvertisement(@ModelAttribute("advertisement") Advertisement advertisement,
            Map<String, Object> model) {
        Advertisement ad = advertisement;
        myAds.add(ad);
        model.put("ad", ad);
        return "result";
    }
}
//Object Oriented Design Patterns - Gand of Four(Java version)
