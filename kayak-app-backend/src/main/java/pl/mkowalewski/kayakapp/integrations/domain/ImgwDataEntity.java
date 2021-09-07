package pl.mkowalewski.kayakapp.integrations.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;
import lombok.Data;

@Data
class ImgwDataEntity {
  private Long id_stacji;
  private String stacja;
  private String rzeka;
  private String województwo;

  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private LocalDateTime stan_wody_data_pomiaru;
  private Integer stan_wody;

  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private LocalDateTime temperatura_wody_data_pomiaru;
  private Double temperatura_wody;

  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private LocalDateTime zjawisko_lodowe_data_pomiaru;
  private Integer zjawisko_lodowe;

  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private LocalDateTime zjawisko_zarastania_data_pomiaru;
  private Integer zjawisko_zarastania;
}
