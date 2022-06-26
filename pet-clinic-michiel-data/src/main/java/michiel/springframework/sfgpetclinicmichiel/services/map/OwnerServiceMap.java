package michiel.springframework.sfgpetclinicmichiel.services.map;

import java.util.Set;
import org.springframework.stereotype.Service;
import michiel.springframework.sfgpetclinicmichiel.model.Owner;
import michiel.springframework.sfgpetclinicmichiel.services.OwnerService;

// Door bij elke mothode Super.method() te doen, wordt er door de claas dat dit implementeert gekozen of het een abstractmapservice is
// of een CrudService  op basis van initialisation of profiles
@Service
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {

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

        return super.save(object);
    }

    @Override
    public Owner findByLastName(String lastName) {
        return null;
    }
}
