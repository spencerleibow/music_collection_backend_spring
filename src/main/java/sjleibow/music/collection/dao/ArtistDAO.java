package sjleibow.music.collection.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import sjleibow.music.collection.model.Artist;

@Repository
public class ArtistDAO {
	
	private static final String ARTIST_LIST_SQL = "SELECT id, name FROM artist";

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public ArtistDAO(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public List<Artist> getArtistList() {
		RowMapper<Artist> rowMapper = new BeanPropertyRowMapper<Artist>(Artist.class);
		return jdbcTemplate.query(ARTIST_LIST_SQL, rowMapper);
	}	
}
