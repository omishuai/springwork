package com.shuaih.springTest;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.*;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;


public class Connector {

    private JdbcTemplate jdbc;
    private NamedParameterJdbcTemplate namedJdbc;

    @Autowired  //setter method for jdbc
    public void setDataSource(DataSource jdbc) {
        this.jdbc = new JdbcTemplate(jdbc);

        // using parameter in the query
        this.namedJdbc = new NamedParameterJdbcTemplate(jdbc);
    }


    String sql = "CREATE TABLE profiles " +
            " (firstName VARCHAR(255), " +
            " lastName VARCHAR(255), " +
            " age INTEGER)";

    void createTale (){
        jdbc.execute(sql);
    }

    boolean addProfile(Profile p) {
        System.out.println(p);
        BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(p);
        System.out.println(params.toString());
        return namedJdbc.update(
                "insert into profiles (firstName, lastName, age) values(:firstName, :lastName, :age)",
                params) == 1;
    }

    @Transactional
    int[] addProfiles(List<Profile> profiles) {
        SqlParameterSource[] params = SqlParameterSourceUtils.createBatch(profiles.toArray());
        int[] res = namedJdbc.batchUpdate(
                "insert into profiles (firstName, lastName, age) values(:firstName, :lastName, :age)",
                params);
        return res;
    }
    // using regular query
    public  List<Profile> getProfiles() {

        List<Profile> profiles = jdbc.query("select * from profiles", new RowMapper<Profile>() {

            public Profile mapRow(ResultSet rs, int i) throws SQLException {
                Profile  p = new Profile(rs.getString("firstName"), rs.getString("lastName"), rs.getInt("age"));
                return p;
            }
        });
        if (profiles.size() == 0) {
            System.out.println("there are no profiles in the database");
        }
        return profiles;
    }

    // using named parameter
    public Profile getProfile(int id){
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", 1);
        Profile p = namedJdbc.queryForObject("select * from testTable where id = :id", params, new RowMapper<Profile>() {
            public Profile mapRow(ResultSet resultSet, int i) throws SQLException {
                return null;
            }
        });
        return p;
    }



//    @Autowired
//    public void setUser(@Value("${jdbc.user}")String str) {
//        user = str;
//    }
//    @Autowired
//    public void setPassword(@Value("${jdbc.password}") String pass) {
//        password = pass;
//    }

//    public String toString(){
//        return
//    }

    public void init(){
        System.out.println("Connector Created");
    }
}
