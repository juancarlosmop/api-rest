package com.example.api.controller;

import com.example.api.model.dto.ClientDTO;
import com.example.api.model.dto.UserDTO;
import com.example.api.model.dto.response.GeneralResponseDTO;
import com.example.api.service.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1/client")
public class ClientController {
    @Autowired
    private IClientService iClientService;

    @GetMapping
    public ResponseEntity<GeneralResponseDTO> getAllClients() {
        return ResponseEntity.ok( iClientService.getAllClients());
    }

    @GetMapping("/{id}")
    public ResponseEntity<GeneralResponseDTO> getClientById(@PathVariable Long id) {
        return ResponseEntity.ok(iClientService.getClientById(id));
    }

    @PostMapping("/register")
    public ResponseEntity<GeneralResponseDTO>  createClient(@RequestBody @Valid ClientDTO client) {
        return ResponseEntity.ok(iClientService.saveClient(client));
    }

    @PutMapping("/{id}")
    public ResponseEntity<GeneralResponseDTO>  updateClientById(@PathVariable Long id, @RequestBody @Valid ClientDTO client) {
        return ResponseEntity.ok( iClientService.updateClient(id,client));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<GeneralResponseDTO> deleteClientById(@PathVariable Long id) {
        return ResponseEntity.ok( iClientService.deleteClient(id));
    }
}
