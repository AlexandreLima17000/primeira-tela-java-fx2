package org.example.app_com_interface;

import org.example.app_com_interface.DatabaseConfig;
import org.mindrot.jbcrypt.BCrypt;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CadastroDAO {

    // Método CREATE - Cadastra o usuário com senha protegida
    public void cadastrarUsuario(String nome, String email, String senha) {

        // 1. GERAR O HASH: Transforma a senha pura em uma senha criptografada
        // O custo '12' é o padrão recomendado para segurança atual
        String senhaHasheada = BCrypt.hashpw(senha, BCrypt.gensalt(12));

        String sql = "INSERT INTO usuario (nome, email, senha) VALUES (?, ?, ?)";

        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, nome);
            stmt.setString(2, email);

            // 2. GRAVAR O HASH: Salvamos a versão segura no banco de dados
            stmt.setString(3, senhaHasheada);

            stmt.executeUpdate();

            // Feedback no console
            System.out.println("Usuário criado com sucesso!");
            System.out.println("Senha original: " + senha);
            System.out.println("Hash salvo no banco: " + senhaHasheada);

        } catch (SQLException e) {
            // Lança uma exceção caso algo dê errado com o banco de dados
            throw new RuntimeException("Erro ao cadastrar usuário no banco de dados", e);
        }
    }
}