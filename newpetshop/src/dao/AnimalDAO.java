/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import controller.FabricaConexao;

import model.Animal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import java.sql.ResultSet;

public class AnimalDAO {
 
    public void inserirAnimal(Animal animal){
        String sql= "INSERT INTO animais(nome,sexo,raca,dataNascimento,tutor)"
             + " VALUES (?,?,?,?,?)";
        
        Connection conexao = null;
        PreparedStatement pstmt = null;
        
        try {
            conexao = FabricaConexao.criaConexao();
            pstmt = conexao.prepareStatement(sql);
            pstmt.setString(1,animal.getNome());
            pstmt.setString(2, animal.getSexo());
            pstmt.setString(3,animal.getRaca());
            pstmt.setString(4, animal.getDataNascimento());
            pstmt.setInt(5,animal.getTutor());
            
            pstmt.execute();
            
               JOptionPane.showMessageDialog(null,
                 "Dados Gravados com Sucesso!!!");
            
        } catch (Exception e) {
        }
        
    }
    
    public List<Animal> buscaAnimal() throws Exception{
        
    Connection conexao = (Connection) FabricaConexao.criaConexao();
    PreparedStatement pstmt = null;
    ResultSet rs= null;  
    
     List<Animal> animal = new ArrayList<>();
        try {
         pstmt = conexao.prepareStatement("SELECT * FROM animais");
         rs = pstmt.executeQuery();
         while(rs.next()){
         Animal a = new Animal();
         a.setId(rs.getInt("id"));
         a.setNome(rs.getString("nome"));
         a.setRaca(rs.getString("raca"));
         a.setSexo(rs.getString("sexo"));
         a.setDataNascimento(rs.getString("dataNascimento"));
         a.setTutor(rs.getInt("tutor_id"));
         animal.add(a);
             System.out.println(a.getNome());
         }
        } catch (Exception e) {
        }
    return animal;
    
    }
}
