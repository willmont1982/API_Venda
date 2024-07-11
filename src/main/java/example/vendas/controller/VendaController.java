package com.example.vendas.controller;

import com.example.vendas.model.Venda;
import com.example.vendas.service.VendaService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/vendas")
public class VendaController {
    private VendaService vendaService = new VendaService();

    @PostMapping
    public Venda registrarVenda(@RequestBody Venda venda) {
        return vendaService.registrarVenda(venda);
    }

    @GetMapping("/{id}")
    public Optional<Venda> buscarVenda(@PathVariable Long id) {
        return vendaService.buscarVenda(id);
    }

    @PutMapping("/{id}/status")
    public Venda atualizarStatus(@PathVariable Long id, @RequestBody String status) {
        return vendaService.atualizarStatus(id, status);
    }
}
