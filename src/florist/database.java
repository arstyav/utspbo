package florist;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

    public class database {
        Connection connection = null;
        private Statement statement = null;
        PreparedStatement preparedStatement = null;
        private ResultSet resultSet = null;

        public database() {
            this.openConnection();
        }

        public final void openConnection() {
            try {
                String url = "jdbc:mysql://localhost:3306/florist";
                String user = "root";
                String pass = "";

                this.connection = DriverManager.getConnection(url, user, pass);
                this.statement = this.connection.createStatement();

                System.out.println("Connected to the database");
                
            } catch (SQLException ex) {
                this.displayErrors(ex);
            }
        }


        public final void closeConnection() {
            try {
                if (this.resultSet != null) this.resultSet.close();
                if (this.statement != null) this.statement.close();
                if (this.preparedStatement != null) this.preparedStatement.close();
                if (this.connection != null) this.connection.close();

                this.resultSet = null;
                this.statement = null;
                this.preparedStatement = null;
                this.connection = null;
            } catch (SQLException ex) {
                this.displayErrors(ex);
            }
        }

        public ResultSet executeSelectQuery(String query) throws SQLException {
            this.resultSet = this.statement.executeQuery(query);
            return this.resultSet;
        }

        public void execute(String query) throws SQLException {
            this.statement.execute(query);
        }

        public final ArrayList<ArrayList<String>> all(String query) {
            ArrayList<ArrayList<String>> rows = new ArrayList<>();

            try {
                this.resultSet = this.statement.executeQuery(query);

                while (this.resultSet.next()) {
                    int columnCount = this.resultSet.getMetaData().getColumnCount();
                    ArrayList<String> columns = new ArrayList<>();

                    for (int i = 1; i <= columnCount; i++) {
                        columns.add(this.resultSet.getString(i));
                    }
                    rows.add(columns);
                }
            } catch (SQLException e) {
                this.displayErrors(e);
            } finally {
                try {
                    if (this.resultSet != null) this.resultSet.close();
                } catch (SQLException ex) {
                    this.displayErrors(ex);
                }
            }
            return rows;
        }

        protected final void displayErrors(SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        
        public static void main(String[] args) {
        database db = new database();
        }
    
}