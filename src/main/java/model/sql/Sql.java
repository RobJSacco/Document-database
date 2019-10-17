package model.sql;

import java.sql.*;

public class Sql {
  static Connection connection;

  public static void init() {
    try {
      connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/documents", "postgres", "password");
      System.out.println("Connected to PostgreSQL database!");
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }  

  }
  public static void getTags() throws SQLException {
    
    System.out.println("Reading records...");
    String[] string = new String[getCount(Table.tag)];
    
    Statement statement = connection.createStatement();
    ResultSet resultSet = statement.executeQuery("SELECT distinct title FROM tag");
    int i = 0;
    while (resultSet.next()) {
      string[i] = resultSet.getString("title");
      System.out.println(string[i]);
      i++;
    }
    
    

  }

  public static int getCount(Table table) throws SQLException {
    String tableString = null; 
    String name = null;
    switch (table) {
      case tag:
        tableString = "tag";
        name = "title";
        break;
      case data:
        tableString = "data";
        name = "name";
        break;
      case datatag:
        break;
      default:
        break;
    }
    Statement statement = connection.createStatement();
    ResultSet resultSet = statement.executeQuery(new String("SELECT COUNT(distinct "
    + name + ") FROM " + tableString));
    resultSet.next();
    System.out.println(Integer.parseInt(resultSet.getString("count")));
    return Integer.parseInt(resultSet.getString("count"));
    
  }
}

