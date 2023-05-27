package dao;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;

import model.Tarefa;

public class TarefaDao {
	 
	public int registerTask( String titulo, String descrcao) throws ClassNotFoundException {
	        String INSERT_USERS_SQL = "INSERT INTO tarefas" +
	            "  (titulo, descricao) VALUES " +
	            " (?, ?);";

	        int result = 0;

	        Class.forName("com.mysql.jdbc.Driver");

	        try (Connection connection = (Connection) DriverManager
	            .getConnection("jdbc:mysql://localhost:3306/tasklist", "root", "");

	            // Step 2:Create a statement using connection object
	            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(INSERT_USERS_SQL)) {
	        	preparedStatement.setString(1, titulo);
	            preparedStatement.setString(2, descrcao);
	   

	            System.out.println(preparedStatement);
	            // Step 3: Execute the query or update query
	            result = preparedStatement.executeUpdate();

	        } catch (SQLException e) {
	            // process sql exception
	            e.printStackTrace();
	        }
	        return result;
	    }




	public Tarefa getId(int id) throws ClassNotFoundException {
		   String LOG_USERS_SQL = "SELECT (id) FROM tarefas" +
	        		" WHERE id=?";

		   Tarefa task = null;

	        Class.forName("com.mysql.jdbc.Driver");

	        try (Connection connection = (Connection) DriverManager
	            .getConnection("jdbc:mysql://localhost:3306/tasklist", "root", "");

	            // Step 2:Create a statement using connection object
	            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(LOG_USERS_SQL)) {
	            preparedStatement.setInt(1, id);

	            System.out.println(preparedStatement);
	            try (ResultSet resultSet = (ResultSet) preparedStatement.executeQuery();) {
	            	if(resultSet.next()) {
	            		task = new Tarefa();
	            		task.setId(id);
	            		task.setTitulo(resultSet.getString("titulo"));
	            		task.setDescriacao(resultSet.getString("descricao"));
	            		task.setData_criacao(resultSet.getString("data_craicao"));
	            		task.setData_conclusao(resultSet.getString("data_conclusao"));
	            		task.setStatus(resultSet.getString("status"));


	            	}
	            } catch (SQLException e) {
		            // process sql exception
		            e.printStackTrace();
		        }
		            

	        } catch (SQLException e) {
	            // process sql exception
	            e.printStackTrace();
	        }
	        
	        return task;
	}
	
	
	
}
