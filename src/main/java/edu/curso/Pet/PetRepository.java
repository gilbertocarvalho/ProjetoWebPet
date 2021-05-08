 package edu.curso.Pet;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetRepository  extends JpaRepository<Pet, Integer>{

	public  Pet findById(int  id);




}
