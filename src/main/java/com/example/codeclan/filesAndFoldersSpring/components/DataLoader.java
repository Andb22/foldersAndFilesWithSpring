package com.example.codeclan.filesAndFoldersSpring.components;

import com.example.codeclan.filesAndFoldersSpring.models.File;
import com.example.codeclan.filesAndFoldersSpring.models.Folder;
import com.example.codeclan.filesAndFoldersSpring.models.User;
import com.example.codeclan.filesAndFoldersSpring.repositories.FileRepository;
import com.example.codeclan.filesAndFoldersSpring.repositories.FolderRepository;
import com.example.codeclan.filesAndFoldersSpring.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {


    @Autowired
    private FolderRepository folderRepository;

    @Autowired
    private FileRepository fileRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Folder folder = new Folder("Documents");
        folderRepository.save(folder);

        File file1 = new File("Music", ".mp3", 2.33, folder);
        fileRepository.save(file1);

        User user = new User("Jen");
        userRepository.save(user);
    }
}
