package michiel.springframework.sfgpetclinicmichiel.services.map;

import java.util.Set;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import michiel.springframework.sfgpetclinicmichiel.model.Pet;
import michiel.springframework.sfgpetclinicmichiel.services.PetService;

// Door bij elke mothode Super.method() te doen, wordt er door de claas dat dit implementeert gekozen of het een abstractmapservice is
// of een CrudService  op basis van initialisation of profiles
@Service
@Profile({"default","map"})
public class PetMapService extends AbstractMapService<Pet, Long> implements PetService {

    @Override
    public Set<Pet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Pet object) {
        super.delete(object);
    }

    @Override
    public Pet save(Pet object) {

        return super.save(object);
    }

    @Override
    public Pet findById(Long id) {
        return super.findById(id);
    }
}
