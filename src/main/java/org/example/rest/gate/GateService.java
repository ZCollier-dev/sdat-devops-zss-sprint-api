package org.example.rest.gate;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GateService {
    
    private GateRepository gateRepo;

    public List<Gate> getAllGates() {
        return gateRepo.findAll();
    }

    public Gate addGate(Gate gate){
        return gateRepo.save(gate);
    }

    public Gate updateGate(Long id, Gate gate){
        gate.setId(id);
        return gateRepo.save(gate);
    }

    public void deleteGate(Long id){
        gateRepo.deleteById(id);
    }
}
