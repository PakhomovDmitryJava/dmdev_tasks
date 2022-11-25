package sql.airport.DAO;

import lombok.Cleanup;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import sql.airport.DTO.TicketFilter;
import sql.airport.entity.FlightEntity;
import sql.airport.entity.TicketEntity;
import sql.airport.util.ConnectionManager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@NoArgsConstructor
public class TicketDao implements Dao<Long, TicketEntity> {
    private static final TicketDao INSTANCE = new TicketDao();

    private static final String DELETE_SQL = """
            DELETE FROM ticket
            WHERE id = ?
            """;
    private static final String SAVE_SQL = """
            INSERT INTO ticket (passenger_no, passenger_name, flight_id, seat_no, cost)
            VALUES (?, ?, ?, ?, ?);
            """;
    private static final String UPDATE_SQL = """
            UPDATE ticket
            SET
            passenger_no = ?,
            passenger_name = ?,
            flight_id = ?,
            seat_no = ?,
            cost = ?
            WHERE id = ?
            """;
    private static final String FIND_ALL_SQL = """
            SELECT ticket.id,
            passenger_no,
            passenger_name,
            flight_id,
            seat_no,
            cost,
            f.flight_no,
            f.status,
            f.aircraft_id,
            f.arrival_airport_code,
            f.arrival_date,
            f.departure_airport_code,
            f.departure_date
            FROM ticket
            join flight f
                on ticket.flight_id = f.id
            """;
    private static final String FIND_BY_ID_SQL = FIND_ALL_SQL + """
            WHERE ticket.id = ?
            """;

    public static TicketDao getInstance() {
        return INSTANCE;
    }
    private final FlightDao flightDao = FlightDao.getINSTANCE();

    @SneakyThrows
    public List<TicketEntity> findAll(TicketFilter filter) {
        List<Object> params = new ArrayList<>();
        List<String> whereSql = new ArrayList<>();
        if (filter.seatNo() != null) {
            whereSql.add("seat_no LIKE ?");
            params.add("%" + filter.seatNo() + "%");
        }
        if (filter.passengerName() != null) {
            whereSql.add("passenger_name = ?");
            params.add(filter.passengerName());
        }

        params.add(filter.limit());
        params.add(filter.offset());
        var where = whereSql.stream()
                .collect(Collectors.joining(" AND ", " where ", " LIMIT ? OFFSET ?"));

        var sql = FIND_ALL_SQL + where;
        @Cleanup var connection = ConnectionManager.get();
        @Cleanup var preparedStatement = connection.prepareStatement(sql);
        for (int i = 0; i < params.size(); i++) {
            preparedStatement.setObject(i + 1, params.get(i));
        }
        System.out.println(preparedStatement);
        var resultSet = preparedStatement.executeQuery();
        List<TicketEntity> tickets = new ArrayList<>();
        while (resultSet.next()) {
            tickets.add(buildTicket(resultSet));
        }
        return tickets;
    }

    @SneakyThrows
    public List<TicketEntity> findAll() {
        @Cleanup var connection = ConnectionManager.get();
        @Cleanup var preparedStatement = connection.prepareStatement(FIND_ALL_SQL);
        var resultSet = preparedStatement.executeQuery();
        List<TicketEntity> tickets = new ArrayList<>();
        while (resultSet.next()) {
            tickets.add(buildTicket(resultSet));
        }
        return tickets;
    }

    @SneakyThrows
    public Optional<TicketEntity> findById(Long id) {
        @Cleanup var connection = ConnectionManager.get();
        @Cleanup var preparedStatement = connection.prepareStatement(FIND_BY_ID_SQL);
        preparedStatement.setLong(1, id);
        var resultSet = preparedStatement.executeQuery();
        TicketEntity ticket = null;
        if (resultSet.next()) {
            ticket = buildTicket(resultSet);
        }

        return Optional.ofNullable(ticket);
    }

    private TicketEntity buildTicket(ResultSet resultSet) throws SQLException {
        var flight = new FlightEntity(
                resultSet.getLong("flight_id"),
                resultSet.getString("flight_no"),
                resultSet.getTimestamp("departure_date").toLocalDateTime(),
                resultSet.getString("departure_airport_code"),
                resultSet.getTimestamp("arrival_date").toLocalDateTime(),
                resultSet.getString("arrival_airport_code"),
                resultSet.getInt("aircraft_id"),
                resultSet.getString("status")
        );
        return new TicketEntity(resultSet.getLong("id"),
                resultSet.getString("passenger_no"),
                resultSet.getString("passenger_name"),
                flightDao.findById(resultSet.getLong("flight_id")).orElse(null),
                resultSet.getString("seat_no"),
                resultSet.getBigDecimal("cost"));
    }

    @SneakyThrows
    public TicketEntity save(TicketEntity ticket) {
        @Cleanup var connection = ConnectionManager.get();
        @Cleanup var preparedStatement = connection.prepareStatement(SAVE_SQL, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1, ticket.getPassengerNo());
        preparedStatement.setString(2, ticket.getPassengerName());
        preparedStatement.setLong(3, ticket.getFlightEntity().id());
        preparedStatement.setString(4, ticket.getSeatNo());
        preparedStatement.setBigDecimal(5, ticket.getCost());

        preparedStatement.executeUpdate();

        var generatedKeys = preparedStatement.getGeneratedKeys();
        if (generatedKeys.next()) {
            ticket.setId(generatedKeys.getLong("id"));
        }
        return ticket;
    }

    @SneakyThrows
    public boolean delete(Long id) {
        @Cleanup var connection = ConnectionManager.get();
        @Cleanup var preparedStatement = connection.prepareStatement(DELETE_SQL);
        preparedStatement.setLong(1, id);
        return preparedStatement.executeUpdate() > 0;
    }


    @SneakyThrows
    public void update(TicketEntity ticket) {
        @Cleanup var connetcion = ConnectionManager.get();
        @Cleanup var preparedStatement = connetcion.prepareStatement(UPDATE_SQL);
        preparedStatement.setString(1, ticket.getPassengerNo());
        preparedStatement.setString(2, ticket.getPassengerName());
        preparedStatement.setLong(3, ticket.getFlightEntity().id());
        preparedStatement.setString(4, ticket.getSeatNo());
        preparedStatement.setBigDecimal(5, ticket.getCost());
        preparedStatement.setLong(6, ticket.getId());

        preparedStatement.executeUpdate();
    }
}
