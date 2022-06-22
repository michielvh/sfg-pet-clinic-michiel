package michiel.springframework.sfgpetclinicmichiel.services.map;

import java.util.Set;
import michiel.springframework.sfgpetclinicmichiel.model.Vet;
import michiel.springframework.sfgpetclinicmichiel.services.CrudService;
import michiel.springframework.sfgpetclinicmichiel.services.VetService;

public class VetServiceMap extends AbstractMapService<Vet,Long> implements CrudService<Vet,Long> {

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Vet object) {
        super.delete(object);
    }

    @Override
    public Vet save(Vet object) {

        return super.save(object.getId(),object);
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }
}