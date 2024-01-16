package com.example.notesapplication.notesapplication.service;


import com.example.notesapplication.notesapplication.dao.Notesrespository;
import com.example.notesapplication.notesapplication.entity.Notes;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class Notesimpl implements  NotesService{


    Notesrespository notesrespository;




    public Notesimpl(Notesrespository thenotesrespository)
    {
        this.notesrespository = thenotesrespository;
    }


    @Transactional
    @Override
    public Notes createNotes(Notes notes) {
        System.out.println(notes);
        notesrespository.save(notes);
        return null;
    }
    @Transactional
    @Override
    public List<Notes> findAll() {
        return notesrespository.findAll();
    }


    @Transactional
    @Override
    public Notes findbyId(int id) {


        Optional<Notes> result  = notesrespository.findById(id);

        Notes notes = null;

        if(result.isPresent())
        {
            notes =  result.get();

        }else{
            throw  new RuntimeException("Did not find notes" + id);
        }
        return notes;

    }

    @Override
    public String updateById(int id, Notes updateNotes) {
        Optional<Notes> optionalNotes = notesrespository.findById(id);

        if (optionalNotes.isPresent()) {
            Notes existingNotes = optionalNotes.get();
             existingNotes.setTopic(updateNotes.getTopic());
             existingNotes.setNotes(updateNotes.getNotes());
            notesrespository.save(existingNotes);

            return "Notes with ID " + id + " updated successfully";
        } else {
            return "Notes with ID " + id + " not found";
        }
    }


    @Transactional
    @Override
    public void deleteById(int theId) {

        notesrespository.deleteById(theId);

    }


    @Override
    public List<Notes> searchbytopic(String topic) {
        return notesrespository.findByTopic(topic);
    }


}
