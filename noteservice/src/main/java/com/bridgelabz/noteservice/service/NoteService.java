package com.bridgelabz.noteservice.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.bridgelabz.noteservice.dto.NoteDto;
import com.bridgelabz.noteservice.model.Note;
import com.bridgelabz.noteservice.response.Response;

public interface NoteService {

	public ResponseEntity<Response> createNote(NoteDto noteDto, String Token);

	public ResponseEntity<Response> updateNote(Long noteid,NoteDto noteDto, String token);

	public ResponseEntity<Response> trashNote(Long noteId, String token);

	public ResponseEntity<Response> deleteNote(Long noteid,String token);
	
	public ResponseEntity<Response> pinNote(Long noteid, String token);
	
	public ResponseEntity<Response> archiveNote(Long noteid, String token);

	public List<Note> getUserNote(String token);
	
	public List<Note> getNote(String token,boolean trash,boolean archive);
	
	public ResponseEntity<Response> addCollabrator(String token,String emailid,Long noteid);
	
	public ResponseEntity<Response> deleteCollabrator(String emailid,Long noteid);
	
	public ResponseEntity<Response> addReminder(String token,Long noteid,String reminder);
	
	public ResponseEntity<Response> deleteReminder(String token,Long noteid);
		
	public List<Note> getReminderNotes(String token);


}
