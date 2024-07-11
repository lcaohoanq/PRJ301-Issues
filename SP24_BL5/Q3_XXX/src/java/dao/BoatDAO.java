package dao;

import dal.DBContext;
import dto.BoatDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BoatDAO extends DBContext {

	private static final String QUERY_ALL_DEPARTURE_PLACES
			= "SELECT b.BoatID, b.BoatName, b.Seat, b.Booked, dp.DepartPlaceName, tk.TicketName "
			+ "FROM Boats b "
			+ "JOIN DepartPlaces dp ON b.DepartPlaceID = dp.DepartPlaceID "
			+ "JOIN Tickets tk ON b.TicketID = tk.TicketID";

	public List<BoatDTO> getAllDeparturePlaces() {
		List<BoatDTO> boats = new ArrayList<>();

		try {
//			Connection connection = new DBContext().getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_ALL_DEPARTURE_PLACES);
                        //SELECT => executeQuery
                        //INSERT, UPDATE, DELETE,=> executeUpdate
                        ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				BoatDTO boat = new BoatDTO();
				boat.setBoatID(resultSet.getString("BoatID"));
				boat.setBoatName(resultSet.getString("BoatName"));
				boat.setSeat(resultSet.getInt("Seat"));
				boat.setBooked(resultSet.getInt("Booked"));
				boat.setDepartPlaceName(resultSet.getString("DepartPlaceName"));
				boat.setTicketName(resultSet.getString("TicketName"));

				boats.add(boat);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return boats;
	}

	public static void main(String[] args) {
		for (BoatDTO boat : new BoatDAO().getAllDeparturePlaces()) {
			System.out.println(boat);
		}
	}

}
