package gitHubApi.DBHelper;

import org.springframework.jdbc.core.JdbcTemplate;

public class RepoDbClient {
    private final JdbcTemplate jdbcTemplate;

    public RepoDbClient(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public boolean existsById(String id) {
        Integer count = jdbcTemplate.queryForObject(
                "SELECT COUNT(*) FROM repos WHERE id = ?",
                Integer.class,
                id
        );

        return count != null && count > 0;
    }
}
