/*package com.journaldev.dao;

import com.journaldev.model.Books;*/

import java.util.List;

public interface ClienteDao {

    public void addCliente(Cliente cliente);

    public void printClientes();

    public void delCliente(int idCliente);

    public void updateCliente(int idCliente, Cliente cliente);
}