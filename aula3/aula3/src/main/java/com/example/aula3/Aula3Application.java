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
	public CommandLineRunner init(@Autowired UsuarioRepository usuarioRepository, @Autowired PerfilRepository perfilRepository ) {
		return args -> {
			usuarioRepository.inserir(
					new Usuario(0, "teste", "teste@teste", "123"));
			usuarioRepository.inserir(
					new Usuario(0, "teste2", "teste2@teste", "123"));

			List<Usuario> listaUsuarios = usuarioRepository.obterTodos();
			listaUsuarios.forEach(System.out::println);

			Perfil p = new Perfil(0,"Admin");
			perfilRepository.inserir(p);

			Usuario usu = usuarioRepository.obterPorNome("teste").get(0);
			usu.setPerfil(p);
			usuarioRepository.atualizar(usu);


			List<Usuario> listaUsuarios2 =usuarioRepository.obterPorPerfil();
			listaUsuarios2.forEach(System.out::println);


		};
	}

	public static void main(String[] args) {
		SpringApplication.run(Aula3Application.class, args);
	}

}
