package com.example.vendas.service;

import com.example.vendas.model.Venda;
import com.example.vendas.repository.VendaRepository;
import java.util.Optional;

public class VendaService {
    private VendaRepository vendaRepository = new VendaRepository();

    public Venda registrarVenda(Venda venda) {
        venda.setStatus("Aguardando pagamento");
        return vendaRepository.save(venda);
    }

    public Optional<Venda> buscarVenda(Long id) {
        return vendaRepository.findById(id);
    }

    public Venda atualizarStatus(Long id, String status) {
        // Validação das transições de status
        Optional<Venda> vendaOptional = vendaRepository.findById(id);
        if (vendaOptional.isPresent()) {
            Venda venda = vendaOptional.get();
            String currentStatus = venda.getStatus();
            if ((currentStatus.equals("Aguardando pagamento") && (status.equals("Pagamento Aprovado") || status.equals("Cancelada"))) ||
                (currentStatus.equals("Pagamento Aprovado") && (status.equals("Enviado para Transportadora") || status.equals("Cancelada"))) ||
                (currentStatus.equals("Enviado para Transportadora") && status.equals("Entregue"))) {
                return vendaRepository.updateStatus(id, status);
            }
        }
        return null;
    }
}
