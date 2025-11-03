package com.example.tripshare.config;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class DatabaseInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

    private static final Logger logger = LoggerFactory.getLogger(DatabaseInitializer.class);

    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        createDatabaseIfNotExists();
    }

    public static void createDatabaseIfNotExists() {
        String dbName = "tripshare";
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String user = "postgres";
        String password = "admin";

        try {
            Class.forName("org.postgresql.Driver");
            
            
            Connection conn = DriverManager.getConnection(url, user, password);
            conn.setAutoCommit(true);
            Statement stmt = conn.createStatement();

            try { 
                Connection testConn = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/" + dbName, user, password);
                testConn.close();
                logger.info("✓ Banco de dados '{}' já existe!", dbName);
            } catch (Exception e) {
                try {
                    String sql = "CREATE DATABASE " + dbName + " ENCODING 'UTF8'";
                    stmt.executeUpdate(sql);
                    logger.info("✓ Banco de dados '{}' criado com sucesso!", dbName);
                } catch (Exception createErr) {
                    if (createErr.getMessage().contains("already exists")) {
                        logger.info("✓ Banco de dados '{}' já foi criado!", dbName);
                    } else {
                        throw createErr;
                    }
                }
            }

            stmt.close();
            conn.close();

        } catch (Exception e) {
            logger.error("✗ Erro ao criar banco de dados: {}", e.getMessage());
            e.printStackTrace();
            throw new RuntimeException("Falha ao criar banco de dados", e);
        }
    }
}


