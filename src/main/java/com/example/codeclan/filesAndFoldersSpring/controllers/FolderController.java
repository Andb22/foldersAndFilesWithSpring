package com.example.codeclan.filesAndFoldersSpring.controllers;

import com.example.codeclan.filesAndFoldersSpring.models.Folder;
import com.example.codeclan.filesAndFoldersSpring.repositories.FolderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FolderController {

    @Autowired
    private FolderRepository folderRepository;

    @GetMapping(value = "/folders")
    public ResponseEntity<List<Folder>> getAllFolders(){
        return new ResponseEntity<>(folderRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/folders/{id}")
    public ResponseEntity getFolder(@PathVariable Long id){

        return new ResponseEntity<>(folderRepository.findById(id), HttpStatus.OK);
    }


    @PostMapping(value = "/folders")
    public ResponseEntity<Folder> createFolder(@RequestBody Folder folder){
        folderRepository.save(folder);
        return new ResponseEntity<>(folder, HttpStatus.CREATED);
    }


    @PatchMapping(value = "/folders/{id}")
    public ResponseEntity<Folder> updateFolder(@RequestBody Folder folder,
                                             @PathVariable Long id){
        folderRepository.save(folder);
        return new ResponseEntity<>(folder, HttpStatus.CREATED);
    }
}
