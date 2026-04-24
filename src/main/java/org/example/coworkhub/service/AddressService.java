package org.example.coworkhub.service;

import org.example.coworkhub.dto.AddressDto;
import org.example.coworkhub.model.Address;
import org.example.coworkhub.model.Result;
import org.example.coworkhub.repository.AddressRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {
    @Autowired
    AddressRepo addressRepo;

    //read
    public List<Address> getall(){
        return addressRepo.findAll();
    }
    //read
    public Address findById(Long id){
        return addressRepo.findById(id).get();
    }
    //create
    public Result create(AddressDto addressDto){
        boolean existed = addressRepo.existByManzil(addressDto.getManzil());
        if (existed) {
            return new Result("Bunday manzil mavjud", false);
        }
        Address address = new Address();
        address.setTuman(addressDto.getTuman());
        address.setManzil(addressDto.getManzil());
        addressRepo.save(address);
        return new Result("Saqlandi", true);
    }
    //update
    public Result update(Long id, AddressDto addressDto){
        Optional<Address> addressOptional = addressRepo.findById(id);
        if (addressOptional.isPresent()){
            Address address = new Address();
            address.setTuman(addressDto.getTuman());
            address.setManzil(addressDto.getManzil());
            addressRepo.save(address);
            return new Result("O'zgartirildi" , true);

            3
        }
        return new Result("Id topilmadi" , false);
    }
    //delete
    public Result delete(Long id){
        Optional<Address> addressOptional = addressRepo.findById(id);
        if(addressOptional.isPresent()){
            Address address = addressOptional.get();
            addressRepo.delete(address);
            return new Result("Deleted" , true);
        }
        return new Result("Id not found", false);
    }
}
