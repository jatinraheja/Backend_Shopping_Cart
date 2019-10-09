package com.casestudy.eCart.controller;
import com.casestudy.eCart.Modal.Items;
import com.casestudy.eCart.Modal.User;
import com.casestudy.eCart.Modal.Users;
import com.casestudy.eCart.exception.ResourceNotFoundException;
import com.casestudy.eCart.repository.UserRepository;
import com.casestudy.eCart.repository.itemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class ItemsController {
    @Autowired
    itemRepository itemrepository;
    UserRepository userRepository;
    @GetMapping("/items")
    public List<Items> getAllNotes() {
        return itemrepository.findAll();
    }

    @GetMapping("/items/{id}")
    public Items getItembyId(@PathVariable(value = "id") Long id)
    {
       return itemrepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("item","Id",id));
    }
    @GetMapping("/items/category/{cat}")
    public List<Items> getItembyCategory(@PathVariable(value = "cat") String cat)
    {
        return itemrepository.findAllByCategory(cat);
    }
    @PostMapping("/items")
    public Items createNote(@Valid @RequestBody Items item) {
        return itemrepository.save(item);
    }

//    @GetMapping(produces = "application/json")
    @GetMapping("/getuser")
    public List<Users> getSuccess()
    {
        return userRepository.findAll();
    }
//    @GetMapping("/validate/validateLogin" )
//    public String validateLogin() {
//        return new Users("User successfully authenticated");
//    }

//    @GetMapping("/notes/{id}")
//    public Items getNoteById(@PathVariable(value = "id") Long noteId) {
//        return itemRepository.findById(noteId)
//                .orElseThrow(() -> new ResourceNotFoundException("Note", "id", noteId));
//    }
//    @PutMapping("/notes/{id}")
//    public Items updateNote(@PathVariable(value = "id") Long noteId,
//                           @Valid @RequestBody Items noteDetails) {
//
//        Items note = itemRepository.findById(noteId)
//                .orElseThrow(() -> new ResourceNotFoundException("Note", "id", noteId));
//
//        note.setTitle(noteDetails.getTitle());
//        note.setContent(noteDetails.getContent());
//
//        Note updatedNote = noteRepository.save(note);
//        return updatedNote;
//    }
//    @DeleteMapping("/notes/{id}")
//    public ResponseEntity<?> deleteNote(@PathVariable(value = "id") Long noteId) {
//        Note note = noteRepository.findById(noteId)
//                .orElseThrow(() -> new ResourceNotFoundException("Note", "id", noteId));
//
//        noteRepository.delete(note);
//
//        return ResponseEntity.ok().build();
//    }

}
