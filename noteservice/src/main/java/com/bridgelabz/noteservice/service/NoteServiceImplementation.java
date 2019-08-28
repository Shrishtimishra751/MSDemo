package com.bridgelabz.noteservice.service;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.bridgelabz.noteservice.dto.NoteDto;
import com.bridgelabz.noteservice.model.Note;
import com.bridgelabz.noteservice.repository.NoteRepository;
import com.bridgelabz.noteservice.response.Response;
import com.bridgelabz.noteservice.utility.ResponseSender;
import com.bridgelabz.noteservice.utility.TokenUtil;


@Service
public class NoteServiceImplementation implements NoteService {

	@Autowired
	private NoteRepository noteRepository;
	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private Environment environment;
	
//	@Autowired
//	private UserRepository userRepository;
	
//	@Autowired(required=true)
//	ElasticSearchService esService;
	
//	@Autowired
//	private Producer producer;
	
	//MailHelper helper = new MailHelper()
	Logger log=LoggerFactory.getLogger(NoteServiceImplementation.class);

	@Override
	public ResponseEntity<Response> createNote(NoteDto noteDto, String token) {

		Note note = modelMapper.map(noteDto, Note.class);
		Long userId = TokenUtil.decodeToken(token);
//		User user = userRepository.findById(userId)
//				.orElseThrow(() -> new UserException(404, environment.getProperty("105")));
		note.setUserId(userId);
		note.setCreate(LocalDateTime.now());
		note.setLastupdate(LocalDateTime.now());
		noteRepository.save(note);
//		user.getNote().add(note);
//		user = userRepository.save(user);
//		List<Note> notes = user.getNote(); 
		return ResponseSender.sendResponse("note created sucessfully", 200);

		
	}
	@Override
	public ResponseEntity<Response> updateNote(Long noteid, NoteDto noteDto, String token) {
		Long userid = TokenUtil.decodeToken(token);
//		User user = userRepository.findById(userid)
//				.orElseThrow(() -> new UserException(environment.getProperty("105")));
//		List<Note> notes = user.getNote();
//		Note filteredNote = notes.stream().filter(data -> data.getNoteId().equals(noteid)).findFirst()
//				.orElseThrow(() -> new UserException(404, environment.getProperty("105")));
		Note filterednote = noteRepository.findById(noteid).get();
		filterednote.setTitle(noteDto.getTitle());
		filterednote.setDescription(noteDto.getDescription());
		filterednote.setLastupdate(LocalDateTime.now());
		filterednote.setColour(noteDto.getColour());
		noteRepository.save(filterednote);
//		notes.add(filteredNote);
//		user.setNote(notes);
//		userRepository.save(user);
//		esService.UpdateNote(noteid, filteredNote);
		return ResponseSender.sendResponse("note updated successfully", 200);
	}

	@Override
	public ResponseEntity<Response> trashNote(Long noteid, String token) {

//		Long userid = TokenUtil.decodeToken(token);
//		User user = userRepository.findById(userid)
//				.orElseThrow(() -> new UserException(environment.getProperty("105")));
//		List<Note> notes = user.getNote();
//		Note filteredNote = notes.stream().filter(data -> data.getNoteId().equals(noteid)).findFirst()
//				.orElseThrow(() -> new UserException(404, environment.getProperty("105")));
//
//		if (filteredNote.isTrash() == false) {
//			filteredNote.setTrash(true);
//			filteredNote.setLastupdate(LocalDateTime.now());
//			noteRepository.save(filteredNote);
//			esService.UpdateNote(noteid, filteredNote);
//			return ResponseSender.sendResponse(environment.getProperty("304"), 200);
//		} else {
//			filteredNote.setTrash(false);
//			filteredNote.setLastupdate(LocalDateTime.now());
//			noteRepository.save(filteredNote);
//			esService.UpdateNote(noteid, filteredNote);
//			return ResponseSender.sendResponse(environment.getProperty("304"), 200);
//		}
		return null;

	}

	@Override
	public ResponseEntity<Response> deleteNote(Long noteid,String token) {
		
		/*Long userid = TokenUtil.decodeToken(token);
		User user = userRepository.findById(userid)
				.orElseThrow(() -> new UserException(environment.getProperty("user.note")));
		System.out.println(user);
		List<Note> notes = user.getNote();
		Note filteredNote = notes.stream().filter(data -> data.getNoteId().equals(noteid)).findFirst()
				.orElseThrow(() -> new UserException(404, environment.getProperty("user.id")));
	
				noteRepository.deleteById(noteid);
				System.out.println(notes);
				userRepository.save(user);*/
				
		noteRepository.deleteById(noteid);
		
		return ResponseSender.sendResponse("note deleted sucessfully", 200);
	}

	@Override
	public List<Note> getUserNote(String token) {
//		Long userId = TokenUtil.decodeToken(token);
//		User user = note.findById(userId)
//				.orElseThrow(() -> new UserException(404, environment.getProperty("105")));
//		List<Note> userNote = user.getNote();
//		List<Note> collabUser =user.getCollabratorNotes().stream().collect(Collectors.toList());
//		System.out.println(collabUser.isEmpty());
//		userNote.addAll(collabUser);
//		return userNote;
		return null;
	}

	@Override
	public ResponseEntity<Response> pinNote(Long noteid, String token) {
//		Long userid = TokenUtil.decodeToken(token);
//		User user = userRepository.findById(userid)
//				.orElseThrow(() -> new UserException(environment.getProperty("105")));
//		List<Note> notes = user.getNote();
//		Note filteredNote = notes.stream().filter(data -> data.getNoteId().equals(noteid)).findFirst()
//				.orElseThrow(() -> new UserException(404,  environment.getProperty("106")));
//		if (filteredNote.isPin() == false) {
//			filteredNote.setPin(true);
//			filteredNote.setLastupdate(LocalDateTime.now());
//			noteRepository.save(filteredNote);
//			esService.UpdateNote(noteid, filteredNote);
//			return ResponseSender.sendResponse(environment.getProperty("305"), 200);
//		} else {
//			filteredNote.setPin(false);
//			filteredNote.setLastupdate(LocalDateTime.now());
//			noteRepository.save(filteredNote);
//			esService.UpdateNote(noteid, filteredNote);
//			return ResponseSender.sendResponse(environment.getProperty("307"), 200);
//		}
		return null;

	}

	@Override
	public ResponseEntity<Response> archiveNote(Long noteid, String token) {

//		Long userid = TokenUtil.decodeToken(token);
//		User user = userRepository.findById(userid)
//				.orElseThrow(() -> new UserException(environment.getProperty("105")));
//		List<Note> notes = user.getNote();
//		Note filteredNote = notes.stream().filter(data -> data.getNoteId().equals(noteid)).findFirst()
//				.orElseThrow(() -> new UserException(404, environment.getProperty("106")));
//		if (filteredNote.isArchive() == false) {
//			filteredNote.setArchive(true);
//			filteredNote.setLastupdate(LocalDateTime.now());
//			noteRepository.save(filteredNote);
//			esService.UpdateNote(noteid, filteredNote);
//			return ResponseSender.sendResponse(environment.getProperty("306"), 200);
//		} else {
//			filteredNote.setArchive(false);
//			filteredNote.setLastupdate(LocalDateTime.now());
//			noteRepository.save(filteredNote);
//			esService.UpdateNote(noteid, filteredNote);
//			return ResponseSender.sendResponse(environment.getProperty("306"), 200);
//		}
		
		return null;

	}

	@Override
	public List<Note> getNote(String token, boolean trash, boolean archive) {
		
//		Long userId = TokenUtil.decodeToken(token);
//		User user = userRepository.findById(userId).orElseThrow(() -> new UserException("invalid user"));
//		List<Note> collabNote = user.getCollabratorNotes().stream().collect(Collectors.toList());
//		List<Note> userNote = user.getNote().stream().filter(data -> (data.isTrash()==trash && data.isArchive()==archive)).collect(Collectors.toList());
//		userNote.addAll(collabNote);
//		return userNote;
		
		return null;
	}

	@Override
	public ResponseEntity<Response> addCollabrator(String token, String emailid, Long noteid) {
//		Long userid = TokenUtil.decodeToken(token);
//		User user = userRepository.findById(userid).orElseThrow(()-> new UserException("invalid user"));
//
////		User collabUser1 = userRepository.findByEmailid(emailid).get();
////		
////		noteRepository.findById(noteid).map(note->{
////			note.getCollabrateUser().add(collabUser1);
////			return noteRepository.save(note);
////		}).orElseThrow(UserException::new);
////		
//		
//		 Optional<User> collabUser = userRepository.findByEmailid(emailid);
//		 Note note = noteRepository.findById(noteid).get();
//		 System.out.println("title"+note.getTitle());
//		  collabUser.get().getCollabratorNotes().add(note);
//		 System.out.println(collabUser.get().getCollabratorNotes());
//		 note.getCollabrateUser().add(collabUser.get());
//		 noteRepository.save(note); userRepository.save(collabUser.get());
//		 Mail mail = new Mail();
//	        mail.setFrom("venky70662@gmail.com");
//	        mail.setTo(emailid);
//	        mail.setSubject("note shared");
//	        mail.setContent("note is shared with you please check your fundoo account");
//	        producer.sendMessage(mail);
//			esService.UpdateNote(noteid, note);
//		return ResponseSender.sendResponse(environment.getProperty("005"), 200);
//	}
//
//	@Override
//	public ResponseEntity<Response> deleteCollabrator(String emailid, Long noteid) {
//		Optional<Note> note = noteRepository.findById(noteid);
//		User collabrateduser = note.get().getCollabrateUser().stream().filter(data -> data.getEmailid().equals(emailid)).findFirst().orElseThrow(()-> new UserException(404, "emaild note found") );
//		collabrateduser.getCollabratorNotes().remove(note.get());
//		note.get().getCollabrateUser().remove(collabrateduser);
//		noteRepository.save(note.get());
//		userRepository.save(collabrateduser);
//		try {
//			esService.deleteNote(noteid.toString());
//		} catch (IOException e) {
//			
//			e.printStackTrace();
//		}
//		return ResponseSender.sendResponse("collabrated note deleted successfully", 200);
		return null;
	}

	@Override
	public ResponseEntity<Response> addReminder(String token, Long noteid, String reminder) {
//		Long userid = TokenUtil.decodeToken(token);
//		User user = userRepository.findById(userid)
//				.orElseThrow(() -> new UserException(404, "userid not found"));
//		DateFormat dateAndTimeFormat = new SimpleDateFormat("E MMM dd yyyy HH:mm:ss");
//		Date date = null;
//		try {
//			date = dateAndTimeFormat.parse(reminder);
//			System.out.println(date);
//			SimpleDateFormat sdf=new SimpleDateFormat("MMM-dd HH:mm a");
//			
//			Note note = user.getNote().stream().filter(data ->data.getNoteId().equals(noteid)).findFirst().get();
//			note.setReminder(sdf.format(date));
//			//note.setReminder(reminder);
//			//System.out.println(date);
//			note.setLastupdate(LocalDateTime.now());
//			user.getNote().add(note);
//			userRepository.save(user);
//			esService.UpdateNote(noteid, note);
//			return ResponseSender.sendResponse("reminder set success",200 );
//		} catch (Exception e) {
//			
//			e.printStackTrace();
//		}
//		
//		
//				return ResponseSender.sendResponse("reminder is not set", 400);
		return null;
	}

	@Override
	public ResponseEntity<Response> deleteReminder(String token, Long noteid) {
//		Long userid = TokenUtil.decodeToken(token);
//		User user  = userRepository.findById(userid).orElseThrow(()-> new UserException(400, "user not found"));
//			List<Note> notes= user.getNote();
//			Note remidNote = notes.stream().filter(data ->data.getNoteId().equals(noteid)).findFirst().orElseThrow(()-> new NoteException(404, "note not found"));
//				remidNote.setReminder(null);
//				remidNote.setLastupdate(LocalDateTime.now());
//				notes.add(remidNote);
//				userRepository.save(user);
//				esService.UpdateNote(noteid, remidNote);
//				return ResponseSender.sendResponse("reminder removed successfully",200);
		return null;
	}


	@Override
	public List<Note> getReminderNotes(String token) {
//		Long userid = TokenUtil.decodeToken(token);
//		User user = userRepository.findById(userid).orElseThrow(()-> new UserException(400, "user not found"));
//		List<Note>  reminderNote = user.getNote().stream().filter(data ->data.getReminder() !=null).collect(Collectors.toList());
//		return reminderNote;
		
		return null;
	}
	@Override
	public ResponseEntity<Response> deleteCollabrator(String emailid, Long noteid) {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
//	public ResponseEntity<ResponseUser> getUserDetails(String token) {
//		Long userid = TokenUtil.decodeToken(token);
//		User user = userRepository.findById(userid).orElseThrow(()-> new UserException(400, "user not found"));
//				return ResponseSender.sendResponse("sucess", 200, user.getEmailid(), user.getFirstName()+" "+user.getLastName());
//		return null;
//	}
	
	

}
