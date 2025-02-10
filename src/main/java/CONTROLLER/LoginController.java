/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CONTROLLER;

import MODEL.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author edi
 */
public class LoginController {
      public Usuario validarUsuario(String email, String senha) {
       

         try (Connection conexao = new Conexao().getConexao();
             // Prepara a instrução SQL para inserção
             PreparedStatement preparedStatement = conexao.prepareStatement(
                "SELECT * FROM Usuario WHERE email = ? AND senha = ?;"
             )) {

            preparedStatement.setString(1, email);
            preparedStatement.setString(2, senha);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                Usuario usuario = new Usuario();
                usuario.setIdUsuario(resultSet.getInt("idUsuario"));
                usuario.setNome(resultSet.getString("nome"));
                 usuario.setEmail(resultSet.getString("email"));
                usuario.setSenha(resultSet.getString("senha"));
                usuario.setTipoUsuario(resultSet.getString("tipoUsuario"));
                return usuario;
            }

        } catch (SQLException e) {
            System.err.println("Erro ao validar usuário: " + e.getMessage());
        }

        return null; // Retorna null se a validação falhar
    }
}
