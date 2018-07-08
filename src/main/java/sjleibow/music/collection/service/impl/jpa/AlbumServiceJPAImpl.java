package sjleibow.music.collection.service.impl.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import sjleibow.music.collection.entity.Album;
import sjleibow.music.collection.exception.ResourceNotFoundException;
import sjleibow.music.collection.repository.AlbumRepository;
import sjleibow.music.collection.service.AlbumService;
import sjleibow.music.collection.view.AlbumDetail;
import sjleibow.music.collection.view.AlbumSummary;

@Transactional
@Service("AlbumServiceJPAImpl")
public class AlbumServiceJPAImpl implements AlbumService {

	@Autowired
	private AlbumRepository albumRepository;

	@Override
	public AlbumDetail getAlbum(int id) {
		Album album = albumRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("artist", id));
		return new AlbumDetail(album);
	}

	@Override
	public List<AlbumSummary> getAlbumList() {
		List<Album> albumList = albumRepository.findAll(Sort.by("name"));
		List<AlbumSummary> summaryList = new ArrayList<>(albumList.size());
		albumList.forEach(album -> summaryList.add(new AlbumSummary(album, true)));
		return summaryList;
	}

	@Override
	public void addAlbum(Album album) {
		albumRepository.save(album);
		
	}

	@Override
	public void updateAlbum(Album album) {
		albumRepository.save(album);
	}

	@Override
	public void deleteAlbum(int id) {
		albumRepository.deleteById(id);
	}
}
