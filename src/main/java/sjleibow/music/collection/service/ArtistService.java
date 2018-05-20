package sjleibow.music.collection.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sjleibow.music.collection.dao.AlbumDAO;
import sjleibow.music.collection.dao.ArtistDAO;
import sjleibow.music.collection.model.Artist;
import sjleibow.music.collection.view.ArtistDetail;

@Transactional
@Service
public class ArtistService {
	
	@Autowired
	private ArtistDAO artistDAO;
	
	@Autowired
	private AlbumDAO albumDAO;

	public Artist getArtist(int id) {
		return artistDAO.getArtist(id);
	}
	
	public List<Artist> getArtistList() {
		return artistDAO.getArtistList();		
	}
	
	public ArtistDetail getArtistDetail(int id) {
		ArtistDetail artistDetail = new ArtistDetail();
		artistDetail.setArtist(artistDAO.getArtist(id));
		artistDetail.setAlbumList(albumDAO.getAlbumListByArtist(id));
		return artistDetail;
	}
}
