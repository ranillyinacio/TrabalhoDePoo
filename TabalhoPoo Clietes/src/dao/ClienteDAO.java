
package dao;

import com.sun.webkit.ContextMenu;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Cliente;

public class ClienteDAO {
    Connection con = null;
   
    public ClienteDAO(){
        con = Conexao.abrirConexao();
     JOptionPane.showMessageDialog(null, "Conectado com sucesso");
    }    
    public void salvar(Cliente cliente){
        try {
            String sql = "INSERT INTO CADASTRO(NUMERO, NOME, SEXO,CPF) VALUES (?, ?, ?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, cliente.getNumero());
       ps.setString(2, cliente.getNome());
            ps.setString(3, cliente.getSexo());
             ps.setInt(4, cliente.getCpf());
            if(ps.executeUpdate() != 0){
                JOptionPane.showMessageDialog(null, "'" + cliente.getNome() + "Cadastrado com sucesso ");
            }else{
                JOptionPane.showMessageDialog(null, "Erro ao cadastrar");
            }
           
        } catch (Exception e) {
        }
    }
    
    public void pesquisarAll(){        
        try {
            String sql = "SELECT * FROM Cadastro";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                List<Cliente> lista = new ArrayList<>();
                Cliente aluno = new Cliente();
                aluno.setNumero(rs.getInt("numero"));
                aluno.setNome(rs.getString("nome"));
                aluno.setSexo(rs.getString("SEXO"));
                aluno.setCpf(rs.getInt("cpf"));
                lista.add(aluno);              
               
                for(Cliente l : lista){
                    System.out.println("Numero:" + l.getNumero() + "\n" + "Nome:" + l.getNome()  + "\n" + "Sexo:" + l.getSexo() + "Cpf"+l.getCpf());
                }
            }
            
            
        } catch (Exception e) {
            System.out.println("deu erro");
        }   
    }
    
    public void pesquisar(int numero){  
        Cliente aluno = new Cliente();
        try {           
            PreparedStatement ps;
            ps = con.prepareStatement("SELECT * FROM ALUNO WHERE NUMERO = ?");
            ps.setInt(1, numero);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){                
                
                aluno.setNumero(rs.getInt("numero"));
                aluno.setNome(rs.getString("nome"));
                aluno.setSexo(rs.getString("SEXO"));
                aluno.setCpf(rs.getInt("cpf"));
                System.out.println("Número: " + aluno.getNumero());
                System.out.println("Nome:  " + aluno.getNome());
                System.out.println("Sexo: " + aluno.getSexo());
                System.out.println("Cpf: " + aluno.getCpf());
                               
             }   
            
        } catch (Exception e) {
        }
        
        
    }

    public boolean delete(int numero){
       try {
            String sql = "DELETE FROM ALUNO WHERE NUMERO = '"+numero+"'";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.execute();
          return true;
            }
       catch (Exception e) {
           return false;
        }
   }  
    
    
    //public void atualizar(int numero){
       // try {
            //String sql = "UPDATE ALUNO SET NOME = ?, SEXO = ? WHERE NUMERO = ?";
           // PreparedStatement ps = con.prepareStatement(sql);
           // ps.setString(1, "JOÃO");
            //ps.setString(2, "F");
           // ps.setInt(3, numero);
            //if(ps.executeUpdate() !=0){
             //   System.out.println("Dados alterados com sucesso");
            }
        //} catch (Exception e) {
      //  }//
    //}
//}
