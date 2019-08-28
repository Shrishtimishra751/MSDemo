package com.bridgelabz.userservice.model;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "userservice")
@Setter
@Getter
@Data
public class User  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "email_id")
	private String emailid;

	@Column(name = "phone_no")
	private String phoneno;

	@Column(name = "password")
	private String password;

	@Column(name = "update_date")
	private String updateDate;

	@Column(name = "register_date")
	private String registerDate;

	@Column(name = "is_verified")
	private boolean isVerified;
	
	@Column(name = "image")
	private String image;
	
//	@JoinColumn(name ="id")
//	@OneToMany(targetEntity = Note.class, cascade = CascadeType.ALL,fetch=FetchType.LAZY)
//	@JsonIgnore
//	private List<Note> note;
//	
//	@JoinColumn(name = "id")
//	@OneToMany(targetEntity = Label.class,cascade = {CascadeType.MERGE,CascadeType.PERSIST},fetch = FetchType.LAZY)
//	private Set<Label> labels;
//
//	 
//	@ManyToMany(mappedBy = "collabrateUser")
//	@JsonIgnoreProperties("collabrateUser")
//  //  @JsonManagedReference
//	//@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@collabrateUser")
//	//@JsonIgnore
//	private Set<Note> collabratorNotes;
	
}
