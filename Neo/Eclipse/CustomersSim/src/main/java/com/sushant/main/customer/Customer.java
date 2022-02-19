package com.sushant.main.customer;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.sushant.main.sim.Sim;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "customer")
@Data 
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private @Getter @Setter Integer custId;
	
	@Column
	private @Getter @Setter String name;
	
	@Column
	private @Getter @Setter String city;
	
	@Column
	private @Getter @Setter String email;
	
	
    @OneToMany(mappedBy = "Customer", cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    private @Getter @Setter Set<Sim> sims = new HashSet<>();
    
}
