package michiel.springframework.sfgpetclinicmichiel.bootstrap;

import java.time.LocalDate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import michiel.springframework.sfgpetclinicmichiel.model.Owner;
import michiel.springframework.sfgpetclinicmichiel.model.Pet;
import michiel.springframework.sfgpetclinicmichiel.model.PetType;
import michiel.springframework.sfgpetclinicmichiel.model.Vet;
import michiel.springframework.sfgpetclinicmichiel.services.OwnerService;
import michiel.springframework.sfgpetclinicmichiel.services.PetTypeService;
import michiel.springframework.sfgpetclinicmichiel.services.VetService;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService   ownerService;
    private final VetService     vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");
        owner1.setAddress("straat1");
        owner1.setCity("leuven");
        owner1.setTelephone("123");

        Pet mikesPet =new Pet();
        mikesPet.setPetType(savedDogPetType);
    mikesPet.setOwner(owner1);
    mikesPet.setBirthDate(LocalDate.now());
    mikesPet.setName("Rosco");
    owner1.getPets().add(mikesPet);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Fiona");
        owner2.setLastName("Glenanne");
        owner2.setAddress("straat1");
        owner2.setCity("leuven");
        owner2.setTelephone("123");

        Pet fionasCat = new Pet();
        fionasCat.setName("just cat");
        fionasCat.setOwner(owner2);
        fionasCat.setBirthDate(LocalDate.now());
        fionasCat.setPetType(savedCatPetType);
        owner2.getPets().add(fionasCat);

        ownerService.save(owner2);

        System.out.println("Loaded Owners....");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Jessie");
        vet2.setLastName("Porter");

        vetService.save(vet2);

        System.out.println("Loaded Vets....");

    }
}
