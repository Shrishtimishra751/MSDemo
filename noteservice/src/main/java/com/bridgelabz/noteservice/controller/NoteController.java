package com.bridgelabz.noteservice.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.noteservice.dto.NoteDto;
import com.bridgelabz.noteservice.model.Note;
import com.bridgelabz.noteservice.response.Response;
import com.bridgelabz.noteservice.service.NoteService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/note")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*", exposedHeaders = "jwtTokens")
public class NoteController {

	Logger log = LoggerFactory.getLogger(NoteController.class);

	@Autowired
	private NoteService noteService;

	@PostMapping("/create")
	@ApiOperation(value = "api to create a note for a user")
	public ResponseEntity<Response> createNote(@RequestBody NoteDto notedto,
			@RequestHeader(value = "token") String token) {
		log.info("inside create note conroller:" + notedto);
		return noteService.createNote(notedto, token);
	}

	@PutMapping("/update")
	@ApiOperation(value = "api to update a paticular note of a user")
	public ResponseEntity<Response> updateNote(@RequestParam(name = "noteId") Long noteid, @RequestBody NoteDto noteDto,
			@RequestHeader(value = "token") String token) {
		System.out.println(noteid);
		System.out.println(noteDto);
		return noteService.updateNote(noteid, noteDto, token);
	}

	@DeleteMapping("/trash")
	@ApiOperation(value = "api to move a paticular note to trash")
	public ResponseEntity<Response> trashNote(@RequestParam(name = "noteId") Long noteId,
			@RequestHeader(value = "token") String token) {

		return noteService.trashNote(noteId, token);
	}

	@GetMapping("/getallnotes")
	@ApiOperation("api to get all notes linked to a user")
	public List<Note> getUserNote(@RequestHeader(value = "token") String token) {
		// System.out.println(token);
		List<Note> notes = noteService.getUserNote(token);
		return notes;
	}

	@DeleteMapping("/delete")
	@ApiOperation(value = "api to delete a note permenently")
	public ResponseEntity<Response> deleteNote(@RequestParam(name = "noteId") Long noteId,
			@RequestHeader(value = "token") String token) {
		return noteService.deleteNote(noteId, token);
	}

	@PostMapping("/pin")
	@ApiOperation("api to set note to pin or unpin ")
	public ResponseEntity<Response> pinNote(@RequestParam(name = "noteId") Long noteId,
			@RequestHeader(value = "token") String token) {

		return noteService.pinNote(noteId, token);

	}

	@PostMapping("/archive")
	@ApiOperation("api to set note to archive or unarchive")
	public ResponseEntity<Response> archiveNote(@RequestParam Long noteId, @RequestHeader String token) {

		return noteService.archiveNote(noteId, token);
	}

	@GetMapping(value = "/getAlls")
	public List<Note> getAllNotes(@RequestParam boolean trash, @RequestParam boolean archive,
			@RequestHeader(value = "token") String token) {
		// System.out.println("======");
		return noteService.getNote(token, trash, archive);
	}

	@PostMapping(value = "/addcollabrator")
	@ApiOperation("api to collabrate a paticular note to other user")
	public ResponseEntity<Response> addCollabrator(@RequestHeader(name = "token") String token,
			@RequestParam String emailid, @RequestParam Long noteid) {
		System.out.println(emailid);
		return noteService.addCollabrator(token, emailid, noteid);
	}

	@DeleteMapping("/deletecollabrator")
	@ApiOperation("api to delete a paticular collabrated note ")
	public ResponseEntity<Response> deleteCollabrator(@RequestParam String emailid, @RequestParam Long noteid) {
		return noteService.deleteCollabrator(emailid, noteid);
	}

	@PostMapping("/addreminder")
	@ApiOperation("api to add reminder to a note ")
	public ResponseEntity<Response> addReminder(@RequestHeader(name = "token") String token, @RequestParam Long noteid,
			@RequestParam String reminder) {
		return noteService.addReminder(token, noteid, reminder);

	}

	@DeleteMapping("/deletereminder")
	@ApiOperation("api to remove reminber from a patricular note")
	public ResponseEntity<Response> deleteReminder(@RequestHeader(name = "token") String token,
			@RequestParam Long noteid) {
		return noteService.deleteReminder(token, noteid);

	}

	@GetMapping("/getremidernotes")
	@ApiOperation("/api to get notes which has reminder")
	public List<Note> getRemiderNotes(@RequestHeader(name = "token") String token) {
		return noteService.getReminderNotes(token);
	}

//	@GetMapping("/getUserDetails")
//	public ResponseEntity<ResponseUser> getUserDetails(@RequestHeader(name = "token") String token){
//		
//		return noteService.getUserDetails(token);
//	}
	@GetMapping("/test")
	public String test() {
		return "hello";
	}
}
