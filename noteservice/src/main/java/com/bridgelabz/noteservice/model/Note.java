package com.bridgelabz.noteservice.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
//@ToString
//@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="id")
@Table(name = "notes")
public class Note {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="note_id")
	private Long noteId;
	
	@Column(name ="title" )
	private String title;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "colour")
	private String colour;
	
	@Column(name = "is_pin")
	private boolean isPin;
	
	@Column(name = "is_trash")
	private boolean isTrash;

	@Column(name = "is_archive")
	private boolean isArchive;
	
	@Column(name = "reminder")
	private String reminder;
	
	@Column(name = "created_time")
	private LocalDateTime create;
	
	@Column(name = "last_update")
	private LocalDateTime lastupdate;
	
	@ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE} )
	private List<Label> label;
	
	
	@Column(name = "user_id")
	private Long userId;
	
//	@ManyToMany(fetch = FetchType.LAZY,
//            cascade = {
//                    CascadeType.ALL,
//                })
//	@JsonIgnoreProperties("collabratorNotes")
//	@JoinTable(name = "collabrateduserdetails",joinColumns=@JoinColumn(name = "noteid",referencedColumnName = "note_id"),
//	inverseJoinColumns =@JoinColumn(name = "userid",referencedColumnName="id"))
//	Set<User> collabrateUser;
}
