package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	//Importa o JDBC.
   static {
      try {
         Class.forName("com.mysql.jdbc.Driver");
      }
      catch (ClassNotFoundException e) {
         throw new RuntimeException(e);
      }
   }

	//Obtem conexão com o banco de dados.
   public static Connection obtemConexao() throws SQLException {
      return DriverManager
         	.getConnection("jdbc:mysql://localhost/pratprogaula02?user=root&password=uh220799");
   }

}
