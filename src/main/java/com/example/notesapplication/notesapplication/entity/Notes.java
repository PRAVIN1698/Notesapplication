package com.example.notesapplication.notesapplication.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "notes", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class Notes {

     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     @Column(name = "id")
     private int id;

     @Column(name = "name")
     private  String name;


     @Column(name = "email", nullable = true)
     private String email;


     @Column(name = "topic")
     private String topic;

     @Column(name = "notes")
     private String notes;



     public String getName() {
          return name;
     }

     public void setName(String name) {
          this.name = name;
     }

     public String getEmail() {
          return email;
     }

     public void setEmail(String email) {
          this.email = email;
     }




     public int getId() {
          return id;
     }

     public void setId(int id) {
          this.id = id;
     }

     public String getTopic() {
          return topic;
     }

     public void setTopic(String topic) {
          this.topic = topic;
     }

     public String getNotes() {
          return notes;
     }

     public void setNotes(String notes) {
          this.notes = notes;
     }


     @Override
     public String toString() {
          return "NotesEntity{" +
                  "id=" + id +
                  ", topic='" + topic + '\'' +
                  ", notes='" + notes + '\'' +
                  '}';
     }
}
