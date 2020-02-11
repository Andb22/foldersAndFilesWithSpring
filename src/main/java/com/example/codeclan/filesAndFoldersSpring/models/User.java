package com.example.codeclan.filesAndFoldersSpring.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Column
    private String name;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @JsonBackReference
    @ManyToMany
    @JoinTable(
            name = "users_folders",
            joinColumns = { @JoinColumn(
                    name = "user_id",
                    nullable = false,
                    updatable = false
            )
            },
            inverseJoinColumns = {
                    @JoinColumn(
                            name = "folder_id",
                            nullable = false,
                            updatable = false
                    )
            }

    )
    private List<Folder> folders;

    public User(String name) {
        this.name = name;
    }

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void addFolder(Folder folder){
        this.folders.add(folder);
    }
}
