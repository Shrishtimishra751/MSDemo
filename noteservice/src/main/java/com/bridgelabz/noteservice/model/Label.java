package com.bridgelabz.noteservice.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
//@ToString
@Table(name = "labels")
public class Label {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long labelid;

	private String labelName;
	
	/*@JoinColumn(name = "id")
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private User user;*/
	
	@ManyToMany(mappedBy="label",cascade = {CascadeType.MERGE,CascadeType.PERSIST} )
	@JsonIgnore
	private Set<Note> note;
}
