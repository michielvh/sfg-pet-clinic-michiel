package michiel.springframework.sfgpetclinicmichiel.repositories;

import org.springframework.data.repository.CrudRepository;
import michiel.springframework.sfgpetclinicmichiel.model.PetType;

/**
 * Created by jt on 8/5/18.
 */
public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
