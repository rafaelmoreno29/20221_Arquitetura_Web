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

@SpringBootApplication
public class Aula3Application {

	@Bean
	public CommandLineRunner 
		init (@Autowired UsuarioRepository usuarioRepository,
				@Autowired PerfilRepository perfilRepository){
			return args ->{
				Perfil pAdmin = new Perfil(0,"Admin");
				Perfil pBasico = new Perfil(0,"Básico");
				perfilRepository.save(pAdmin);
				perfilRepository.save(pBasico);

				Usuario usu1 = new Usuario(0,"teste","teste@teste","123");
				usu1.setPerfil(pAdmin);
				usuarioRepository.inserir(usu1);
				List<Usuario> listaUsuarios = usuarioRepository.obterTodos();
				listaUsuarios.forEach(System.out::println);	

				System.out.println("**************");
				System.out.println(perfilRepository.findByNome("Admin"));

				Perfil p1 = perfilRepository.findPerfilFetchUsuarios(pAdmin.getId());
				System.out.println(p1);
				System.out.println(p1.getUsuarios());

				Perfil p2 = perfilRepository.findPerfilFetchUsuarios(pBasico.getId());
				System.out.println(p2);
				System.out.println(p2.getUsuarios());
				
			};
		}

	public static void main(String[] args) {
		SpringApplication.run(Aula3Application.class, args);
	}

}
