/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package florist;

import java.sql.SQLException;
import java.sql.Statement;

public class florist extends database {
    public String ID;
    public String name;
    public int stock;
    public String color;
    public int  priceStalk;
    public int priceDozen;

    public String getID() {
        return this.ID;
    }

    public boolean create() {
        boolean operationSuccessful = false;

        try {
            openConnection();

            String sql = "INSERT INTO flower VALUES (?, ?, ?, ?, ?, ?)";
            preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1, ID);
            preparedStatement.setString(2, name);
            preparedStatement.setInt(3, stock);
            preparedStatement.setString(4, color);
            preparedStatement.setInt(5, priceStalk);
            preparedStatement.setInt(6, priceDozen);

            int rowsAffected = this.preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                operationSuccessful = true;
            }

        } catch (SQLException ex) {
            displayErrors(ex);
        } finally {
            closeConnection();
        }

        return operationSuccessful;
    }

    public boolean update() {
        boolean isOperationSuccess = false;

        try {
            this.openConnection();

            String sql = "UPDATE flower SET ID = ?, Stock = ?,  Price_stalk = ?,  Price_Dozen = ? WHERE ID = ?";
            preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1, ID);
            preparedStatement.setInt(2, stock);
            preparedStatement.setInt(3, priceStalk);
            preparedStatement.setInt(4, priceDozen);
            preparedStatement.setString(5, ID);

            int rowsAffected = this.preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                isOperationSuccess = true;
            }

        } catch (SQLException ex) {
            displayErrors(ex);
        } finally {
            closeConnection();
        }

        return isOperationSuccess;
    }

    public boolean delete() {
        boolean isOperationSuccess = false;

        try {
            this.openConnection();

            String sql = "DELETE FROM flower WHERE ID = ?";
            this.preparedStatement = this.connection.prepareStatement(sql);
            this.preparedStatement.setString(1, this.ID);

            int result = this.preparedStatement.executeUpdate();

            isOperationSuccess = result > 0;
        } catch (SQLException ex) {
            this.displayErrors(ex);
        } finally {
            this.closeConnection();
        }

        return isOperationSuccess;
    }
}

