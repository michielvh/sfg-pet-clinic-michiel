package michiel.springframework.sfgpetclinicmichiel.services;

import java.util.Set;
import michiel.springframework.sfgpetclinicmichiel.model.Owner;

public interface OwnerService {

    Owner findByLastName(String lastName);
    Owner findById(Long id);
    Owner save(Owner owner);
    Set<Owner> findAll();

}
