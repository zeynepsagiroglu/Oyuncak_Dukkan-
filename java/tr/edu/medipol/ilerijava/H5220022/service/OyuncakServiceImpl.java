package tr.edu.medipol.ilerijava.H5220022.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tr.edu.medipol.ilerijava.H5220022.entity.Oyuncak;
import tr.edu.medipol.ilerijava.H5220022.repo.OyuncakRepository;

import java.util.List;

@Component
@Slf4j
public class OyuncakServiceImpl implements OyuncakService {

   @Autowired
    OyuncakRepository oyuncakRepository;
    @Override
    public Oyuncak ekle(Oyuncak oyuncak) {
        return oyuncakRepository.save(oyuncak) ;
    }

    @Override
    public Oyuncak getir(Long id) {
        return oyuncakRepository.getReferenceById(id);
    }

    @Override
    public void sil(Long id) {
       oyuncakRepository.deleteById(id);
    }

    @Override
    public Oyuncak guncelle(Oyuncak oyuncak) {
        return oyuncakRepository.save(oyuncak);
    }

    @Override
    public List<Oyuncak> listele() {
        return oyuncakRepository.findAll();
    }
}
