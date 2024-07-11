package com.example.vendas.repository;

import com.example.vendas.model.Venda;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class VendaRepository {
    private List<Venda> vendas = new ArrayList<>();
    private Long nextId = 1L;

    public Venda save(Venda venda) {
        venda.setId(nextId++);
        vendas.add(venda);
        return venda;
    }

    public Optional<Venda> findById(Long id) {
        return vendas.stream().filter(v -> v.getId().equals(id)).findFirst();
    }

    public Venda updateStatus(Long id, String status) {
        Optional<Venda> vendaOptional = findById(id);
        if (vendaOptional.isPresent()) {
            Venda venda = vendaOptional.get();
            venda.setStatus(status);
            return venda;
        }
        return null;
    }
}
