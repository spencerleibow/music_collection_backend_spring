package sjleibow.music.collection.service.impl.dao;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sjleibow.music.collection.dao.AlbumDAO;
import sjleibow.music.collection.dao.ArtistDAO;
import sjleibow.music.collection.entity.Artist;
import sjleibow.music.collection.service.ArtistService;
import sjleibow.music.collection.view.ArtistDetail;
import sjleibow.music.collection.view.ArtistSummary;

@Transactional
@Service("ArtistServiceDAOImpl")
public class ArtistServiceDAOImpl implements ArtistService {
	
	@Autowired
	private ArtistDAO artistDAO;
	
	@Autowired
	private AlbumDAO albumDAO;

	@Override
	public ArtistDetail getArtist(int id) {
		Artist artist = artistDAO.getArtist(id);
		artist.setAlbumList(albumDAO.getAlbumListByArtist(id));
		return new ArtistDetail(artist);
	}

	@Override
	public List<ArtistSummary> getArtistList() {
		List<Artist> artistList = artistDAO.getArtistList();
		List<ArtistSummary> summaryList = new ArrayList<>(artistList.size());
		artistList.forEach(artist -> summaryList.add(new ArtistSummary(artist)));
		return summaryList;
	}

	@Override
	public void addArtist(Artist artist) {
		artistDAO.addArtist(artist);
	}
}
