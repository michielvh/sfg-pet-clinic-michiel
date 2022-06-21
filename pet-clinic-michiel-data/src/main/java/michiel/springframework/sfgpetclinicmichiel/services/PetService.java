package michiel.springframework.sfgpetclinicmichiel.services;

import java.util.Set;
import michiel.springframework.sfgpetclinicmichiel.model.Pet;

public interface PetService {

    Pet findById(Long id);
    Pet save(Pet pet);
    Set<Pet> findAll();
}
