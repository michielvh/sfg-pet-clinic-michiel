package michiel.springframework.sfgpetclinicmichiel.services;

import java.util.Set;
import michiel.springframework.sfgpetclinicmichiel.model.Owner;

public interface OwnerService extends CrudService<Owner, Long>{

    Owner findByLastName(String lastName);


}
