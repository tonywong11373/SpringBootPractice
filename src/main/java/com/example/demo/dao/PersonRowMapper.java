package com.example.demo.dao;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

import com.example.demo.model.Person;

public class PersonRowMapper implements RowMapper<Person> {
    @Override
    public Person mapRow(ResultSet rs, int rowNum) throws SQLException{
        Person person = new Person(UUID.fromString(rs.getString("id")), rs.getString("name"));
        return person;
    }
}
