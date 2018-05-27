package sjleibow.music.collection.dao.jdbc.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import sjleibow.music.collection.dao.AlbumDAO;
import sjleibow.music.collection.entity.Album;
import sjleibow.music.collection.entity.Artist;
import sjleibow.music.collection.exception.ResourceNotFoundException;

@Repository
public class AlbumDAOJdbcImpl implements AlbumDAO {
	
	
	private static final String SQL_SELECT = "SELECT a.id albumId, a.name albumName, a.year albumYear, b.id artistId, b.name artistName"
			+ " FROM album a"
			+ " INNER JOIN artist b ON a.artist_Id = b.id";
	
	private static final String SQL_ALBUM = SQL_SELECT + " WHERE a.id = ?";	
	private static final String SQL_ALL_ALBUMS = SQL_SELECT + " ORDER BY albumName";
	private static final String SQL_ALBUMS_BY_ARTIST = SQL_SELECT + " WHERE b.id = ? ORDER BY albumYear";
	private static final String INSERT_ALBUM_SQL = "INSERT INTO album (artist_id, name, year) VALUES (?,?,?)";

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public AlbumDAOJdbcImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Override
	public Album getAlbum(int id) {
		try {
			return jdbcTemplate.queryForObject(SQL_ALBUM, new AlbumRowMapper(), id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("album", id);
		}
	}

	@Override
	public List<Album> getAlbumList() {
		return jdbcTemplate.query(SQL_ALL_ALBUMS, new AlbumRowMapper());
	}
	
	@Override
	public List<Album> getAlbumListByArtist(int artistId) {
		return jdbcTemplate.query(SQL_ALBUMS_BY_ARTIST, new AlbumRowMapper(), artistId);
	}
	
	@Override
	public void addAlbum(Album album) {
		jdbcTemplate.update(INSERT_ALBUM_SQL,
				album.getArtist().getId(), album.getName(), album.getYear());
	}
	
	private static class AlbumRowMapper implements RowMapper<Album> {

		@Override
		public Album mapRow(ResultSet rs, int rowNum) throws SQLException {
			Album album = new Album();
			album.setId(rs.getInt("albumId"));
			album.setName(rs.getString("albumName"));
			album.setYear(rs.getShort("albumYear"));
			
			Artist artist = new Artist();
			artist.setId(rs.getInt("artistId"));
			artist.setName(rs.getString("artistName"));
			album.setArtist(artist);

			return album;
		}
	}
}
