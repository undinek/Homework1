/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lv.it.mavenproject1.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import lv.it.mavenproject1.domain.Advertisement;
import org.springframework.stereotype.Service;

/**
 *
 * @author Undine
 */
@Service
public class AdvertisementService {

    String name = "Undine";
    String title, author, message;
    public List<Advertisement> hardcodedAdvertisementList;
    public List<Advertisement> reverseAdvertisementList;

    public AdvertisementService() {
        hardcodedAdvertisementList = newAdvertisements();
        reverseAdvertisementList = newAdvertisements();
        Collections.reverse(reverseAdvertisementList);
    }

    String[][] ad = {
        {"Pardod maju ", "Janis", "Pardou maju Riigaa "},
        {"Pardod Audi ", "Zane", "Pardod 2005. gada Audi "},
        {"Pardod zemi ", "Dace", "Pardod 100 ha zemi Kurzemee "},
        {"Perk BMW ", "Raivis", "Perku BMW "},
        {"Pardod malku ", "Kaspars", "Pardod malku Latgalee "},
        {"Pardod iPhone ", "Liene", "Pardod iPhone6 "}
    };

    private List<Advertisement> newAdvertisements() {
        List<Advertisement> advertisements = new ArrayList<>();
        for (int i = 0; i < name.length(); i++) {
            Advertisement advertisement = new Advertisement(Long.valueOf(i), ad[i][0],
                    ad[i][2], ad[i][1]);
            advertisements.add(advertisement);
            
        }
        return advertisements;
    }
    
        public List<Advertisement> getAdvertisementListReverse(){
        return reverseAdvertisementList;
    }

    public List<Advertisement> getAdvertisementListByAuthor(String name) {
        //atgriež šī autora sludinājumus
        List<Advertisement> filteredByName = new ArrayList<>();
        for (Advertisement advertisement : hardcodedAdvertisementList) {
            if (advertisement.getAuthor().equals(author)) {
                filteredByName.add(advertisement);
            }
        }
        return filteredByName;
    }
    
    

//    public Advertisement getAdvertisement() {
//        Advertisement advertisement = new Advertisement(1L, "Pardod māju", "Pārdod lielu māju", "Jānis");
//        return advertisement;
//    }
//
//    public ArrayList<Advertisement> getAdvertisementList() {
//        ArrayList<Advertisement> advertisements = new ArrayList<>();
//        Advertisement advertisement = new Advertisement(1L, "Pardod māju", "Pārdod lielu māju", "Jānis");
//
//        advertisements.add(advertisement);
//
//        return advertisements;
//    }
    
    
//    public List<Advertisement> reverse() {
//        //atgriež datus sakārtotus pretēji numerācijai
//        List<Advertisement> reverseAdvertisements;
//        List<Advertisement> adsClone = new ArrayList<>(ads.subList(0, ads.size()));
//        Collections.reverse(adsClone);
//        reverseAdvertisements = (ArrayList) adsClone;
//        return reverseAdvertisements;
//    }

}
