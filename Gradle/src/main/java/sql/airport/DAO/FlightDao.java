package sql.airport.DAO;

import lombok.Cleanup;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import sql.airport.entity.FlightEntity;
import sql.airport.util.ConnectionManager;

import java.util.List;
import java.util.Optional;

@NoArgsConstructor
public class FlightDao implements Dao<Long, FlightEntity> {

    @Getter
    public static final FlightDao INSTANCE = new FlightDao();

    public static final String FIND_BY_ID_SQL = """
            select id,
            flight_no,
            status,
            aircraft_id,
            arrival_airport_code,
            arrival_date,
            departure_airport_code,
            departure_date
            from flight
            where id = ?
            """;

    @Override
    public boolean delete(Long id) {
        return false;
    }

    @Override
    public FlightEntity save(FlightEntity entity) {
        return null;
    }

    @Override
    public void update(FlightEntity entity) {

    }

    @Override
    @SneakyThrows()
    public Optional<FlightEntity> findById(Long id) {
        @Cleanup var connection = ConnectionManager.get();
        @Cleanup var preparedStatement = connection.prepareStatement(FIND_BY_ID_SQL);

        preparedStatement.setLong(1, id);

        var resultSet = preparedStatement.executeQuery();

        FlightEntity flight = null;
        if (resultSet.next()) {
            flight = new FlightEntity(resultSet.getLong("id"),
                    resultSet.getString("flight_no"),
                    resultSet.getTimestamp("departure_date").toLocalDateTime(),
                    resultSet.getString("departure_airport_code"),
                    resultSet.getTimestamp("arrival_date").toLocalDateTime(),
                    resultSet.getString("arrival_airport_code"),
                    resultSet.getInt("aircraft_id"),
                    resultSet.getString("status"));
        }
        return Optional.ofNullable(flight);
    }

    @Override
    public List<FlightEntity> findAll() {
        return null;
    }
}
