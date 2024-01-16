package com.example.notesapplication.notesapplication.rest;

import com.example.notesapplication.notesapplication.entity.Notes;
import com.example.notesapplication.notesapplication.service.NotesService;
import com.example.notesapplication.notesapplication.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class Notesrestcontroller {

    private final NotesService notesService;
    private final TokenService tokenService;

    @Autowired
    public Notesrestcontroller(NotesService notesService, TokenService tokenService) {
        this.notesService = notesService;
        this.tokenService = tokenService;
    }

    @PostMapping("/notes")
    public ResponseEntity<String> createNotes(@RequestHeader("Authorization") String authorizationHeader,
                                              @RequestBody Notes notes) {
        if (tokenService.isValidToken(extractAccessToken(authorizationHeader))) {
            notes.setId(0);
            Notes dbNotes = notesService.createNotes(notes);
            return ResponseEntity.ok("Notes have been created successfully");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid token");
        }
    }

    @GetMapping("/notes")
    public ResponseEntity<List<Notes>> findAll(@RequestHeader("Authorization") String authorizationHeader) {
        if (tokenService.isValidToken(extractAccessToken(authorizationHeader))) {
            List<Notes> notesList = notesService.findAll();
            return ResponseEntity.ok(notesList);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    @GetMapping("/notes/{notesId}")
    public ResponseEntity<Notes> findById(@PathVariable int notesId,
                                          @RequestHeader("Authorization") String authorizationHeader) {
        if (tokenService.isValidToken(extractAccessToken(authorizationHeader))) {
            Notes notesfound = notesService.findbyId(notesId);
            if (notesfound != null) {
                return ResponseEntity.ok(notesfound);
            } else {
                return ResponseEntity.notFound().build();
            }
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    private String extractAccessToken(String authorizationHeader) {
        // Assuming "Bearer <token>" format
        return authorizationHeader.substring("Bearer ".length());
    }
}
