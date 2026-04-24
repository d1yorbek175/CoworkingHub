package org.example.coworkhub.controller;

import org.example.coworkhub.dto.ZoneDto;
import org.example.coworkhub.model.Result;
import org.example.coworkhub.model.Zone;
import org.example.coworkhub.service.ZoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/zone")
public class ZoneController {
    @Autowired
    ZoneService zoneService;

    @GetMapping
    public List<Zone> all() {
        return zoneService.getall();
    }

    @GetMapping("/{id}")
    public Zone findById(@PathVariable Long id) {
        return zoneService.findById(id);
    }

    @PostMapping
    public Result add(@RequestBody ZoneDto zoneDto) {
        return zoneService.create(zoneDto);
    }

    @PutMapping("/{id}")
    public Result update(@PathVariable Long id, @RequestBody ZoneDto zoneDto) {
        return zoneService.update(id, zoneDto);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id) {
        return zoneService.delete(id);
    }
}
