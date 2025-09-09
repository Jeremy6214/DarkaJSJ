package com.darkai.backend.controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private static final String URL = "http://localhost/phpmyadmin/index.php?route=/database/structure&db=darkaischool";
    private static final String USER = "root";      // cambia si usas otro usuario
    private static final String PASSWORD = "";      // pon tu contraseña si tienes

    public static Connection getConexion() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("✅ Conexión exitosa a la base de datos.");
        } catch (SQLException e) {
            System.out.println("❌ Error al conectar: " + e.getMessage());
        }
        return conn;
    }
}