package com.example.aula3;

import java.util.List;

import com.example.aula3.entity.Perfil;
import com.example.aula3.entity.Usuario;
import com.example.aula3.repository.PerfilRepository;
import com.example.aula3.repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class Aula3Application {
	
	@Bean
	public CommandLineRunner 
		init (@Autowired UsuarioRepository usuarioRepository,
				@Autowired PerfilRepository perfilRepository,
				@Autowired PasswordEncoder passwordEncoder){
			return args ->{
				Perfil pAdmin = new Perfil(0,"Administrador");
				pAdmin = perfilRepository.save(pAdmin);

				Usuario usu1 = new Usuario(0,"teste",
										"teste@teste","123");
				
				usu1.setSenha(passwordEncoder.encode(usu1.getSenha()));
				usu1.setPerfil(pAdmin);
				usuarioRepository.save(usu1);
			};
		}

	public static void main(String[] args) {
		SpringApplication.run(Aula3Application.class, args);
	}

}
