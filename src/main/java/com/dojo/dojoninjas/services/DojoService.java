package com.dojo.dojoninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.dojo.dojoninjas.models.Dojo;
import com.dojo.dojoninjas.repositories.DojoRepository;

@Service
public class DojoService {

	private final DojoRepository dojoRepository;
	
	public DojoService(DojoRepository dojoRepository) {
		this.dojoRepository = dojoRepository;
	}
	
	public List<Dojo> getAll(){
		return dojoRepository.findAll();	
	}
	
	public Dojo create(Dojo newDojo) {
		return dojoRepository.save(newDojo);
	}
	
    public Dojo findOne(Long id) {
        Optional<Dojo> optionalDojo = dojoRepository.findById(id);
        if(optionalDojo.isPresent()) {
            return optionalDojo.get();
        } else {
            return null;
        }
    }
    
    public Dojo findByName(String name) {
    	Optional<Dojo> optionalDojo = dojoRepository.findByName(name);
    	if(optionalDojo.isPresent()) {
    		return optionalDojo.get();
    	} else {
    		return null;
    	}
    }

}
