package michiel.springframework.sfgpetclinicmichiel.repositories;

import org.springframework.data.repository.CrudRepository;
import michiel.springframework.sfgpetclinicmichiel.model.Specialty;

/**
 * Created by jt on 8/5/18.
 */
public interface SpecialtyRepository extends CrudRepository<Specialty, Long> {
}
