package com.example.aula3.security.jwt;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;

import com.example.aula3.Aula3Application;
import com.example.aula3.entity.Perfil;
import com.example.aula3.entity.Usuario;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class JwtService {
    @Value("${security.jwt.expiracao}")
    private String expiracao;
    @Value("${security.jwt.chave-assinatura}")
    private String chaveAssinatura;

    public String gerarToken(Usuario usuario){
        //data de expiração
        Long expString = Long.valueOf(expiracao);
        LocalDateTime dataHoraExpiracao = LocalDateTime.now()
                                            .plusMinutes(expString);
        Date data = Date.from(dataHoraExpiracao.atZone(
                                ZoneId.systemDefault()).toInstant());
        //payload (corpo do token)
        HashMap<String,Object> claims = new HashMap<>();
        claims.put("nome", usuario.getNome());
        claims.put("email", usuario.getEmail());
        claims.put("id", usuario.getId());
       // claims.put("perfil", usuario.getPerfil().getId()); 
       // claims.put("nomePerfil", usuario.getPerfil().getNome());
       
        //gerando e retornando o token
        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(data)
                .signWith(SignatureAlgorithm.HS512, chaveAssinatura)
                .compact();
    }
    public Claims obterClaims(String token) throws ExpiredJwtException{
        return Jwts.parser()
            .setSigningKey(chaveAssinatura)
            .parseClaimsJws(token)
            .getBody();
    }
    public String obterEmail(String token) throws ExpiredJwtException{
        Claims c = obterClaims(token);
        return (String)c.get("email");
    }

    public boolean validarToken(String token){
        try{
            Claims claims = obterClaims(token);
            Date dataExpiracao = claims.getExpiration();
            LocalDateTime data = dataExpiracao.toInstant()
                        .atZone(ZoneId.systemDefault()).toLocalDateTime();
            
            return !LocalDateTime.now().isAfter(data);
        }
        catch(Exception ex){
            return false;
        }
    }

 /*   public static void main(String[] args){
        ConfigurableApplicationContext contexto = SpringApplication.run(Aula3Application.class);
        JwtService service = contexto.getBean(JwtService.class);
        Usuario usuario = new Usuario(1, "Rafael", 
                                "rafael@teste.com", "123");
        Perfil perfil = new Perfil(1,"teste");
        usuario.setPerfil(perfil);

        String token = service.gerarToken(usuario);
        System.out.println(token);
        boolean isValid = service.validarToken(token);
        System.out.println("Token válido? " + isValid);
      //  System.out.println("Usuário: " + service.obterLoginUsuario(token));
        
    }*/
}
