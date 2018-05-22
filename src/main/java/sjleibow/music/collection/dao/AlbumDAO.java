package sjleibow.music.collection.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import sjleibow.music.collection.model.Album;
import sjleibow.music.collection.model.Artist;

@Repository
public class AlbumDAO {
	
	
	private static final String SQL_SELECT = "SELECT a.id albumId, a.name albumName, a.year albumYear, b.id artistId, b.name artistName"
			+ " FROM album a"
			+ " INNER JOIN artist b ON a.artist_Id = b.id";
	
	private static final String SQL_ALBUM = SQL_SELECT + " WHERE a.id = ?";	
	private static final String SQL_ALL_ALBUMS = SQL_SELECT + " ORDER BY albumName";
	private static final String SQL_ALBUMS_BY_ARTIST = SQL_SELECT + " WHERE b.id = ? ORDER BY albumYear";

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public AlbumDAO(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public Album getAlbum(int id) {
		return jdbcTemplate.queryForObject(SQL_ALBUM, new AlbumRowMapper(), id);
	}

	public List<Album> getAlbumList() {
		return jdbcTemplate.query(SQL_ALL_ALBUMS, new AlbumRowMapper());
	}
	
	public List<Album> getAlbumListByArtist(int artistId) {
		return jdbcTemplate.query(SQL_ALBUMS_BY_ARTIST, new AlbumRowMapper(), artistId);
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
