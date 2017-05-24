/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.model;

import br.edu.model.DAO.DAOGenerico;
import br.edu.model.entidades.Produto;
import java.util.List;

/**
 *
 * @author Igor Sousa
 */
public class ProdutoModel implements DAOGenerico<Produto> {

    @Override
    public void InsertOrUpdate(Object o) {
    }

    @Override
    public void Delet(int i) {
    }

    @Override
    public void Read(int i) {
    }

    @Override
    public List ListAll() {
        return null;
    }
}

