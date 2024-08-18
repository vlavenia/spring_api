package com.vegalavenia.proyek.repository;

import com.vegalavenia.proyek.model.Proyek;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProyekRepository extends JpaRepository<Proyek, Integer> {
}