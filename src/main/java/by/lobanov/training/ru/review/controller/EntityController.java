package by.lobanov.training.ru.review.controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.UUID;

public class EntityController {

    public Connection connection;

    public EntityController(Connection connection) {
        this.connection = connection;
    }

    public void saveEntity(Entity entity) throws IllegalArgumentException, SQLException {
        System.out.println("Start saving Entity");

        if (!validate(entity)) {
            throw new IllegalArgumentException("Entity not valid for save");
        }

        synchronized (connection) {
            Statement statement = connection.createStatement();
            boolean execute = statement.execute("INSERT INTO entity (id, name) VALUES (entity.getId(), entity.getName())");
            if (!execute) {
                throw new SQLException("Entity not saved");
            }
        }
        System.out.println("Entity is saved");
    }

    public void delete(Entity entity) throws SQLException {
        System.out.println("start");

        synchronized (connection) {
            Statement statement = connection.createStatement();
            boolean execute = statement.execute("DELETE FROM entity WHERE id=" +entity.getId());
            if (!execute) {
                throw new SQLException("No delete");
            }
        }

        System.out.println("finish");
    }

    public boolean validate(Entity entity) {
        //some code here
        return false;
    }
}

class Entity {

    private UUID id;
    private String name;

    public Entity(UUID id, String name) {
        this.id = id;
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}