/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import controller.FabricaConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import model.Cliente;


public class ClienteDAO {
 
    public void inserirCliente(Cliente cliente)
        
{
String sql= "INSERT INTO clientes(nome,cpf,raca,espece,dataNascimento,Enderecos_id)"
             + " VALUES (?,?,?,?,?,?)";
    
   Connection conexao = null;
   PreparedStatement pstmt = null;
      
    try {
        conexao = FabricaConexao.criaConexao();
        pstmt = conexao.prepareStatement(sql);
         pstmt.setString(1,cliente.getNome());
           pstmt.setString(2,cliente.getCpf());
              pstmt.setString(3,cliente.getEmail());
                 pstmt.setString(4,cliente.getTelefone());
                    pstmt.setString(5,cliente.getDataNascimento());
         pstmt.execute();
         JOptionPane.showMessageDialog(null,
                 "Dados Gravados com Sucesso!!!");
    } catch (Exception e) {
        e.printStackTrace(); 
    }
}


public void alterarCliente(Cliente cliente)
{             
 String sql= "UPDATE clientes SET nome=?,cpf=?,email=?,telefone=?,dataNascimento=?,Enderecos_id=? "
         + "WHERE id=?";
    
    Connection conexao = null;
    PreparedStatement pstmt = null;
      
    try {
        conexao = FabricaConexao.criaConexao();
        pstmt = conexao.prepareStatement(sql);
        pstmt.setString(1,cliente.getNome());
        pstmt.setString(2,cliente.getCpf());
        pstmt.setString(3,cliente.getEmail());
        pstmt.setString(4,cliente.getTelefone());
        pstmt.setString(5,cliente.getDataNascimento());
        pstmt.execute();
    } catch (Exception e) {
        e.printStackTrace(); 
    }
}
}
