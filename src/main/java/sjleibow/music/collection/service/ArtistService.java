package sjleibow.music.collection.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sjleibow.music.collection.dao.AlbumDAO;
import sjleibow.music.collection.dao.ArtistDAO;
import sjleibow.music.collection.model.Album;
import sjleibow.music.collection.model.Artist;
import sjleibow.music.collection.view.ArtistDetail;
import sjleibow.music.collection.view.ArtistSummary;

@Transactional
@Service
public class ArtistService {
	
	@Autowired
	private ArtistDAO artistDAO;
	
	@Autowired
	private AlbumDAO albumDAO;

	public List<ArtistSummary> getArtistSummaryList() {
		List<Artist> artistList = artistDAO.getArtistList();	
		List<ArtistSummary> artistSummaryList = new ArrayList<>(artistList.size());
		artistList.forEach(artist -> artistSummaryList.add(new ArtistSummary(artist)));
		return artistSummaryList;
	}
	
	public ArtistDetail getArtistDetail(int id) {
		Artist artist = artistDAO.getArtist(id);
		List<Album> albumList = albumDAO.getAlbumListByArtist(id);
		return new ArtistDetail(artist, albumList);
	}
	
	public void addArtist(Artist artist) {
		artistDAO.addArtist(artist);
	}
}
