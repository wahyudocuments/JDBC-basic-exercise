package com.sgiasia.javaspringboot.jdbcbasic.helper;

import com.sgiasia.javaspringboot.jdbcbasic.config.dbconfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author preetham
 */
public class JDBCHelper
{
    private static Connection connection;

    static
    {
        try
        {
            Class.forName( dbconfig.DRIVER_NAME );
        }
        catch ( ClassNotFoundException e )
        {
            System.out.println( "Driver class not found" );
        }
    }

    public static Connection getConnection() throws SQLException
    {
        connection = DriverManager.getConnection( dbconfig.URL, dbconfig.USERNAME, dbconfig.PASSWORD );
        return connection;
    }

    public static void closeConnection( Connection con ) throws SQLException
    {
        if ( con != null )
        {
            con.close();
        }
    }

    public static void closePrepaerdStatement( PreparedStatement stmt ) throws SQLException
    {
        if ( stmt != null )
        {
            stmt.close();
        }
    }

    public static void closeResultSet( ResultSet rs ) throws SQLException
    {
        if ( rs != null )
        {
            rs.close();
        }
    }

}

