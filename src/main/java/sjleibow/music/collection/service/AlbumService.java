package sjleibow.music.collection.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sjleibow.music.collection.dao.AlbumDAO;
import sjleibow.music.collection.model.Album;
import sjleibow.music.collection.view.AlbumSummary;

@Transactional
@Service
public class AlbumService {
	
	@Autowired
	private AlbumDAO albumDAO;
	
	public List<AlbumSummary> getAlbumSummaryList() {
		List<Album> albumList = albumDAO.getAlbumList();		
		List<AlbumSummary> albumSummary = new ArrayList<>(albumList.size());
		albumList.forEach(album -> albumSummary.add(new AlbumSummary(album)));
		return albumSummary;
	}
	
	public void addAlbum(Album album) {
		albumDAO.addAlbum(album);
	}
}
