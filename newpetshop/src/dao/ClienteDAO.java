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
import model.Cliente;

public class ClienteDAO {

    public void inserirCliente(Cliente cliente) {
        String sql = "INSERT INTO clientes(nome,cpf,email,telefone,dataNascimento)"
                + " VALUES (?,?,?,?,?)";

        Connection conexao = null;
        PreparedStatement pstmt = null;

        try {
            conexao = FabricaConexao.criaConexao();
            pstmt = conexao.prepareStatement(sql);
            pstmt.setString(1, cliente.getNome());
            pstmt.setString(2, cliente.getCpf());
            pstmt.setString(3, cliente.getEmail());
            pstmt.setString(4, cliente.getTelefone());
            pstmt.setString(5, cliente.getDataNascimento());
            
            pstmt.execute();
            
            JOptionPane.showMessageDialog(null,
                    "Dados Gravados com Sucesso!!!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void alterarCliente(Cliente cliente) {
        String sql = "UPDATE clientes SET nome=?,cpf=?,email=?,telefone=?,dataNascimento=?,Enderecos_id=? "
                + "WHERE id=?";

        Connection conexao = null;
        PreparedStatement pstmt = null;

        try {
            conexao = FabricaConexao.criaConexao();
            pstmt = conexao.prepareStatement(sql);
            pstmt.setString(1, cliente.getNome());
            pstmt.setString(2, cliente.getCpf());
            pstmt.setString(3, cliente.getEmail());
            pstmt.setString(4, cliente.getTelefone());
            pstmt.setString(5, cliente.getDataNascimento());
            pstmt.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
        public List<Cliente> buscarCliente() throws Exception{
        
    Connection conexao = (Connection) FabricaConexao.criaConexao();
    PreparedStatement pstmt = null;
    ResultSet rs= null;  
    
     List<Cliente> cliente = new ArrayList<>();
        try {
         pstmt = conexao.prepareStatement("SELECT * FROM clientes");
         rs = pstmt.executeQuery();
         while(rs.next()){
         Cliente c = new Cliente();
         c.setNome(rs.getString("nome"));
         c.setCpf(rs.getString("cpf"));
         c.setEmail(rs.getString("email"));
         c.setTelefone(rs.getString("telefone"));
         c.setDataNascimento(rs.getString("dataNascimento"));
        
         cliente.add(c);
         }
        } catch (Exception e) {
        }
    return cliente;
    
    }
        
    public List<Cliente> pesquisarCliente(String desc) throws Exception{
        
    Connection conexao = (Connection) FabricaConexao.criaConexao();
    PreparedStatement pstmt = null;
    ResultSet rs= null;  
    
     List<Cliente> cliente = new ArrayList<>();
        try {
         pstmt = conexao.prepareStatement("SELECT * FROM clientes WHERE nome like ?");
         pstmt.setString(1, "%"+desc+"%");
         rs = pstmt.executeQuery();
         while(rs.next()){
         Cliente c = new Cliente();
         c.setNome(rs.getString("nome"));
         c.setCpf(rs.getString("cpf"));
         c.setEmail(rs.getString("email"));
         c.setTelefone(rs.getString("telefone"));
         c.setDataNascimento(rs.getString("dataNascimento"));
        
         cliente.add(c);
             System.out.println(c.getNome());
         }
        } catch (Exception e) {
        }
    return cliente;
    
    }
}
