package com.adoptme.petshop.services;

import com.adoptme.petshop.entities.Pet;
import com.adoptme.petshop.entities.User;
import com.adoptme.petshop.repositories.PetsRepository;
import com.adoptme.petshop.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PetsService {

    @Autowired private PetsRepository repository;
    @Autowired private UsersRepository usersRepository;

    public Pet save(Pet pet) {
        return repository.save(pet);
    }

    public List<Pet> read() {
        return repository.findAll();
    }

    public Optional<Pet> readOne(Long id) {
        return repository.findById(id);
    }

    public void deleteOne(Long id) {
        repository.deleteById(id);
    }

    public Pet adoptPet(Long petId, Long userId) throws Exception {
        Optional<Pet> pet = repository.findById(petId);
        //el médoto findById del repositorio de JPA devuelve siempre
        //un opcional de algo
        //la mascota puede existir o no existir
        //y la variable pet es de tipo "optional Pet" QUE NO ES LO MISMO que Pet
        if (!pet.isPresent()) {
            throw new Exception("PET NOT FOUND");
        }
        Optional<User> user = usersRepository.findById(userId);
        if (!user.isPresent()) {
            throw new Exception("USER NOT FOUND");
        }
        //luego de encontrar la mascota y el usuario
        //obtengo los correspondientes datos con el método get()
        Pet foundPet = pet.get();
        //para transformar u obtener de la "mascota opcional" la mascota encontrada
        //voy a utilizar el método get()
        User foundUser = user.get();
        foundPet.setOwner(foundUser);
        return repository.save(foundPet);
    }

}
