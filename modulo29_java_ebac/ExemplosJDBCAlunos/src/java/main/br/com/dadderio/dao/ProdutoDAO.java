package br.com.dadderio.dao;

import br.com.dadderio.dao.jdbc.ConnectionFactory;
import br.com.dadderio.domain.Cliente;
import br.com.dadderio.domain.Produto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO implements IProdutoDAO {
    @Override
    public Integer cadastrar(Produto produto) throws Exception {
        Connection connection = null;
        PreparedStatement stm = null;
        try{
            connection = ConnectionFactory.getConnection();
            String sql = "INSERT INTO TB_PRODUTO2 (IDPRODUTO, CODIGOPRODUTO, NOMEPRODUTO) VALUES (nextval('SQ_PRODUTO2'), ?, ?)";
            stm = connection.prepareStatement(sql);
            stm.setString(1, produto.getCodigoProduto());
            stm.setString(2, produto.getNomeProduto());
            return stm.executeUpdate();

        }catch(Exception e){
            throw e;
        }finally {
            if(stm != null && !stm.isClosed()){
                stm.close();
            }
            if(connection != null && !connection.isClosed()){
                connection.close();
            }
        }
    }

    @Override
    public Produto consultar(String codigoProduto) throws Exception {
        Connection connection = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        Produto produto = null;
        try{
            connection = ConnectionFactory.getConnection();
            String sql = "SELECT * FROM TB_PRODUTO2 WHERE CODIGOPRODUTO = ?";
            stm = connection.prepareStatement(sql);
            stm.setString(1, codigoProduto);
            rs= stm.executeQuery();
            if(rs.next()){
                produto = new Produto();
                produto.setIdProduto(rs.getLong("idProduto"));
                produto.setCodigoProduto(rs.getString("codigoProduto"));
                produto.setNomeProduto(rs.getString("nomeProduto"));
            }
            return produto;

        }catch(Exception e){
            throw e;
        }finally {
            if(stm != null && !stm.isClosed()){
                stm.close();
            }
            if(connection != null && !connection.isClosed()){
                connection.close();
            }
        }
    }

    @Override
    public Integer excluir(Produto produto) throws Exception {
        Connection connection = null;
        PreparedStatement stm = null;
        try{
            connection = ConnectionFactory.getConnection();
            String sql = "DELETE FROM TB_PRODUTO2 WHERE CODIGOPRODUTO = ?";
            stm = connection.prepareStatement(sql);
            stm.setString(1, produto.getCodigoProduto());
            return stm.executeUpdate();

        }catch(Exception e){
            throw e;
        }finally {

            if(stm != null && !stm.isClosed()){
                stm.close();
            }
            if(connection != null && !connection.isClosed()){
                connection.close();
            }
        }
    }

    @Override
    public List<Produto> buscarTodos() throws Exception {
        Connection connection = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        Produto produto = null;
        List <Produto> listaProdutos = new ArrayList<>();
        try{
            connection = ConnectionFactory.getConnection();
            String sql = "SELECT * FROM TB_PRODUTO2";
            stm = connection.prepareStatement(sql);
            rs= stm.executeQuery();

            while(rs.next()){
                produto = new Produto();
                Long id = rs.getLong("IDPRODUTO");
                String nome = rs.getString("NOMEPRODUTO");
                String codigo = rs.getString("CODIGOPRODUTO");
                produto.setIdProduto(id);
                produto.setNomeProduto(nome);
                produto.setCodigoProduto(codigo);
                listaProdutos.add(produto);
            }
        }catch(Exception e){
            throw e;
        }finally {
            if(stm != null && !stm.isClosed()){
                stm.close();
            }
            if(connection != null && !connection.isClosed()){
                connection.close();
            }
        }
        return listaProdutos;
    }

    @Override
    public Integer atualizar(Produto produto) throws Exception {
        Connection connection = null;
        PreparedStatement stm = null;
        try{
            connection = ConnectionFactory.getConnection();
            String sql = "UPDATE TB_PRODUTO2 SET NOMEPRODUTO = ?, CODIGOPRODUTO = ? WHERE IDPRODUTO = ?";
            stm = connection.prepareStatement(sql);
            stm.setString(1, produto.getNomeProduto());
            stm.setString(2, produto.getCodigoProduto());
            stm.setLong(3, produto.getIdProduto());
            return stm.executeUpdate();

        }catch(Exception e){
            throw e;
        }finally {
            if(stm != null && !stm.isClosed()){
                stm.close();
            }
            if(connection != null && !connection.isClosed()){
                connection.close();
            }
        }
    }
}
