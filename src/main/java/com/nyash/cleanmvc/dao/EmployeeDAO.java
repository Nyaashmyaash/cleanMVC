package com.nyash.cleanmvc.dao;

import com.nyash.cleanmvc.models.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmployeeDAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public EmployeeDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Employee> index() {
        return jdbcTemplate.query("SELECT * FROM person", new BeanPropertyRowMapper<>(Employee.class));
    }

    public Employee show(int id) {
        return jdbcTemplate.query("SELECT * FROM person WHERE id=?",
                new Object[]{id}, new BeanPropertyRowMapper<>(Employee.class)).stream().findAny().orElse(null);
    }

    public void save(Employee employee) {
        jdbcTemplate.update("INSERT INTO person VALUES (1, ?, ?, ?)", employee.getName(), employee.getAge(),
                employee.getEmail());
    }

    public void update(int id, Employee updatedEmployee) {
        jdbcTemplate.update("UPDATE person SET name=?, age=?, email=? WHERE id=?", updatedEmployee.getName(),
                updatedEmployee.getAge(), updatedEmployee.getEmail(), updatedEmployee.getId());
    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM person WHERE id=?", id);
    }
}
