package com.traffic.poc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class TrafficConfigJdbcRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    class ConfigRowMapper implements RowMapper<TrafficConfig> {
        @Override
        public TrafficConfig mapRow(ResultSet rs, int rowNum) throws SQLException {
            TrafficConfig config = new TrafficConfig();
            config.setId(rs.getLong("id"));
            config.setDay(rs.getString("day"));
            config.setStartTime(rs.getTime("starttime"));
            config.setEndTime(rs.getTime("endtime"));
            return config;
        }

    }

    public List<TrafficConfig> findAll() {
        return jdbcTemplate.query("select * from trafficconfig", new ConfigRowMapper());
    }

    public TrafficConfig findById(long id) {
        return jdbcTemplate.queryForObject("select * from trafficconfig where id=?", new Object[] { id },
                new BeanPropertyRowMapper<TrafficConfig>(TrafficConfig.class));
    }

    public int deleteById(long id) {
        return jdbcTemplate.update("delete from trafficconfig where id=?", new Object[] { id });
    }

    public int insert(TrafficConfig config) {
        return jdbcTemplate.update("insert into trafficconfig (id, day, starttime, endtime) " + "values(?, ?, ?, ?)",
                new Object[] { config.getId(), config.getDay(), config.getStartTime(), config.getEndTime() });
    }

    public int update(TrafficConfig config) {
        return jdbcTemplate.update("update trafficconfig " + " set day = ?, starttime = ?, endtime = ? " + " where id = ?",
                new Object[] { config.getDay(), config.getStartTime(), config.getEndTime(), config.getId() });
    }

}