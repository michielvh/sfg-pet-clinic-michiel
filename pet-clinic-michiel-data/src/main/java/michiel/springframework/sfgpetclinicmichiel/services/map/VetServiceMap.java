package michiel.springframework.sfgpetclinicmichiel.services.map;

import java.util.Set;
import org.springframework.stereotype.Service;
import michiel.springframework.sfgpetclinicmichiel.model.Speciality;
import michiel.springframework.sfgpetclinicmichiel.model.Vet;
import michiel.springframework.sfgpetclinicmichiel.services.SpecialityService;
import michiel.springframework.sfgpetclinicmichiel.services.VetService;
// Door bij elke mothode Super.method() te doen, wordt er door de claas dat dit implementeert gekozen of het een abstractmapservice is
// of een CrudService  op basis van initialisation of profiles

@Service
public class VetServiceMap extends AbstractMapService<Vet,Long> implements VetService {

    private final SpecialityService specialityService;

    public VetServiceMap(SpecialityService specialityService) {
        this.specialityService = specialityService;
    }

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
    public Vet save(Vet vet) {

        if(vet.getSpecialities().size()>0){
            vet.getSpecialities().forEach(speciality -> {
                if(speciality.getId()==null){
                    Speciality savedSpeciality = specialityService.save(speciality);
                    speciality.setId(savedSpeciality.getId());
                }
            });
        }
        return super.save(vet);
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }
}
