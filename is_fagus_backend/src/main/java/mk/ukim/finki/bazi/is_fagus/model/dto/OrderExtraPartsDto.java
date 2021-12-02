package mk.ukim.finki.bazi.is_fagus.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderExtraPartsDto {

    private Long orderId;
    private Long partId;
    private Integer quantity;
}
