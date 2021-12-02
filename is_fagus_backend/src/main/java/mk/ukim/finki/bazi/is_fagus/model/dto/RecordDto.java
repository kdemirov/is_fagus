package mk.ukim.finki.bazi.is_fagus.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecordDto {

    private Long orderId;
    private Long furnitureId;
    private Long partId;
    private Long machineId;
    private Long employeeId;
    private Integer quantity;
}
