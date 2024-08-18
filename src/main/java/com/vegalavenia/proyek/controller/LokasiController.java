package com.vegalavenia.proyek.controller;

import com.vegalavenia.proyek.model.Lokasi;
import com.vegalavenia.proyek.repository.LokasiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/lokasi")
public class LokasiController {

    @Autowired
    private LokasiRepository lokasiRepository;

    @GetMapping
    public List<Lokasi> getAllLokasi() {
        // return "Get All"
        return lokasiRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Lokasi> getLokasiById(@PathVariable Integer id) {
        Optional<Lokasi> lokasi = lokasiRepository.findById(id);
        return lokasi.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Lokasi> createLokasi(@RequestBody Lokasi lokasi) {
        Lokasi savedLokasi = lokasiRepository.save(lokasi);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedLokasi);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Lokasi> updateLokasi(@PathVariable Integer id, @RequestBody Lokasi lokasi) {
        if (!lokasiRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        lokasi.setId(id);
        Lokasi updatedLokasi = lokasiRepository.save(lokasi);
        return ResponseEntity.ok(updatedLokasi);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteLokasi(@PathVariable Integer id) {
        if (!lokasiRepository.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("lokasi tidak ditemukan.");
        }
        lokasiRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("lokasi berhasil dihapus.");
    }
}