package com.example.demo.dao;

import java.lang.StackWalker.Option;
import java.sql.ResultSet;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.naming.spi.DirStateFactory.Result;

import org.springframework.jdbc.core.RowMapper;
import com.example.demo.model.Person;
import com.example.demo.dao.PersonRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.sql.SQLException;

@Repository("postgres")
public class PersonDataAccessService implements PersonDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insertPerson(UUID id, Person person) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public List<Person> selectAllPeople() {
        // TODO Auto-generated method stub
        final String sql = "SELECT id, name FROM person";
        return jdbcTemplate.query(sql, mapPersonFromDb());
        // return List.of(new Person(UUID.randomUUID(), "FROM POSTGRES DB"));
        // return person;
    }

    private RowMapper<Person> mapPersonFromDb()
    {
        return (resultSet, i) ->
            new Person(
                UUID.fromString(resultSet.getString("id")),
                resultSet.getString("name")
            );
    }

    @Override
    public Optional<Person> selectPersonById(UUID id) {
        // TODO Auto-generated method stub
        final String sql = "SELECT id, name FROM person WHERE id = ?";
        return Optional.ofNullable(jdbcTemplate.queryForObject(sql, new Object[]{id}, mapPersonFromDb()));
    }

    private RowMapper<Person> mapPersonByIdFromDb() {
        return (resultSet, i) -> 
            new Person(
                UUID.fromString(resultSet.getString("id")),
                resultSet.getString("name")
            );
    }

    @Override
    public int deletePersonById(UUID id) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int updatePersonById(UUID id, Person person) {
        // TODO Auto-generated method stub
        return 0;
    }
    
}
