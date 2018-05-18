package sjleibow.music.collection.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sjleibow.music.collection.dao.ArtistDAO;
import sjleibow.music.collection.model.Artist;

@Transactional
@Service
public class ArtistService {
	
	@Autowired
	private ArtistDAO artistDAO;
	
	public List<Artist> getArtistList() {
		return artistDAO.getArtistList();
		
	}
}
