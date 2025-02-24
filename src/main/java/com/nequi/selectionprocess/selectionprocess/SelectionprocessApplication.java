package com.nequi.selectionprocess.selectionprocess;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.transaction.annotation.Transactional;

import com.nequi.selectionprocess.selectionprocess.entity.JobProfileEntity;
import com.nequi.selectionprocess.selectionprocess.entity.OriginEntity;
import com.nequi.selectionprocess.selectionprocess.entity.StateEntity;
import com.nequi.selectionprocess.selectionprocess.service.JobProfileService;
import com.nequi.selectionprocess.selectionprocess.service.OriginService;
import com.nequi.selectionprocess.selectionprocess.service.StateService;

@SpringBootApplication
public class SelectionprocessApplication implements CommandLineRunner {

	@Autowired
	private StateService stateService;

	@Autowired
	private OriginService originService;

    @Autowired
	private JobProfileService jobProfileService;

	public static void main(String[] args) {
		SpringApplication.run(SelectionprocessApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//  createState();
		//  listState();
		// listById();
		// listNameLikeState();
		// updateState();
		// deleteState();
		//-------------------------
		// createOrigin();
		// listOrigin();
		// listByIdOrigin();
		// listNameLikeOrigin();
		// updateOrigin();
		// deleteOrigin();
		//-----------------------
		listJob();
		// createJob();
		listByIdJob();
		listNameLikeJob();
		// updateJob();
		deleteJob();

	}

	// ---------------------------------------------------------------------------------
	// Tabla state.

	// Método para ingresar estados en la tabla "state"
	/**
	 * Crea y guarda una nueva entidad de estado.
	 * 
	 * @Transactional La anotación se utiliza para definir
	 *                los límites transaccionales en los métodos.
	 *                Si readOnly es verdadero, la transacción es solo de lectura,
	 *                lo que puede mejorar el rendimiento y la seguridad.
	 */
	@Transactional
	public void createState() {
		StateEntity stateEntity = new StateEntity(null, "Nuevo3-122345");
		List<StateEntity> listState = new ArrayList<>();
		listState.add(stateEntity);
		stateService.saveState(listState);
	}


	/**
	 * Obtiene y muestra todas las entidades de estado.
	 */
	@Transactional(readOnly = true)
	public void listState() {
		List<StateEntity> states = stateService.getAllState();
		System.out.println("----------------Listar todos----------------------");
		states.stream().forEach(System.out::println);
	}


	/**
	 * Obtiene y muestra una entidad de estado por su ID.
	 * 
	 * @param id El ID del estado a buscar.
	 */
	@Transactional(readOnly = true)
	public void listById() {
		Optional<StateEntity> state = stateService.getByIdState(2);
		System.out.println("--------------Buscar por id------------------------");
		state.ifPresent(System.out::println);
	}


	/**
	 * Obtiene una lista de entidades de estado con nombres que coinciden
	 * parcialmente con el nombre proporcionado.
	 *
	 * @param name El nombre (o parte del nombre) del estado a buscar.
	 * @return Una lista de entidades de estado que coinciden parcialmente con el
	 *         nombre proporcionado.
	 */
	@Transactional(readOnly = true)
	public void listNameLikeState() {
		List<StateEntity> states = stateService.getByNameLikeState("nue");
		System.out.println("----------------Buscar por coincidencia-----------------------");
		states.stream().forEach(state -> System.out.println(state));
	}


	/**
	 * Actualiza el nombre de una entidad de estado con el ID proporcionado.
	 */
	@Transactional()
	public void updateState() {
		System.out.println("-----------------Actualizar -----------------------");
		StateEntity stateEntity = new StateEntity(null,"Perro");
		Optional<StateEntity> state = stateService.updateState(1,stateEntity);// Busca por id

		state.ifPresent(s -> {

			System.out.println(s);
			
			// StateEntity db = stateService.saveState(s); // Agrega los cambios a la base de datos
			// System.out.println(db);

		});

	}


	/**
	 * Elimina una entidad de estado por su ID si existe.
	 */
	@Transactional()
	public void deleteState() {

		System.out.println("-----------------Eliminar -----------------------");
		Optional<StateEntity> state = stateService.getByIdState(2);// Busca por id
		state.ifPresentOrElse(
				s -> {
					stateService.deleteByIdState(s.getIdState());
					System.out.println("Estado eliminado: " + s);
				},
				() -> System.out.println("No exixste el estado con ese id"));

	}

	// ---------------------------------------------------------------------------------
	// Tabla Origin.
	@Transactional(readOnly = true)
	public void listOrigin() {
		List<OriginEntity> states = originService.getAllOrigin();
		System.out.println("----------------Listar todos----------------------");
		states.stream().forEach(System.out::println);
	}


	@Transactional
	public void createOrigin() {
		OriginEntity originEntity = new OriginEntity(null, "Nuevo3-122345");
		List<OriginEntity> listsOrigin = new ArrayList<>();
		listsOrigin.add(originEntity) ;
		originService.saveOrigin(listsOrigin);
	}

	@Transactional(readOnly = true)
	public void listByIdOrigin() {
		Optional<OriginEntity> origin = originService.getByIdOrigin(5);
		System.out.println("--------------Buscar por id------------------------");
		origin.ifPresent(System.out::println);
	}

	@Transactional(readOnly = true)
	public void listNameLikeOrigin() {
		List<OriginEntity> origin = originService.getByNameLikeOrigin("nue");
		System.out.println("----------------Buscar por coincidencia-----------------------");
		origin.stream().forEach(o -> System.out.println(o));
	}


	@Transactional()
	public void updateOrigin() {
		System.out.println("-----------------Actualizar -----------------------");
		OriginEntity originEntity= new OriginEntity(null,"Perro");
		Optional<OriginEntity> origin= originService.updateOrigin(6, originEntity);// Busca por id

		origin.ifPresent(o -> {

			System.out.println(o);
			
			// StateEntity db = stateService.saveState(s); // Agrega los cambios a la base de datos
			// System.out.println(db);

		});

	}

	@Transactional()
	public void deleteOrigin() {

		System.out.println("-----------------Eliminar -----------------------");
		Optional<OriginEntity> origin = originService.getByIdOrigin(6);// Busca por id
		origin.ifPresentOrElse(
				o -> {
					originService.deleteByIdOrigin(o.getIdOrigin());
					System.out.println("Estado eliminado: " + o);
				},
				() -> System.out.println("No exixste el estado con ese id"));

	}




	// ---------------------------------------------------------------------------------
	// Tabla job_profiles


	@Transactional(readOnly = true)
	public void listJob() {
		List<JobProfileEntity> job = jobProfileService.getAllJobProfile();
		System.out.println("----------------Listar todos----------------------");
		job.stream().forEach(System.out::println);
	}

	@Transactional
	public void createJob() {
		JobProfileEntity job = new JobProfileEntity(null, "Nuevo3-122345");
		List<JobProfileEntity> listsJob = new ArrayList<>();
		listsJob.add(job) ;
		jobProfileService.saveJobProfile(listsJob);
	}

	@Transactional(readOnly = true)
	public void listByIdJob() {
		Optional<JobProfileEntity> job = jobProfileService.getByIdJobProfile(8);
		System.out.println("--------------Buscar por id------------------------");
		job.ifPresent(System.out::println);
	}


	@Transactional(readOnly = true)
	public void listNameLikeJob() {
		List<JobProfileEntity> job = jobProfileService.getByNameLikeJobProfile("nue");
		System.out.println("----------------Buscar por coincidencia-----------------------");
		job.stream().forEach(j -> System.out.println(j));
	}


	@Transactional()
	public void updateJob() {
		System.out.println("-----------------Actualizar -----------------------");
		JobProfileEntity job= new JobProfileEntity(null,"Perro");
		Optional<JobProfileEntity> optional= jobProfileService.updateJobProfile(8, job);// Busca por id

		optional.ifPresent(j -> {

			System.out.println(j);
			
			// StateEntity db = stateService.saveState(s); // Agrega los cambios a la base de datos
			// System.out.println(db);

		});

	}

	@Transactional()
	public void deleteJob() {

		System.out.println("-----------------Eliminar -----------------------");
		Optional<JobProfileEntity> job= jobProfileService.getByIdJobProfile(9);// Busca por id
		job.ifPresentOrElse(
				j -> {
					jobProfileService.deleteByIdJobProfile(j.getIdJobProfile());
					System.out.println("Estado eliminado: " + j);
				},
				() -> System.out.println("No exixste el estado con ese id"));

	}



}
