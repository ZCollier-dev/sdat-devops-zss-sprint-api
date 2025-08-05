package org.example.rest.gate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/gates")
public class GateController {
    
    @Autowired
    private GateService gateService;

    @GetMapping
    public List<Gate> getAll() {
        return gateService.getAllGates();
    }

    @PostMapping
    public Gate add(@RequestBody Gate gate) {
        return gateService.addGate(gate);
    }

    @PutMapping("/{id}")
    public Gate update(@PathVariable Long id, @RequestBody Gate gate) {
        return gateService.updateGate(id, gate);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        gateService.deleteGate(id);
    }
}
