package sql.airport.DTO;

public record TicketFilter(int limit, int offset, String passengerName, String seatNo) {

}
