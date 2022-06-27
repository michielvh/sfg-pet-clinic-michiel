package michiel.springframework.sfgpetclinicmichiel.services.map;

import java.util.Set;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import michiel.springframework.sfgpetclinicmichiel.model.Owner;
import michiel.springframework.sfgpetclinicmichiel.model.Pet;
import michiel.springframework.sfgpetclinicmichiel.services.OwnerService;
import michiel.springframework.sfgpetclinicmichiel.services.PetService;
import michiel.springframework.sfgpetclinicmichiel.services.PetTypeService;

// Door bij elke mothode Super.method() te doen, wordt er door de claas dat dit implementeert gekozen of het een abstractmapservice is
// of een CrudService  op basis van initialisation of profiles
@Service
@Profile({"default","map"})
public class OwnerMapService extends AbstractMapService<Owner, Long> implements OwnerService {

    private final PetTypeService petTypeService;
    private final PetService petService;

    public OwnerMapService(PetTypeService petTypeService, PetService petService) {
        this.petTypeService = petTypeService;
        this.petService = petService;
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }


    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Owner object) {
        super.delete(object);
    }

    @Override
    public Owner save(Owner object) {

        Owner savedOwner = null;

        if(object !=null){
            if(object.getPets() != null){
                object.getPets().forEach(pet-> {
                    if(pet.getPetType() != null){
                        if(pet.getPetType().getId() == null){
                            pet.setPetType(petTypeService.save(pet.getPetType()));
                        }
                    }else{
                        throw new RuntimeException("Pet type is required");
                    }
                    if(pet.getId() == null){
                        Pet savedPet= petService.save(pet);
                        pet.setId(savedPet.getId());
                    }
                        }
                        );
            }
            return super.save(object);
        }else {
            return null;
        }


    }

    @Override
    public Owner findByLastName(String lastName) {
        return null;
    }
}
