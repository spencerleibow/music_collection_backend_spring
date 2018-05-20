package sjleibow.music.collection.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import sjleibow.music.collection.model.Album;
import sjleibow.music.collection.model.Artist;
import sjleibow.music.collection.view.AlbumSummary;

@Repository
public class AlbumDAO {
	
	private static final String ALBUM_SQL = "SELECT id, artist_id artistId, name, year FROM album where id = ?";
	private static final String ALBUM_LIST_SQL = "SELECT id, artist_id artistId, name, year FROM album";
	private static final String ALBUM_LIST_BY_ARTIST_SQL = "SELECT id, artist_id artistId, name, year FROM album where artist_id = ?";
	
	private static final String SQL_ALL_ALBUMS_SUMMARY_SELECT = "SELECT a.id albumId, a.name albumName, a.year albumYear, b.id artistId, b.name artistName"
			+ " FROM album a"
			+ " INNER JOIN artist b ON a.artist_Id = b.id";
	private static final String SQL_ALL_ALBUMS_SUMMARY = SQL_ALL_ALBUMS_SUMMARY_SELECT
			+ " ORDER BY albumName";
	private static final String SQL_ALL_ALBUMS_SUMMARY_BY_ARTIST = SQL_ALL_ALBUMS_SUMMARY_SELECT
			+ " WHERE b.id = ?"
			+ " ORDER BY albumYear";

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public AlbumDAO(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public Album getAlbum(int id) {
		return jdbcTemplate.queryForObject(ALBUM_SQL, new BeanPropertyRowMapper<Album>(Album.class), id);
	}

	public List<Album> getAlbumList() {
		return jdbcTemplate.query(ALBUM_LIST_SQL, new BeanPropertyRowMapper<Album>(Album.class));
	}
	
	public List<Album> getAlbumListByArtist(int artistId) {
		return jdbcTemplate.query(ALBUM_LIST_BY_ARTIST_SQL, new BeanPropertyRowMapper<Album>(Album.class), artistId);
	}
	
	public List<AlbumSummary> getAlbumSummaryList() {
		return jdbcTemplate.query(SQL_ALL_ALBUMS_SUMMARY, new SummaryRowMapper());
	}
	
	public List<AlbumSummary> getAlbumSummaryListByArtist(int artistId) {
		return jdbcTemplate.query(SQL_ALL_ALBUMS_SUMMARY_BY_ARTIST, new SummaryRowMapper(), artistId);
	}
	
	private static class SummaryRowMapper implements RowMapper<AlbumSummary> {

		@Override
		public AlbumSummary mapRow(ResultSet rs, int rowNum) throws SQLException {
			AlbumSummary albumSummary = new AlbumSummary();
			
			Album album = new Album();
			album.setId(rs.getInt("albumId"));
			album.setArtistId(rs.getInt("artistId"));
			album.setName(rs.getString("albumName"));
			album.setYear(rs.getShort("albumYear"));
			
			Artist artist = new Artist();
			artist.setId(rs.getInt("artistId"));
			artist.setName(rs.getString("artistName"));
			
			albumSummary.setAlbum(album);
			albumSummary.setArtist(artist);
			return albumSummary;
		}
	}
}
