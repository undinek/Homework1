/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lv.it.mavenproject1.service;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import lv.it.mavenproject1.domain.Advertisement;
import org.springframework.stereotype.Service;

/**
 *
 * @author Undine
 */
@Service
public class AdvertisementService {

    String title, author, message;
ArrayList<Advertisement> advertisements;
    public AdvertisementService() {
        advertisements  = new ArrayList<>();
    }


    String[][] ad = {
        {"Pardod maju ", "Janis", "Pardou maju Riigaa "},
        {"Pardod Audi ", "Zane", "Pardod 2005. gada Audi "},
        {"Pardod zemi ", "Dace", "Pardod 100 ha zemi Kurzemee "},
        {"Perk BMW ", "Raivis", "Perku BMW "},
        {"Pardod malku ", "Kaspars", "Pardod malku Latgalee "},
        {"Pardod iPhone ", "Liene", "Pardod iPhone6 "}
    };

    public ArrayList<Advertisement> newAdvertisements() {
       
        int i = 0;
        while (i < 6) {
            Advertisement advertisement = new Advertisement(ad[i][0],
                    ad[i][2], ad[i][1]);
            advertisements.add(advertisement);
            i++;
        }
        return advertisements;
    }

    public Advertisement getAdvertisement() {
        Advertisement advertisement = new Advertisement( "Pardod maju",
                "Pardod lielu maju!", "Janis");
        return advertisement;
    }
    
     public  ArrayList<Advertisement> getAdvertisements(Advertisement advertisement) {
        advertisements.add(advertisement);
        return advertisements;
    }
}
