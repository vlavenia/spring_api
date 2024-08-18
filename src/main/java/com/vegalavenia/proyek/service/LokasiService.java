import com.vegalavenia.proyek.model.Lokasi;
import com.vegalavenia.proyek.repository.LokasiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class LokasiService {

    @Autowired
    private LokasiRepository lokasiRepository;

    public List<Lokasi> getAllLokasi() {
        return lokasiRepository.findAll();
    }

    public Optional<Lokasi> getLokasiById(Integer id) {
        return lokasiRepository.findById(id);
    }

    public Lokasi createLokasi(Lokasi lokasi) {
        lokasi.setCreatedAt(LocalDateTime.now());
        return lokasiRepository.save(lokasi);
    }

    public Lokasi updateLokasi(Integer id, Lokasi lokasiDetails) {
        Lokasi lokasi = lokasiRepository.findById(id).orElseThrow(() -> new RuntimeException("Lokasi not found"));

        lokasi.setNamaLokasi(lokasiDetails.getNamaLokasi());
        lokasi.setNegara(lokasiDetails.getNegara());
        lokasi.setProvinsi(lokasiDetails.getProvinsi());
        lokasi.setKota(lokasiDetails.getKota());

        return lokasiRepository.save(lokasi);
    }

    public void deleteLokasi(Integer id) {
        lokasiRepository.deleteById(id);
    }
}