package com.tcckaspper.banco.controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.beans.factory.annotation.Value;

import com.tcckaspper.banco.response.FileResponse;
import com.tcckaspper.banco.services.FileService;

@RestController
@RequestMapping("/file")
@Component
public class FileUploadController {
	
	@Autowired
	private FileService fileService;
	
	@Value("${project.image}")
	private String path;
	
	@PostMapping("/upload")
	public ResponseEntity<FileResponse> fileUpload(@RequestParam("image") MultipartFile image) {
		{
			String fileName = null;
			try {
				fileName = this.fileService.uploadImage(path, image);
				
				//Chama o repository e salva o nome do arquivo
				
			} catch (IOException e) {
				e.printStackTrace();
				return new ResponseEntity<>(new FileResponse(null, "Imagem não pode ser carregada, erro no servidor!!"),
						HttpStatus.INTERNAL_SERVER_ERROR);
			}
			return new ResponseEntity<>(new FileResponse(fileName, "Envio de imagem feito com sucesso!!"),
					HttpStatus.OK);
		}

	}
}