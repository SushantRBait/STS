package com.sushant.main.model;

import java.io.Serializable;
import java.time.LocalDate;

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
@Table(name="sim")
public class Sim implements Serializable {
	  @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "sim_id")
	    private Long simId;

	    @Column
	    private String company;

	    @Column
	    private LocalDate dtOfPurchasing;

	    @Column
	    private  int mobileNo;

	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "cust_Id")
	    private Customer customer;
		
}
