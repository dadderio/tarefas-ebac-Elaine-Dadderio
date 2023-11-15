package br.edu.dadderio.dao;


import br.edu.dadderio.domain.Cliente;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

//aqui começa a implementação:
public class ClienteMapDAO implements IClienteDAO {

    //Onde vai salvar:
    private Map<Long, Cliente> map;

    //Construtor:
    public ClienteMapDAO() {
        //dentro do construtor, instaciou o Map:
        this.map = new HashMap<>();
    }

    @Override
    public Boolean cadastrar(Cliente cliente) {
        if(this.map.containsKey(cliente.getCpf())){
            return false; //se tem cpf cadastrado, retorna falso e, portanto, não cadastrou
        }
        this.map.put(cliente.getCpf(), cliente);
        return true;
    }

    @Override
    public void excluir(Long cpf) {
        Cliente clienteCadastrado = this.map.get(cpf);

        if(clienteCadastrado != null){
            this.map.remove(clienteCadastrado.getCpf(), clienteCadastrado);
        }

    }

    @Override
    public void alterar(Cliente cliente) {
        Cliente clienteCadastrado = this.map.get(cliente.getCpf());
        if(clienteCadastrado != null) {
            //cliente.getNome() é o que está vindo na tela
            clienteCadastrado.setNome(cliente.getNome());
            clienteCadastrado.setTel(cliente.getTel());
            clienteCadastrado.setNumero(cliente.getNumero());
            clienteCadastrado.setEnd(cliente.getEnd());
            clienteCadastrado.setCidade(cliente.getCidade());
            clienteCadastrado.setEstado(cliente.getEstado());
        }

    }

    @Override
    public Cliente consultar(Long cpf) {
        return this.map.get(cpf);
    }

    @Override
    public Collection<Cliente> buscarTodos() {
        //values() retorna uma coleção de Clientes:
        return this.map.values();
    }
}
