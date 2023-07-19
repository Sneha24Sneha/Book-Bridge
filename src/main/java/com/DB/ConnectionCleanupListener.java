package com.DB;

import java.sql.Connection;
import java.sql.SQLException;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ConnectionCleanupListener implements ServletContextListener {

    @Override
    public void contextDestroyed(ServletContextEvent event) {
        // Close all database connections here
        try {
            Connection conn = DBConnect.getConnection();
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        } catch (ClassNotFoundException | SQLException e) {
            // Handle the exception appropriately
        }
    }

    @Override
    public void contextInitialized(ServletContextEvent event) {
        // Do nothing
    }
}
