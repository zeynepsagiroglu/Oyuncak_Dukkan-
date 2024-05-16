package tr.edu.medipol.ilerijava.H5220022;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tr.edu.medipol.ilerijava.H5220022.entity.Oyuncak;
import tr.edu.medipol.ilerijava.H5220022.repo.OyuncakRepository;

import java.time.LocalDate;

@SpringBootApplication
public class H5220022Application implements CommandLineRunner {


	@Autowired
	OyuncakRepository oyuncakRepository;
	public static void main(String[] args) {
		SpringApplication.run(H5220022Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Oyuncak oyuncak = new Oyuncak();
		oyuncak.setAlisTarihi(LocalDate.now());
		oyuncak.setAlisFiyati(30.33);
		oyuncak.setAd("köpekçik");
		oyuncak.setTur("peluş");
		oyuncak.setDesi(3);
		oyuncak.setNotlar("eğitici");
		oyuncakRepository.save(oyuncak);

	}
}
