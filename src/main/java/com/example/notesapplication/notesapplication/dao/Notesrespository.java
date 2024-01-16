package com.example.notesapplication.notesapplication.dao;


import com.example.notesapplication.notesapplication.entity.Notes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(path="members")
public interface Notesrespository  extends JpaRepository<Notes, Integer> {


    @Query("SELECT n FROM Notes n WHERE n.topic = :topic")
    List<Notes> findByTopic(@Param("topic") String topic);

}

