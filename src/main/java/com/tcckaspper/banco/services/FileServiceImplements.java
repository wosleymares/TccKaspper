package com.tcckaspper.banco.services;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileServiceImplements implements FileService{
	
	@Override
	public String uploadImage(String path, MultipartFile file)throws IOException {
		
		//Nome do arquivo
		String name=file.getOriginalFilename();
		
		//Gerador de arquivo com nome aleatório
		String randomID = UUID.randomUUID()	.toString();
		String fileName1 = randomID.concat(name.substring(name.lastIndexOf(".")));
		
		//Caminho do arquivo
		String filePath = path+ File.separator + fileName1;
		
		
		//Criar pasta se não for criada
		File f = new File(path);
		if (!f.exists())
			f.mkdir();
		
		//copia de arquivo
		
		Files.copy(file.getInputStream(), Paths.get(filePath));
		
		return name;
	}

}
