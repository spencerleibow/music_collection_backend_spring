package sjleibow.music.collection.service.impl.dao;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sjleibow.music.collection.dao.AlbumDAO;
import sjleibow.music.collection.entity.Album;
import sjleibow.music.collection.service.AlbumService;
import sjleibow.music.collection.view.AlbumDetail;
import sjleibow.music.collection.view.AlbumSummary;

@Transactional
@Service("AlbumServiceDAOImpl")
public class AlbumServiceDAOImpl implements AlbumService {
	
	@Autowired
	private AlbumDAO albumDAO;

	@Override
	public AlbumDetail getAlbum(int id) {
		return new AlbumDetail(albumDAO.getAlbum(id));
	}

	@Override
	public List<AlbumSummary> getAlbumList() {
		List<Album> albumList = albumDAO.getAlbumList();
		List<AlbumSummary> summaryList = new ArrayList<>(albumList.size());
		albumList.forEach(album -> summaryList.add(new AlbumSummary(album, true)));
		return summaryList;
	}

	@Override
	public void addAlbum(Album album) {
		albumDAO.addAlbum(album);
	}
}
