package com.sushant.main.controller;

import java.net.URI;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.sushant.main.model.Customer;
import com.sushant.main.model.Sim;
import com.sushant.main.repository.CustomerRepository;
import com.sushant.main.repository.SimRepository;

@RestController
@RequestMapping("api/sim")
public class CreateSimController {
	private final CustomerRepository customerRepository;
	private final SimRepository simRepository;

	@Autowired
	public CreateSimController(CustomerRepository customerRepository, SimRepository simRepository) {
		super();
		this.customerRepository = customerRepository;
		this.simRepository = simRepository;
	}

	@PostMapping("/create")
	public ResponseEntity<Sim> create(@RequestBody Sim sim) {
		Optional<Customer> optionalCustomer = customerRepository.findById(sim.getCustomer().getCustId());
		if (!optionalCustomer.isPresent()) {
			return ResponseEntity.unprocessableEntity().build();
		}

		sim.setCustomer(optionalCustomer.get());

		Sim savedSim = simRepository.save(sim);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedSim.getSimId())
				.toUri();

		return ResponseEntity.created(location).body(savedSim);
	}
}
