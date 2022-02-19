package com.sushant.main.model;

import java.io.Serializable;

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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="sim")
public class Sim implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private @Getter @Setter Integer simId;
	
	@Column
	private @Getter @Setter Long simNo;
	
	@Column
	private @Getter @Setter String company;
	
	@Column
	private @Getter @Setter Long  PUC;  //Personal unblocking code

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "custId")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private @Getter @Setter Customer customer;

		
}
