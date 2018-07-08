package sjleibow.music.collection.service;

import java.util.List;

import sjleibow.music.collection.entity.Artist;
import sjleibow.music.collection.view.ArtistDetail;
import sjleibow.music.collection.view.ArtistSummary;


public interface ArtistService {
	public ArtistDetail getArtist(int id);
	public List<ArtistSummary> getArtistList();
	public void addArtist(Artist artist);
	public void updateArtist(Artist artist);
	public void deleteArtist(int id);
	
}