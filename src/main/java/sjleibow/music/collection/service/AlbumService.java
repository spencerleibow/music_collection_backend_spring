package sjleibow.music.collection.service;

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
	
	public Album getAlbum(int id) {
		return albumDAO.getAlbum(id);
	}
	
	public List<Album> getAlbumList() {
		return albumDAO.getAlbumList();
	}
	
	public List<AlbumSummary> getAlbumSummaryList() {
		return albumDAO.getAlbumSummaryList();
	}
}
