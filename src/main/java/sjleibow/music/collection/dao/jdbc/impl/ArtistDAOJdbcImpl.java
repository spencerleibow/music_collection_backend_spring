package sjleibow.music.collection.dao.jdbc.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import sjleibow.music.collection.dao.ArtistDAO;
import sjleibow.music.collection.entity.Artist;
import sjleibow.music.collection.exception.ResourceNotFoundException;

@Repository
public class ArtistDAOJdbcImpl implements ArtistDAO {
	
	private static final String SELECT_ARTIST_SQL = "SELECT id, name FROM artist where id = ?";
	private static final String SELECT_ARTIST_LIST_SQL = "SELECT id, name FROM artist ORDER BY name";
	private static final String INSERT_ARTIST_SQL = "INSERT INTO artist (name) VALUES (?)";

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public ArtistDAOJdbcImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Override
	public Artist getArtist(int id) {
		try {
			return jdbcTemplate.queryForObject(SELECT_ARTIST_SQL, new BeanPropertyRowMapper<Artist>(Artist.class), id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("artist", id);
		}
	}
	
	@Override
	public List<Artist> getArtistList() {
		return jdbcTemplate.query(SELECT_ARTIST_LIST_SQL, new BeanPropertyRowMapper<Artist>(Artist.class));
	}
	
	@Override
	public void addArtist(Artist artist) {
		jdbcTemplate.update(INSERT_ARTIST_SQL, artist.getName());
	}
}
