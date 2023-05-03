/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import controller.FabricaConexao;
import model.Animal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

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
}
