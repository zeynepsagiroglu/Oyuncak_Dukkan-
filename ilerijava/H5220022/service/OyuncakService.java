package tr.edu.medipol.ilerijava.H5220022.service;

import org.springframework.stereotype.Service;
import tr.edu.medipol.ilerijava.H5220022.entity.Oyuncak;

import java.util.List;

@Service
public interface OyuncakService {

    Oyuncak ekle ( Oyuncak oyuncak);
    Oyuncak getir(Long id);
    void sil(Long id);
    Oyuncak guncelle(Oyuncak oyuncak);
    List<Oyuncak>listele();

}
