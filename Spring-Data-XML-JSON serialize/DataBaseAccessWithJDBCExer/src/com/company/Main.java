package com.company;

import java.sql.*;
import java.util.*;

public class Main {

    private static final String URL_NAME = "jdbc:mysql://localhost:3306/minions_db";
    private static Connection connection;
    private static Scanner scanner = new Scanner(System.in);
    private static List<String> minionInfo = new ArrayList<>();
    private static List<String> villainInfo = new ArrayList<>();

    public static void main(String[] args) throws SQLException {
        scanner = new Scanner(System.in);
        connection = getConnection();
        System.out.println("Enter exercise number:");
        int exerciseNum = Integer.parseInt(scanner.nextLine());

        switch (exerciseNum) {
            case 2 -> exTwo(connection);
            case 3 -> exThree(connection);
            case 4 -> exFour(connection);
            case 5 -> exFive(connection);
            case 7 -> exSeven(connection);
            case 8 -> exEight(connection);
            case 9 -> exNine(connection);
        }


    }

    private static void exNine(Connection connection) throws SQLException {
        System.out.println("Enter minion id: ");
        int minionId = Integer.parseInt(scanner.nextLine());
        CallableStatement callableStatement = connection.prepareCall("CALL usp_get_older(?); ");
        callableStatement.setInt(1,minionId);
        callableStatement.executeUpdate();

        Map<String,Integer> minionInfo = findMinionById(minionId);

        for (Map.Entry<String, Integer> entry : minionInfo.entrySet()) {
            System.out.print(entry.getKey());
            System.out.println(" ");
            System.out.print(entry.getValue());
        }





    }

    private static Map<String,Integer> findMinionById(int minionId) throws SQLException {
        Map<String,Integer> minionInfo = new LinkedHashMap<>();
        PreparedStatement preparedStatement
                = connection.prepareStatement("SELECT m.name , m.age FROM minions m WHERE m.id = ? ; ");
        preparedStatement.setInt(1,minionId);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            minionInfo.put(resultSet.getString("name"), resultSet.getInt("age"));
        }
        return minionInfo;
    }

    private static void exEight(Connection connection) throws SQLException {
        System.out.println("Enter minion's ID's");
        List<Integer> minionId = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).toList();

        for (Integer id : minionId) {
            updateMinions(id);
        }
         Map<String, Integer> allMinionsInfo = allMinions();

        for (Map.Entry<String, Integer> entry : allMinionsInfo.entrySet()) {
            System.out.print(entry.getKey());
            System.out.print(" ");
            System.out.print(entry.getValue());
            System.out.println();
        }

    }

    private static Map<String,Integer> allMinions() throws SQLException {
        Map<String,Integer> minionsInfoo = new LinkedHashMap<>();
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM minions");
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()){
            minionsInfoo.put(resultSet.getString("name"), resultSet.getInt("age"));
        }

        return minionsInfoo;
    }

    private static void updateMinions( Integer id) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("UPDATE minions as m " +
                "SET m.name = LOWER(m.name) , m.age = m.age + 1 " +
                "WHERE m.id = ?; ");
        preparedStatement.setInt(1,id);
        preparedStatement.executeUpdate();
    }


    private static void exSeven(Connection connection) throws SQLException {

        List<String> allMinions = findAllMinions();

        for (int first = 0, last = allMinions.size() - 1; first <= last; first++, last--) {
            System.out.println(allMinions.get(first));
            if (first != last) {
                System.out.println(allMinions.get(last));
            }
        }


    }

    private static List<String> findAllMinions() throws SQLException {
        List<String> minionNames = new ArrayList<>();
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT m.name FROM minions m ;");
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            minionNames.add(resultSet.getString("name"));
        }

        return minionNames;
    }

    private static void exFive(Connection connection) throws SQLException {
        System.out.println("Enter country name: ");
        String countryName = scanner.nextLine();
        List<String> towns = findTownsByCountry(countryName);
        if (towns.isEmpty()) {
            System.out.print("No town names were affected.");
        } else {
            makeTownsUpper(countryName);
            System.out.println(towns.size() + " town names were affected.");
            String joinedList = String.join(", ", towns);
            System.out.println(joinedList.toUpperCase());
        }

    }

    private static void makeTownsUpper(String countryName) throws SQLException {
        PreparedStatement preparedStatement =
                connection.prepareStatement("UPDATE towns SET name = UCASE(name) WHERE country = ? ; ");
        preparedStatement.setString(1, countryName);
        preparedStatement.executeUpdate();

    }

    private static List<String> findTownsByCountry(String countryName) throws SQLException {
        List<String> towns = new ArrayList<>();
        PreparedStatement preparedStatement =
                connection.prepareStatement("SELECT t.name FROM towns t WHERE country = ? ; ");
        preparedStatement.setString(1, countryName);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            towns.add(resultSet.getString("name"));
        }
        return towns;
    }

    private static void exFour(Connection connection) throws SQLException {

        System.out.println("Enter minion info:");
        minionInfo = Arrays.stream(scanner.nextLine().split("\\s+")).toList();
        System.out.println("Enter villain name:");
        villainInfo = Arrays.stream(scanner.nextLine().split("\\s+")).toList();
        String minionName = minionInfo.get(0);
        int minionAge = Integer.parseInt(minionInfo.get(1));
        String townName = minionInfo.get(2);
        int townId = getTownByname(townName);
        String villainName = villainInfo.get(0);
        if (townId == 0) {
            addTown(townName);
            System.out.printf("Town %s was added to the database.%n", townName);
        }
        townId = getTownByname(townName);
        int villainId = findVillainByName(villainName);
        if (villainId == 0) {
            addVillain(villainName);
            System.out.printf("Villain %s was added to the database.%n", villainName);
        }
        villainId = findVillainByName(villainName);
        int minionId = findMinionByName(minionName);
        if (minionId == 0) {
            addMinion(minionName, minionAge, townId);
            minionId = findMinionByName(minionName);
            AddMinionVillain(minionId, villainId);
            System.out.printf("Successfully added %s to be minion of %s.", minionName, villainName);
        }


    }

    private static void AddMinionVillain(int minionId, int villainId) throws SQLException {
        PreparedStatement preparedStatement =
                connection.prepareStatement
                        ("INSERT INTO minions_villains (minion_id, villain_id) VALUES (?, ?);");
        preparedStatement.setInt(1, minionId);
        preparedStatement.setInt(2, villainId);
        preparedStatement.executeUpdate();
    }

    private static void addMinion(String minionName, int minionAge, int townId) throws SQLException {
        PreparedStatement preparedStatement =
                connection.prepareStatement("INSERT INTO minions (name , age, town_id) VALUES (?, ?, ?);");
        preparedStatement.setString(1, minionName);
        preparedStatement.setInt(2, minionAge);
        preparedStatement.setInt(3, townId);
        preparedStatement.executeUpdate();

    }

    private static int findMinionByName(String minionName) throws SQLException {
        int id = 0;
        PreparedStatement preparedStatement =
                connection.prepareStatement("SELECT m.id FROM minions m WHERE name = ? ; ");
        preparedStatement.setString(1, minionName);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            id = resultSet.getInt("id");
        }
        return id;

    }

    private static void addVillain(String villainName) throws SQLException {
        PreparedStatement preparedStatement =
                connection.prepareStatement("INSERT INTO villains (name) VALUE (?); ");
        preparedStatement.setString(1, villainName);
        preparedStatement.executeUpdate();


    }

    private static int findVillainByName(String villainName) throws SQLException {
        int id = 0;
        PreparedStatement preparedStatement =
                connection.prepareStatement("SELECT v.id from villains v WHERE name = ? ; ");
        preparedStatement.setString(1, villainName);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            id = resultSet.getInt("id");
        }
        return id;
    }

    private static void addTown(String townName) throws SQLException {
        PreparedStatement preparedStatement =
                connection.prepareStatement("INSERT INTO towns (`name`) VALUE  (?) ; ");
        preparedStatement.setString(1, townName);
        preparedStatement.executeUpdate();
    }

    private static int getTownByname(String townName) throws SQLException {
        int id = 0;
        PreparedStatement preparedStatement =
                connection.prepareStatement("SELECT t.id from towns t WHERE t.name = ? ; ");
        preparedStatement.setString(1, townName);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            id = resultSet.getInt("id");
        }
        return id;
    }


    private static void exThree(Connection connection) throws SQLException {
        System.out.println("Enter villain ID");
        int villainID = Integer.parseInt(scanner.nextLine());
        if (villainID > 6) {
            System.out.println(System.out.printf("No villain with ID %d exists in the database.", villainID));
            return;
        }
        String villainName = findVillainNameById(villainID);
        System.out.println("Villain: " + villainName);

        PreparedStatement preparedStatement =
                connection.prepareStatement("SELECT  m.name , m.age FROM minions m " +
                        "JOIN minions_villains mv on m.id = mv.minion_id " +
                        "WHERE mv.villain_id = ? ; ");

        preparedStatement.setInt(1, villainID);
        ResultSet resultSet = preparedStatement.executeQuery();

        int counter = 0;
        while (resultSet.next()) {
            System.out.print(String.format("%d. %s %d%n", ++counter,
                    resultSet.getString("name"),
                    resultSet.getInt("age")));
        }

    }


    private static String findVillainNameById(int villainID) throws SQLException {
        PreparedStatement preparedStatement =
                connection.prepareStatement("SELECT name FROM villains WHERE id=? ;");

        preparedStatement.setInt(1, villainID);
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        return resultSet.getString("name");

    }

    private static void exTwo(Connection connection) throws SQLException {
        PreparedStatement preparedStatement =
                connection.prepareStatement("SELECT v.name , COUNT(DISTINCT mv.minion_id) as minion_count FROM villains v " +
                        "JOIN minions_villains mv on v.id = mv.villain_id " +
                        "GROUP BY v.id " +
                        "HAVING minion_count > 15; ");


        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            System.out.print("The output is: ");
            System.out.printf("%s %d %n",
                    resultSet.getString("name"),
                    resultSet.getInt("minion_count"));
        }
    }

    private static Connection getConnection() throws SQLException {
        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "root");

        return
                DriverManager.getConnection(URL_NAME, properties);

    }
}
