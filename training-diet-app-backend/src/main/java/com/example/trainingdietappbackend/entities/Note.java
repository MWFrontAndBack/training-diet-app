package com.example.trainingdietappbackend.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name ="note")
@Builder

@AllArgsConstructor
@NoArgsConstructor
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    
    @Column(length = 1000)
    private String content;

    @Enumerated(EnumType.STRING)
    private NoteCategory noteCategory;

    @JsonBackReference

    @ManyToOne
    @JoinColumn(name ="user_id" )
    private User owner;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


    public NoteCategory getNoteCategory() {
        return noteCategory;
    }

    public void setNoteCategory(NoteCategory noteCategory) {
        this.noteCategory = noteCategory;
    }
@JsonIgnore
    public void setOwner(User owner) {
        this.owner = owner;
    }


    @Override
    public String toString() {
        return "Note{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", noteCategory=" + noteCategory +
                '}';
    }
}
