package tr.edu.medipol.ilerijava.H5220022.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tr.edu.medipol.ilerijava.H5220022.dto.OyuncakDto;
import tr.edu.medipol.ilerijava.H5220022.entity.Oyuncak;
import tr.edu.medipol.ilerijava.H5220022.service.OyuncakService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
public class Controller {

    @Autowired
    OyuncakService oyuncakService;

    @PostMapping("/ekle")
    public String ekle(@RequestBody OyuncakDto oyuncakDto) {
        log.info("Ekle servisi şu tarihte çağrıldı: "+ LocalDateTime.now());
        Oyuncak oyuncak = new Oyuncak();
        oyuncak.setAlisTarihi(oyuncakDto.getAlisTarihi());
        oyuncak.setAlisFiyati(oyuncakDto.getAlisFiyati());
        oyuncak.setAd(oyuncakDto.getAd());
        oyuncak.setTur(oyuncakDto.getTur());
        oyuncak.setDesi(oyuncakDto.getDesi());
        oyuncak.setNotlar(oyuncakDto.getNotlar());
        Oyuncak eklenmisOyuncak = oyuncakService.ekle(oyuncak);
        return eklenmisOyuncak.getAd()+" adında yeni bir oyuncak eklendi";
    }

    @GetMapping("/getir")
    public OyuncakDto getir(Long id){
        log.info("Getir servisi şu tarihte çağrıldı: "+ LocalDateTime.now());
        Oyuncak oyuncak = oyuncakService.getir(id);
        OyuncakDto oyuncakDto = new OyuncakDto(oyuncak.getID(), oyuncak.getAlisTarihi(), oyuncak.getAlisFiyati(), oyuncak.getAd(), oyuncak.getTur(), oyuncak.getDesi(), oyuncak.getNotlar());

        return oyuncakDto;
    }

    @PutMapping("/guncelle{id}")
    public OyuncakDto guncelle(@PathVariable Long id, @RequestBody OyuncakDto oyuncakDto){
        log.info("Güncelle servisi şu tarihte çağrıldı: "+ LocalDateTime.now());
        Oyuncak oyuncak = oyuncakService.getir(id);
        oyuncak.setAlisTarihi(oyuncakDto.getAlisTarihi());
        oyuncak.setAlisFiyati(oyuncakDto.getAlisFiyati());
        oyuncak.setAd(oyuncakDto.getAd());
        oyuncak.setTur(oyuncakDto.getTur());
        oyuncak.setDesi(oyuncakDto.getDesi());
        oyuncak.setNotlar(oyuncakDto.getNotlar());
        oyuncakService.guncelle(oyuncak);
        return new OyuncakDto(oyuncak.getID(),oyuncak.getAlisTarihi(), oyuncak.getAlisFiyati(),oyuncak.getAd(),oyuncak.getTur(),oyuncak.getDesi(),oyuncak.getNotlar());

    }

    @DeleteMapping("/sil")
    public String sil(Long id){
        log.info("Sil servisi şu tarihte çağrıldı: "+ LocalDateTime.now());
        oyuncakService.sil(id);
        return "kullanıcı silindi!";
    }

    @GetMapping("/listele")
    public List<OyuncakDto> listele(){
        log.info("Listele servisi şu tarihte çağrıldı: "+ LocalDateTime.now());
        List<Oyuncak> oyuncakListesi =  oyuncakService.listele();
      List<OyuncakDto> tumOyuncaklar = new ArrayList<>();
      for (Oyuncak oyuncaklar : oyuncakListesi){
          OyuncakDto oyuncaklarDto = new OyuncakDto(oyuncaklar.getID(),oyuncaklar.getAlisTarihi(), oyuncaklar.getAlisFiyati(),oyuncaklar.getAd(),oyuncaklar.getTur(),oyuncaklar.getDesi(),oyuncaklar.getNotlar());
          tumOyuncaklar.add(oyuncaklarDto);
      }
      return tumOyuncaklar;
    }
}
