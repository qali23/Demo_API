package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.ResourceAccessException;

import java.util.Set;
import java.util.stream.Collectors;

@SpringBootApplication
@RestController
@RequestMapping("/home")
@CrossOrigin
public class DemoApplication {

	@Autowired
	private ActorRepository actorRepo;

	@Autowired
	private AddressRepository addressRepo;

	@Autowired
	private FilmRepository filmRepo;

	@Autowired
	private CustomerRepository customerRepo;

	@Autowired
	private CategoryRepository categoryRepo;

	public DemoApplication(ActorRepository actorRepo, AddressRepository addressRepo, FilmRepository filmRepo, CustomerRepository customerRepo, CategoryRepository categoryRepo) {
		this.actorRepo = actorRepo;
		this.addressRepo = addressRepo;
		this.filmRepo = filmRepo;
		this.customerRepo = customerRepo;
		this.categoryRepo = categoryRepo;
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@GetMapping("/allActors")
	public Iterable<Actor> getallActors(){
		return actorRepo.findAll();
	}

	@GetMapping("actor/{id}")
	public Actor getActorByID(@PathVariable("id") int actorID){
		return actorRepo.findById(actorID).
				orElseThrow(() -> new ResourceAccessException("Actor not found"));
	}

	@GetMapping("actor/surname/{lastName}")
	public Set<ActorDTO> getActorsByLastName(@PathVariable("lastName") String lastName) {
        return actorRepo.findByLastName(lastName).stream().map(actor -> new ActorDTO(actor.getActorID(), actor.getFirstName(), actor.getLastName())).collect(Collectors.toSet());
	}

	@GetMapping("actor/firstName/{firstName}")
	public Set<ActorDTO> getActorsByFirstName(@PathVariable("firstName") String firstName) {
        return actorRepo.findByFirstName(firstName).stream().map(actor -> new ActorDTO(actor.getActorID(), actor.getFirstName(), actor.getLastName())).collect(Collectors.toSet());
	}

	@GetMapping("actor/{firstName}/{lastName}")
	public Set<ActorDTO> getActorByName(@PathVariable("lastName") String lastName, @PathVariable("firstName") String firstName){
        return actorRepo.findByFirstNameAndLastName(firstName, lastName).stream().map(actor -> new ActorDTO(actor.getActorID(), actor.getFirstName(), actor.getLastName())).collect(Collectors.toSet());
	}


	@GetMapping("/allAddresses")
	public Iterable<Address> getallAddresses(){
		return addressRepo.findAll();
	}

	@GetMapping("address/{id}")
	public Address getAddressByID(@PathVariable("id") int addressID){
		return addressRepo.findById(addressID).
				orElseThrow(() -> new ResourceAccessException("Address not found"));
	}


	@GetMapping("/allFilms")
	public Iterable<Film> getallFilms(){
		return filmRepo.findAll();
	}

	@GetMapping("film/{id}")
	public Film getFilmByID(@PathVariable("id") int filmID){
		return filmRepo.findById(filmID).
				orElseThrow(() -> new ResourceAccessException("Film not found"));
	}

	@GetMapping("/allActors_for_film/{id}")
	public Set<ActorDTO> getAllActors_Film(@PathVariable("id") int filmID){
		Film film = filmRepo.findById(filmID).
				orElseThrow(() -> new ResourceAccessException("Film not found"));

        return film.getActorsInFilm().stream().map(actor -> new ActorDTO(actor.getActorID(), actor.getFirstName(), actor.getLastName())).collect(Collectors.toSet());
	}

	@GetMapping("/allCustomers")
	public Iterable<Customer> getAllCustomers(){
		return customerRepo.findAll();
	}

	@GetMapping("customer/{id}")
	public Customer getCustomerByID(@PathVariable("id") int customerID){
		return customerRepo.findById(customerID).
				orElseThrow(() -> new ResourceAccessException("Customer not found"));
	}

	@GetMapping("/allCategories")
	public Iterable<Category> getallCategories(){
		return categoryRepo.findAll();
	}

	@GetMapping("category/{id}")
	public Category getCategoryByID(@PathVariable("id") int categoryID){
		return categoryRepo.findById(categoryID).
				orElseThrow(() -> new ResourceAccessException("Category not found"));
	}


}
