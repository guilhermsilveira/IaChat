package com.example.Dev.Week.Spring.Boot.adapters.out;

import com.example.Dev.Week.Spring.Boot.domain.model.Champions;
import com.example.Dev.Week.Spring.Boot.domain.ports.ChampionsRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ChampionsJdbcRepository implements ChampionsRepository {
    private final JdbcTemplate jdbcTemplate;
    private final RowMapper <Champions> rowMapper;

    public ChampionsJdbcRepository(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
        this.rowMapper = (rs, rowNum) -> new Champions(
                rs.getLong("id"),
                rs.getString("name"),
                rs.getString("role"),
                rs.getString("lore"),
                rs.getString("image_url")

        );
    }
    @Override
    public List<Champions> findAll() {
        return jdbcTemplate.query("SELECT * FROM CHAMPIONS ", rowMapper);
    }

    @Override
    public Optional<Champions> findById(Long id) {
        String sql = "SELECT * FROM CHAMPIONS WERE ID = ?";
        Champions champions = jdbcTemplate.queryForObject(sql, rowMapper, id);
        return Optional.ofNullable(champions);
    }
}
