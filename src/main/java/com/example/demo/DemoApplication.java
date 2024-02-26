package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.ResourceAccessException;

import java.util.List;
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
	private PartialActorRepository partialActorRepo;

	@Autowired
	private AddressRepository addressRepo;

	@Autowired
	private FilmRepository filmRepo;
	@Autowired
	private PartialFilmRepository partialFilmRepo;

	@Autowired
	private CustomerRepository customerRepo;

	@Autowired
	private CategoryRepository categoryRepo;
	@Autowired
	private PartialCategoryRepository partialCateegoryRepo;

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

	//------------------------------------------Actors--------------------------------------------

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
	public List<PartialActor> getActorsByLastName(@PathVariable("lastName") String lastName) {
        return partialActorRepo.findByLastName(lastName);
	}

	@GetMapping("actor/firstName/{firstName}")
	public List<PartialActor> getActorsByFirstName(@PathVariable("firstName") String firstName) {
        return partialActorRepo.findByFirstName(firstName);
	}

	@GetMapping("actor/{firstName}/{lastName}")
	public List<PartialActor> getActorByName(@PathVariable("lastName") String lastName, @PathVariable("firstName") String firstName){
        return partialActorRepo.findByFirstNameAndLastName(firstName, lastName);
	}

	@PostMapping("/addActor")
	public ResponseEntity<String> addActor(@RequestBody Actor actor) {
		// Perform logic to add actor to the repository
		// You can also perform validation and error handling here

		actorRepo.save(actor);

		// Return a response indicating success
		return ResponseEntity.ok("Actor added successfully");
	}

	@DeleteMapping("/deleteActor")
	public ResponseEntity<String> deleteActor(@RequestBody Actor actor) {
		// Perform logic to delete actor to the repository
		// You can also perform validation and error handling here

		List<Actor> allFoundActor = actorRepo.findActorByFirstNameAndLastName(actor.getFirstName(), actor.getLastName());
		if (!allFoundActor.isEmpty()){
			actorRepo.delete(allFoundActor.get(0));
		}
		//actorRepo.delete( actorRepo.findActorByName(actor.getFirstName(), actor.getLastName()).get(0));

		// Return a response indicating success
		return ResponseEntity.ok("Actor deleted successfully");
	}

	@PostMapping("/addFilmToActor/{id1}/{id2}")
	public Actor addFilmToActor(@PathVariable("id1") int actorID, @PathVariable("id2") int filmID) {
		// Perform logic to add actor to the repository
		// You can also perform validation and error handling here
		Actor actor = actorRepo.findById(actorID).
				orElseThrow(() -> new ResourceAccessException("Category not found"));

		PartialFilm film = partialFilmRepo.findById(filmID).
				orElseThrow(() -> new ResourceAccessException("Film not found"));
		actor.addFilmForActor(film);


		// Return a response indicating success
		return actorRepo.save(actor);
	}



	//------------------------------------Addresses------------------------------------------------
	@GetMapping("/allAddresses")
	public Iterable<Address> getallAddresses(){
		return addressRepo.findAll();
	}

	@GetMapping("address/{id}")
	public Address getAddressByID(@PathVariable("id") int addressID){
		return addressRepo.findById(addressID).
				orElseThrow(() -> new ResourceAccessException("Address not found"));
	}


	//-------------------------------------------Films----------------------------------------------
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
	public Set<PartialActor> getAllActors_Film(@PathVariable("id") int filmID){
		Film film = filmRepo.findById(filmID).
				orElseThrow(() -> new ResourceAccessException("Film not found"));
        return film.getActorsInFilm();
	}


	@PostMapping("/addFilm")
	public ResponseEntity<String> addFilm(@RequestBody Film film) {
		// Perform logic to add actor to the repository
		// You can also perform validation and error handling here

		filmRepo.save(film);

		// Return a response indicating success
		return ResponseEntity.ok("Film added successfully");
	}

	@PostMapping("/addActorToFilm/{id1}/{id2}")
	public Film addActorToFilm(@PathVariable("id1") int filmID, @PathVariable("id2") int actorID) {
		// Perform logic to add actor to the repository
		// You can also perform validation and error handling here
		Film film = filmRepo.findById(filmID).
				orElseThrow(() -> new ResourceAccessException("Film not found"));

		PartialActor actor = partialActorRepo.findById(actorID).
				orElseThrow(() -> new ResourceAccessException("Category not found"));

		film.addActorForFilm((actor));

		// Return a response indicating success
		return filmRepo.save(film);
	}


	@PostMapping("/addCategoryToFilm/{id1}/{id2}")
	public Film addCategoryToFilm(@PathVariable("id1") int filmID, @PathVariable("id2") int categoryID) {
		// Perform logic to add actor to the repository
		// You can also perform validation and error handling here
		Film film = filmRepo.findById(filmID).
				orElseThrow(() -> new ResourceAccessException("Film not found"));

		PartialCategory category = partialCateegoryRepo.findById(categoryID).
				orElseThrow(() -> new ResourceAccessException("Category not found"));

		film.addCatgegoryForFilm(category);

		// Return a response indicating success
		return filmRepo.save(film);
	}


	//---------------------------------------Customers---------------------------------------------
	@GetMapping("/allCustomers")
	public Iterable<Customer> getAllCustomers(){
		return customerRepo.findAll();
	}

	@GetMapping("customer/{id}")
	public Customer getCustomerByID(@PathVariable("id") int customerID){
		return customerRepo.findById(customerID).
				orElseThrow(() -> new ResourceAccessException("Customer not found"));
	}


	//------------------------------------Categories-----------------------------------------------
	@GetMapping("/allCategories")
	public Iterable<Category> getallCategories(){
		return categoryRepo.findAll();
	}

	@GetMapping("category/{id}")
	public Category getCategoryByID(@PathVariable("id") int categoryID){
		return categoryRepo.findById(categoryID).
				orElseThrow(() -> new ResourceAccessException("Category not found"));
	}

	@GetMapping("/allFilms_for_category/{id}")
	public Category getAllFilms_Category(@PathVariable("id") int categoryID){
		Category category = categoryRepo.findById(categoryID).
				orElseThrow(() -> new ResourceAccessException("Category not found"));
		return category;
	}

	@PostMapping("/addCategory")
	public ResponseEntity<String> addCategory(@RequestBody Category category) {
		// Perform logic to add actor to the repository
		// You can also perform validation and error handling here

		categoryRepo.save(category);

		// Return a response indicating success
		return ResponseEntity.ok("Film added successfully");
	}


	@PostMapping("/addFilmToCategory/{id1}/{id2}")
	public Category addFilmToCategory(@PathVariable("id1") int categoryID, @PathVariable("id2") int filmID) {
		// Perform logic to add actor to the repository
		// You can also perform validation and error handling here
		Category category = categoryRepo.findById(categoryID).
				orElseThrow(() -> new ResourceAccessException("Category not found"));

		PartialFilm film = partialFilmRepo.findById(filmID).
				orElseThrow(() -> new ResourceAccessException("Film not found"));
		category.addFilmForCategory(film);


		// Return a response indicating success
		return categoryRepo.save(category);
	}


}
