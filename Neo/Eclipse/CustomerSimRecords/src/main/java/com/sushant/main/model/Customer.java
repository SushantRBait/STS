package com.sushant.main.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="customer")
public class Customer implements Serializable {
	
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name="cust_id")
	    private Long custId;

	    @Column
	    private String Name;

	    @Column
	    private String email;

	    @Column
	    private String address;

	    @Column
	    @JsonFormat(pattern = "yyyy-MM-dd")
	    private LocalDate dateOfBirth;

	    @OneToMany(mappedBy = "customer",fetch = FetchType.LAZY)
	    private List<Sim> simCards;

}
