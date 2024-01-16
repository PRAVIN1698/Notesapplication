package com.example.notesapplication.notesapplication.service;


import com.example.notesapplication.notesapplication.entity.Notes;
import jakarta.transaction.Transactional;

import java.util.List;

public interface NotesService {


   //List<Notes> findAllNotes();


   Notes createNotes(Notes notes);
   //Notes findbykeyword();
   List<Notes> findAll();
   Notes findbyId(int id);



   String updateById(int id , Notes updatenotes);


   void deleteById(int theId);
   //Notes sharebyid(int id);
   List<Notes> searchbytopic(String topic);














}
