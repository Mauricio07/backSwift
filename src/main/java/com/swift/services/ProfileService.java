package com.swift.services;

import com.swift.exception.ResourceNotFoundException;
import com.swift.model.Profile;
import com.swift.repository.IProfileRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProfileService {

    private final IProfileRepository iProfileRepository;

    public void save(Profile profile){
        iProfileRepository.save(profile);
    }

    public void update(Long id, Profile profile){
        Profile profile1 = get(id);
        iProfileRepository.save(profile1.withName(profile.getName())
                .withSearch(profile.getSearch())
                .withNewRegister(profile.getNewRegister())
                .withDelete(profile.getDelete())
                .withEdit(profile.getEdit())
                .withEnable(profile.getEnable())
        );
    }

    public Profile get(Long id){
        return iProfileRepository.findById(id).orElseThrow(()->
                new ResourceNotFoundException("Registro no encontrado " + id));
    }

    public Page<Profile> getAll(Pageable pageable){

        return iProfileRepository.findAll(pageable);
    }

}
