package michiel.springframework.sfgpetclinicmichiel.services.map;

import java.util.Set;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import michiel.springframework.sfgpetclinicmichiel.model.PetType;
import michiel.springframework.sfgpetclinicmichiel.services.PetTypeService;

// Door bij elke mothode Super.method() te doen, wordt er door de claas dat dit implementeert gekozen of het een abstractmapservice is
// of een CrudService  op basis van initialisation of profiles

@Service
@Profile({"default","map"})
public class PetTypeMapService extends AbstractMapService<PetType ,Long> implements PetTypeService{

    @Override
    public Set<PetType> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(PetType object) {
        super.delete(object);
    }

    @Override
    public PetType save(PetType object) {
        return super.save(object);
    }

    @Override
    public PetType findById(Long id) {
        return super.findById(id);
    }
}
