package sjleibow.music.collection.dao;

import java.util.List;

import sjleibow.music.collection.entity.Artist;

public interface ArtistDAO {
	public Artist getArtist(int id);
	public List<Artist> getArtistList();
	public void addArtist(Artist artist);
	public void updateArtist(Artist artist);
	public void deleteArtist(int id);
}