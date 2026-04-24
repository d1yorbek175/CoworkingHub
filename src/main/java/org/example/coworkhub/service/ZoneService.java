package org.example.coworkhub.service;

import org.example.coworkhub.dto.ZoneDto;
import org.example.coworkhub.model.Result;
import org.example.coworkhub.model.Tolovturi;
import org.example.coworkhub.model.Zone;
import org.example.coworkhub.repository.ZoneRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ZoneService {
    @Autowired
    ZoneRepo zoneRepo;

    //CRUD

    //read
    public List<Zone> getall(){
        return zoneRepo.findAll();
    }
    //read
    public Zone findById(Long id){
        return zoneRepo.findById(id).get();
    }
    //create
    public Result create(ZoneDto zoneDto){
        boolean existed = zoneRepo.existsByName(zoneDto.getName());
        if(existed){
            return new Result("Bunday name mavjud" , false);
        }
        Zone zone = new Zone();
        zone.setName(zone.getName());
        zone.setPrice(zone.getPrice());
        zone.setDescription(zone.getDescription());
        zone.setSigim(zone.getDescription());
        zone.setAddress_id(zone.getAddress_id());
        zone.setImage_url(zone.getDescription());
        zone.setQulayliklar(zone.getQulayliklar());
        zone.setTolovturi(zone.getTolovturi());
        zone.setReyting(zone.getReyting());
        zoneRepo.save(zone);
        return new Result("Saqlandi" , true);
    }
    //update
    public Result update(Long id , ZoneDto zoneDto){
        Optional<Zone> zoneOptional = zoneRepo.findById(id);
        if(zoneOptional.isPresent()){
            Zone zone = zoneOptional.get();
            zone.setName(zoneDto.getName());
            zone.setAddress_id(zoneDto.getAddress_id());
            zone.setDescription(zoneDto.getDescription());
            zone.setPrice(zoneDto.getPrice());
            zone.setTolovturi(Tolovturi.KUNIGA);
            zone.setSigim(zoneDto.getSigim());
            zone.setReyting(zoneDto.getReyting());
            zone.setImage_url(zoneDto.getImage_url());
            zone.setQulayliklar(zoneDto.getQulayliklar());
            zoneRepo.save(zone);
            return new Result("O'zgartirildi" , true);
        }
        return new Result("Id not found" , false);
    }
    //delete
    public Result delete(Long id){
        Optional<Zone> zoneOptional = zoneRepo.findById(id);
        if (zoneOptional.isPresent()){
            Zone zone = zoneOptional.get();
            zoneRepo.delete(zone);
            return new Result("Deleted" , true);
        }
        return new Result("Id not found" , false);
    }

}
