package com.vegalavenia.proyek.controller;

import com.vegalavenia.proyek.model.Proyek;
import com.vegalavenia.proyek.repository.ProyekRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/proyek")
public class ProyekController {

    @Autowired
    private ProyekRepository proyekRepository;

    @GetMapping
    public List<Proyek> getAllProyek() {
        // return "Get All"
        return proyekRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Proyek> getProyekById(@PathVariable Integer id) {
        Optional<Proyek> proyek = proyekRepository.findById(id);
        return proyek.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Proyek> createProyek(@RequestBody Proyek proyek) {
        Proyek savedProyek = proyekRepository.save(proyek);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedProyek);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Proyek> updateProyek(@PathVariable Integer id, @RequestBody Proyek proyek) {
        if (!proyekRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        proyek.setId(id);
        Proyek updatedProyek = proyekRepository.save(proyek);
        return ResponseEntity.ok(updatedProyek);
    }

   @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProyek(@PathVariable Integer id) {
        if (!proyekRepository.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("proyek tidak ditemukan.");
        }
        proyekRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("proyek berhasil dihapus.");
    }
}