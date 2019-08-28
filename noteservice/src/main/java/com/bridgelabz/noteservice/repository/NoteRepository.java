package com.bridgelabz.noteservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bridgelabz.noteservice.model.Note;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long>{
	public Optional<Note> findByNoteId(Long noteid);
	
}
