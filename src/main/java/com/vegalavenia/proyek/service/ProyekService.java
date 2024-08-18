import com.vegalavenia.proyek.model.Proyek;
import com.vegalavenia.proyek.repository.ProyekRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ProyekService {

    @Autowired
    private ProyekRepository proyekRepository;

    public List<Proyek> getAllProyek() {
        return proyekRepository.findAll();
    }

    public Optional<Proyek> getProyekById(Integer id) {
        return proyekRepository.findById(id);
    }

    public Proyek createProyek(Proyek proyek) {
        // proyek.setCreatedAt(LocalDateTime.now());
        return proyekRepository.save(proyek);
    }

    public Proyek updateProyek(Integer id, Proyek proyekDetails) {
        Proyek proyek = proyekRepository.findById(id).orElseThrow(() -> new RuntimeException("Lokasi not found"));

        proyek.setNamaProyek(proyekDetails.getNamaProyek());
        proyek.setClient(proyekDetails.getClient());
        proyek.setTglMulai(proyekDetails.getTglMulai());
        proyek.setTglSelesai(proyekDetails.getTglSelesai());
        proyek.setPimpinanProyek(proyekDetails.getPimpinanProyek());
        proyek.setKeterangan(proyekDetails.getKeterangan());
        proyek.setCreatedAt(proyekDetails.getCreatedAt());

        return proyekRepository.save(proyek);
    }

    public String deleteProyek(Integer id) {
        proyekRepository.deleteById(id);
        return "Data berhasil dihapus";
    }
}