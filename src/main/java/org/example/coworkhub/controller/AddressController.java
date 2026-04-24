package org.example.coworkhub.controller;

import org.example.coworkhub.dto.AddressDto;
import org.example.coworkhub.model.Address;
import org.example.coworkhub.model.Result;
import org.example.coworkhub.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/address")
public class AddressController {
    @Autowired
    AddressService addressService;

    @GetMapping
    public List<Address> all() {
        return addressService.getall();
    }

    @GetMapping("/{id}")
    public Address findById(@PathVariable Long id) {
        return addressService.findById(id);
    }

    @PostMapping
    public Result add(@RequestBody AddressDto addressDto) {
        return addressService.create(addressDto);
    }

    @PutMapping("/{id}")
    public Result update(@PathVariable Long id, @RequestBody AddressDto addressDto) {
        return addressService.update(id, addressDto);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id) {
        return addressService.delete(id);
    }
}
