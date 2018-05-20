package sjleibow.music.collection.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import sjleibow.music.collection.model.Artist;

@Repository
public class ArtistDAO {
	
	private static final String ARTIST_SQL = "SELECT id, name FROM artist where id = ?";
	private static final String ARTIST_LIST_SQL = "SELECT id, name FROM artist";

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public ArtistDAO(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public Artist getArtist(int id) {
		return jdbcTemplate.queryForObject(ARTIST_SQL, new BeanPropertyRowMapper<Artist>(Artist.class), id);
	}
	
	public List<Artist> getArtistList() {
		return jdbcTemplate.query(ARTIST_LIST_SQL, new BeanPropertyRowMapper<Artist>(Artist.class));
	}	
}
