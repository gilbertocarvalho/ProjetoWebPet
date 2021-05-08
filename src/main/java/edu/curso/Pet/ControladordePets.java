 package edu.curso.Pet;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import org.springframework.web.bind.annotation.RestController;

@RestController 


public class ControladordePets {

	@Autowired
	PetRepository estoquedepets;
	
	@RequestMapping(value="/Pets",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	
	@ResponseBody
	public ResponseEntity<List<Pet>> listarpets(HttpServletResponse respostadoservidor){
		
		respostadoservidor.addHeader("Content-Type", "application/json"); 
		
		
		
		
		
		
		List<Pet> listadepets = estoquedepets.findAll();
		
		  
		
		return ResponseEntity.ok(listadepets);  

		
		
	}
	
               @RequestMapping(value="/Pets/{id}",method=RequestMethod.GET
            		   ,produces=MediaType.APPLICATION_JSON_VALUE)

               @ResponseBody
               public ResponseEntity <List<Pet>> listapetsporid(HttpServletResponse respostadoservidor, @PathVariable("id") Optional<Integer>id
            		   
            		   ){

                          respostadoservidor.addHeader("Content-Type","application/json");

                             List<Pet> listadepets = new ArrayList<Pet>(); 


                          if(id.isPresent()){

                        	Pet pet = estoquedepets.findById(id.get().intValue());
                        	  
                       listadepets.add(pet);
                        

                       
                       
                       
                       
                       
                        }
                            else{
                                         
                               listadepets = estoquedepets.findAll();


                              }

                          
                              return ResponseEntity.ok(listadepets);
                            		  

	}

              @RequestMapping(value="/Pets/add" , method=RequestMethod.POST ,consumes=MediaType.APPLICATION_JSON_VALUE)


public String adicionar(@RequestBody  Pet pet){

 estoquedepets.save(pet);

 System.out.println(pet.getNome());

 return "OK";

}


	
	
}
