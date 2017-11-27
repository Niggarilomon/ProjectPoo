/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SQLITE;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jerlyson
 */
public class Main {
    
    public boolean exist(String table,String tag, String text){
        SQLiteconnection cnn = new SQLiteconnection(); 
        
        
        ResultSet resultset = null;
        Statement statement = null;
        
        
        cnn.Conectar();
        
        String query = "SELECT * FROM "+ table + ";" ;
        
        statement = cnn.criarStatement();
        
        try{
            resultset = statement.executeQuery(query);
            
            while(resultset.next()){
                
                String test = resultset.getString(tag);
                
                
                if(test.equals(text)){
                    return true;
                }               
                    
            }
                
            
        }catch(SQLException e){
            System.out.println(e);
        }finally{
            try{
                resultset.close();
                statement.close();
                cnn.Desconnectar();
                
            }catch(SQLException ex){
                System.out.println("Erro no fechamento");
            }
        }
        
        
        return false;
    }
    
    public int getIdcourse(String getstring){
        SQLiteconnection cnn = new SQLiteconnection(); 
        
        
        ResultSet resultset = null;
        Statement statement = null;
        
        
        cnn.Conectar();
        
        String query = "SELECT * FROM course;" ;
        
        statement = cnn.criarStatement();
        
        try{
            resultset = statement.executeQuery(query);
            
            while(resultset.next()){
                String namecamp = resultset.getString("c_nome");
                int id = resultset.getInt("c_code");
                
                if(namecamp.equals(getstring)){
                    return id;
                }               
                    
            }
                
            
        }catch(SQLException e){
            System.out.println(e);
        }finally{
            try{
                resultset.close();
                statement.close();
                cnn.Desconnectar();
                
            }catch(SQLException ex){
                System.out.println("Erro no fechamento");
            }
        }
        
        
        return 0;
    }
    
    
    //faz o login
    public boolean login(String table, String tag, String tagpass,String text, String textpass){
        
        SQLiteconnection cnn = new SQLiteconnection(); 
        
        
        ResultSet resultset = null;
        Statement statement = null;
        
        
        cnn.Conectar();
        
        String query = "SELECT * FROM "+ table + ";" ;
        
        statement = cnn.criarStatement();
        
        try{
            resultset = statement.executeQuery(query);
            
            while(resultset.next()){
                
                String test = resultset.getString(tag);
                String testPass = resultset.getString(tagpass);
                
                if(test.equals(text) && testPass.equals(textpass)){
                    return true;
                }               
                    
            }
                
            
        }catch(SQLException e){
            System.out.println(e);
        }finally{
            try{
                resultset.close();
                statement.close();
                cnn.Desconnectar();
                
            }catch(SQLException ex){
                System.out.println("Erro no fechamento");
            }
        }
        
        
        return false;
    }
    
    public List<String> names = new ArrayList<>();
    
    //Para pegar varios abritudos do DB de um certo tipo e coloca em lista
    public void giveMe(String table, String tag){
        
        SQLiteconnection cnn = new SQLiteconnection(); 
        
        
        ResultSet resultset = null;
        Statement statement = null;
        
        
        cnn.Conectar();
        
        String query = "SELECT * FROM "+ table +";" ;
        
        statement = cnn.criarStatement();
        
        try{
            String help = "Negaodapiroca";
            resultset = statement.executeQuery(query);
            
            while(resultset.next()){
        
                names.add(resultset.getString(tag));
                
            }
               
            
            
        }catch(SQLException e){
            System.out.println(e);
        }finally{
            try{
                resultset.close();
                statement.close();
                cnn.Desconnectar();
                
            }catch(SQLException ex){
                System.out.println("Erro no fechamento");
            }
        }
        
        
       
    }
    
    
    
    
}