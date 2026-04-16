package org.example.app_com_interface;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CadastroDAO {
    // CREATE
    public void cadastrarUsuario (String nome,String email, String senha) {
        String sql = "INSERT INTO usuario (nome, email, senha) VALUES (?,?,?)";
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nome);
            stmt.setString(2, email);
            stmt.setString(3, senha);
            stmt.executeUpdate();
            IO.println("Usuário criado!");
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao criar", e);
        }
    }
}
