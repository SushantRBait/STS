package com.sushant.main.sim;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sushant.main.customer.Customer;

import lombok.AllArgsConstructor;
import lombok.Data;
//import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Sim {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	@Getter
	@Setter
	private Long id;
	
	@Getter
	@Setter
	private Long simno;
	
	@Getter
	@Setter
	private Long  PUC;  //Personal unblocking code

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "custId")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private @Getter @Setter Customer customer;

		
}
