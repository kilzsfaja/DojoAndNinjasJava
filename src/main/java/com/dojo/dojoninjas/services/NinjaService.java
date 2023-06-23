package com.dojo.dojoninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.dojo.dojoninjas.models.Ninja;
import com.dojo.dojoninjas.repositories.NinjaRepository;

@Service
public class NinjaService {
	private final NinjaRepository ninjaRepository;
	
	public NinjaService(NinjaRepository ninjaRepository) {
		this.ninjaRepository = ninjaRepository;
	}
	
    // ---- CREATE ONE ----
    public Ninja create(Ninja ninja) {
        return ninjaRepository.save(ninja);
    }

    // ---- FIND ALL ----
    public List<Ninja> getAll() {
        return ninjaRepository.findAll();
    }

    //  ---- FIND ONE ----
    public Ninja findOne(Long id) {
        Optional<Ninja> optionalNinja = ninjaRepository.findById(id);
        if(optionalNinja.isPresent()) {
            return optionalNinja.get();
        } else {
            return null;
        }
    }
	// ---- EDIT ONE ----
    public Ninja update(Ninja ninja) {
        return ninjaRepository.save(ninja);
    }
    
//    ---- DELETE ONE ----
    public String delete(Long id) {
    	ninjaRepository.deleteById(id);
    	return id + " has been deleted.";
    }

}
