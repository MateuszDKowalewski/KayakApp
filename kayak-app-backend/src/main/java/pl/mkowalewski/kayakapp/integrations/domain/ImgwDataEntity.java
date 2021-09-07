package pl.mkowalewski.kayakapp.integrations.domain;

import lombok.Data;

@Data
class ImgwDataEntity {
  private Long id_stacji;
  private String stacja;
  private String rzeka;
  private String województwo;
  private Integer stan_wody;
  // TODO: add date time format
  private String stan_wody_data_pomiaru; // LocalDateTime
  private Double temperatura_wody;
  // TODO: add date time format
  private String temperatura_wody_data_pomiaru; // LocalDateTime
  private Integer zjawisko_lodowe;
  // TODO: add date time format
  private String zjawisko_lodowe_data_pomiaru; // LocalDateTime
  private Integer zjawisko_zarastania;
  // TODO: add date time format
  private String zjawisko_zarastania_data_pomiaru; // LocalDateTime
}
