/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import controller.FabricaConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Usuario;

/**
 *
 * @author LABORATÓRIO
 */
public class UsuarioDAO {
    
        public void inserirCliente(Usuario usuario) {
        String sql = "INSERT INTO usuarios(login,senha)"
                + " VALUES (?,?)";

        Connection conexao = null;
        PreparedStatement pstmt = null;

        try {
            conexao = FabricaConexao.criaConexao();
            pstmt = conexao.prepareStatement(sql);
            pstmt.setString(1, usuario.getLogin());
            pstmt.setString(2, usuario.getSenha());
            
            pstmt.execute();
            
            JOptionPane.showMessageDialog(null,
                    "Dados Gravados com Sucesso!!!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void alteraUsuario(Usuario usuario) {
        String sql = "UPDATE usuarios SET login=?,senha=? "
                + "WHERE id=?";

        Connection conexao = null;
        PreparedStatement pstmt = null;

        try {
            conexao = FabricaConexao.criaConexao();
            pstmt = conexao.prepareStatement(sql);
            pstmt.setString(1, usuario.getLogin());
            pstmt.setString(2, usuario.getSenha());
            
            pstmt.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    public List<Usuario> buscaUsuario() throws Exception{
        
    Connection conexao = (Connection) FabricaConexao.criaConexao();
    PreparedStatement pstmt = null;
    ResultSet rs= null;  
    
     List<Usuario> usuario = new ArrayList<>();
        try {
         pstmt = conexao.prepareStatement("SELECT * FROM clientes");
         rs = pstmt.executeQuery();
         while(rs.next()){
         Usuario u = new Usuario();
        
        u.setLogin(rs.getString("login"));
        u.setLogin(rs.getString("senha"));
        usuario.add(u);
         }
        } catch (Exception e) {
        }
    return usuario;
    
    }
    
}
