package sjleibow.music.collection.service.impl.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import sjleibow.music.collection.entity.Artist;
import sjleibow.music.collection.exception.ResourceNotFoundException;
import sjleibow.music.collection.repository.ArtistRepository;
import sjleibow.music.collection.service.ArtistService;
import sjleibow.music.collection.view.ArtistDetail;
import sjleibow.music.collection.view.ArtistSummary;


@Transactional
@Service("ArtistServiceJPAImpl")
public class ArtistServiceJPAImpl implements ArtistService {
	
	@Autowired
	private ArtistRepository artistRepository;

	@Override
	public ArtistDetail getArtist(int id) {
		Artist artist = artistRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("artist", id));
		return new ArtistDetail(artist);
	}

	@Override
	public List<ArtistSummary> getArtistList() {
		List<Artist> artistList = artistRepository.findAll(Sort.by("name"));
		List<ArtistSummary> summaryList = new ArrayList<>(artistList.size());
		artistList.forEach(artist -> summaryList.add(new ArtistSummary(artist)));
		return summaryList;
	}

	@Override
	public void addArtist(Artist artist) {
		artistRepository.save(artist);
	}

	@Override
	public void updateArtist(Artist artist) {
		artistRepository.save(artist);	;
	}

	@Override
	public void deleteArtist(int id) {
		artistRepository.deleteById(id);	
	}	
}
