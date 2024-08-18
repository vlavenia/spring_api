//hanya fokus pada fungsi-fungsi yang akan digunakan
//bikin interface JpaRepository spy bs digunakan di controller
//untuk mnghubungkan model dgn controller
package com.vegalavenia.proyek.repository;

import com.vegalavenia.proyek.model.Lokasi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LokasiRepository extends JpaRepository<Lokasi, Integer> {
}