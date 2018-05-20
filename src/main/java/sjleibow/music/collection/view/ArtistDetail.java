package sjleibow.music.collection.view;

import java.util.List;

import sjleibow.music.collection.model.Album;
import sjleibow.music.collection.model.Artist;

public class ArtistDetail {
	
	private Artist artist;
	private List<Album> albumList;
	
	public Artist getArtist() {
		return artist;
	}

	public void setArtist(Artist artist) {
		this.artist = artist;
	}

	public List<Album> getAlbumList() {
		return albumList;
	}

	public void setAlbumList(List<Album> albumList) {
		this.albumList = albumList;
	}
	
	@Override
	public String toString() {
		return String.format("((%s) (%s))", albumList, artist);
	}
}
