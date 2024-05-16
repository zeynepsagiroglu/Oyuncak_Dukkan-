package tr.edu.medipol.ilerijava.H5220022.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;
@Data
@AllArgsConstructor

public class OyuncakDto {

    private Long ID;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate alisTarihi;
    private Double alisFiyati;
    private String ad;
    private String tur;
    private Integer desi;
    private String notlar;
}
