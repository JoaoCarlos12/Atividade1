/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Adm
 */

import java.sql.PreparedStatement;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.SQLException;
import java.util.List;


public class ProdutosDAO {
    
    Connection conn;
    PreparedStatement prep;
    ResultSet resultset;
    
    public PreparedStatement st;
    
    
    public void cadastrarProduto (ProdutosDTO produto){
            
        try{
            conn = new conectaDAO().connectDB();
            st = conn.prepareStatement("INSERT INTO produtos VALUES (?,?,?,?)");
            st.setInt(1, produto.getId());
            st.setString(2, produto.getNome());
            st.setInt(3, produto.getValor());
            st.setString(4, produto.getStatus());
             st.executeUpdate();
           
        }catch(SQLException ex){
            System.out.println("Erro ao conectar: " + ex.getMessage());
           
        }
        
       
        
               
    }
    
    public ArrayList<ProdutosDTO> listarProdutos(){
        
       
       try{
           conn = new conectaDAO().connectDB();
           String sql = "SELECT * FROM produtos";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            ArrayList<ProdutosDTO> listagem = new ArrayList<>();
            
            
            while(rs.next()){
                ProdutosDTO produto = new ProdutosDTO();
                
                produto.setId(rs.getInt("id"));
                produto.setNome(rs.getString("nome"));
                produto.setValor(rs.getInt("valor"));
                produto.setStatus(rs.getString("status"));
                
                listagem.add(produto);
            }        
            return listagem;
            }catch(Exception e){
                return null;
            }

  
    }
    
    
    
        
}

