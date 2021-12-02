package mk.ukim.finki.bazi.is_fagus.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MaterialDto {

    private String name;
    private Double size;
    private Integer quantity;

}
