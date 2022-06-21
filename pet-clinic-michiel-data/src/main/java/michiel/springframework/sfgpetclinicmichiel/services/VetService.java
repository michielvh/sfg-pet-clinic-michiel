package michiel.springframework.sfgpetclinicmichiel.services;

import java.util.Set;
import michiel.springframework.sfgpetclinicmichiel.model.Vet;

public interface VetService {

    Vet findById(Long id);
    Vet save(Vet vet);
    Set<Vet> findAll();
}
