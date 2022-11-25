package sql.airport.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TicketEntity {
    private Long id;
    private String passengerNo;
    private String passengerName;
    private FlightEntity flightEntity;
    private String seatNo;
    private BigDecimal cost;
}
