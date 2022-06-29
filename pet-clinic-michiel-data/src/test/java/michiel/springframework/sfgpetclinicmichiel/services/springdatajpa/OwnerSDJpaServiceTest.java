package michiel.springframework.sfgpetclinicmichiel.services.springdatajpa;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import michiel.springframework.sfgpetclinicmichiel.model.Owner;
import michiel.springframework.sfgpetclinicmichiel.repositories.OwnerRepository;
import michiel.springframework.sfgpetclinicmichiel.repositories.PetRepository;
import michiel.springframework.sfgpetclinicmichiel.repositories.PetTypeRepository;
import michiel.springframework.sfgpetclinicmichiel.services.OwnerService;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {

    @Mock
    OwnerRepository   ownerRepository;
    @Mock
    PetRepository     petRepository;
    @Mock
    PetTypeRepository petTypeRepository;

    @InjectMocks
    OwnerSDJpaService ownerSDJpaService;

    Owner returnOwner;

    @BeforeEach
    void setUp() {
         returnOwner= new Owner();
        returnOwner.setId(1l);
        returnOwner.setLastName("Smith");
    }

    @Test
    void findByLastName() {


        //wanneer ownerRepo findByLastname(eenderwat) gecalled wordt, wil ik de returnowner terug geven
        // Luister op repository
        // callen op service
        // service callt repository
        when(ownerRepository.findByLastName(any())).thenReturn(returnOwner);
        Owner smith = ownerSDJpaService.findByLastName("Smith");

        assertEquals("Smith", smith.getLastName());

        verify(ownerRepository).findByLastName("Smith");
    }

    @Test
    void findAll() {
        Set<Owner> returnOwnersSet = new HashSet<>();
        Owner owner = new Owner();
        owner.setId(2l);
        returnOwnersSet.add(returnOwner);
        returnOwnersSet.add(owner);

        when(ownerRepository.findAll()).thenReturn(returnOwnersSet);

        Set<Owner> owners = ownerSDJpaService.findAll();

        assertNotNull(owners);
        assertEquals(2, owners.size());
    }

    @Test
    void findById() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.of(returnOwner));

        Owner owner = ownerSDJpaService.findById(1L);

        assertNotNull(owner);
    }

    @Test
    void findByIdNotFound() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.empty());

        Owner owner = ownerSDJpaService.findById(1L);

        assertNull(owner);
    }


    @Test
    void save() {
        Owner ownerToSave = returnOwner;

        when(ownerRepository.save(any())).thenReturn(returnOwner);

        Owner savedOwner = ownerSDJpaService.save(ownerToSave);

        assertNotNull(savedOwner);

        verify(ownerRepository).save(any());
    }

    @Test
    void delete() {
        ownerSDJpaService.delete(returnOwner);

        //default is 1 times
        verify(ownerRepository, times(1)).delete(any());
    }

    @Test
    void deleteById() {
        ownerSDJpaService.deleteById(1L);

        verify(ownerRepository).deleteById(anyLong());
    }
}