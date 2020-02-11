package com.example.codeclan.filesAndFoldersSpring.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "folders")
public class Folder {

    @Column
    private String title;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @JsonBackReference
    @OneToMany(mappedBy = "folder")
    private List<File> files;

    @JsonBackReference
    @ManyToMany
    @JoinTable(
            name = "folders_users",
            joinColumns = { @JoinColumn(
                    name = "folder_id",
                    nullable = false,
                    updatable = false
            )
            },
            inverseJoinColumns = {
                    @JoinColumn(
                            name = "user_id",
                            nullable = false,
                            updatable = false
                    )
            }
    )
    private List<User> users;


    public Folder(String title) {
        this.title = title;
        this.files = new ArrayList<>();
        this.users = new ArrayList<>();
    }

    public Folder() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<File> getFiles() {
        return files;
    }

    public void setFiles(ArrayList<File> files) {
        this.files = files;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public void setFiles(List<File> files) {
        this.files = files;
    }

    public void addUser(User user){
        this.users.add(user);
    }
}
