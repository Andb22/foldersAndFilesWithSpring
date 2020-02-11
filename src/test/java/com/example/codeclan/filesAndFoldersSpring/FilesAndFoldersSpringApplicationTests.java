package com.example.codeclan.filesAndFoldersSpring;

import com.example.codeclan.filesAndFoldersSpring.models.File;
import com.example.codeclan.filesAndFoldersSpring.models.Folder;
import com.example.codeclan.filesAndFoldersSpring.models.User;
import com.example.codeclan.filesAndFoldersSpring.repositories.FileRepository;
import com.example.codeclan.filesAndFoldersSpring.repositories.FolderRepository;
import com.example.codeclan.filesAndFoldersSpring.repositories.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class FilesAndFoldersSpringApplicationTests {

	@Autowired
	FileRepository fileRepository;

	@Autowired
	FolderRepository folderRepository;

	@Autowired
	UserRepository userRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void canCreateAndSaveFileObjects(){
		Folder folder = new Folder("MyDocuments");
		folderRepository.save(folder);
		File file1 = new File("Music", ".mp3", 2.33, folder);
		fileRepository.save(file1);
	}

	@Test
	public void canCreateAndSaveUserObjects(){
		User user = new User("Jen");
		userRepository.save(user);
	}

	@Test
	public void canAddFolderAndUserObjects(){
		Folder folder = new Folder("Documents");
		folderRepository.save(folder);

		File file1 = new File("Music", ".mp3", 2.33, folder);
		fileRepository.save(file1);

		User user = new User("Jen");
		userRepository.save(user);

		folder.addUser(user);
		folderRepository.save(folder);

	}

}
