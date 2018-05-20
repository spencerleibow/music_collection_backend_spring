package sjleibow.music.collection.view;

import sjleibow.music.collection.model.Album;
import sjleibow.music.collection.model.Artist;

public class AlbumSummary {

	private Album album;
	private Artist artist;
	
	public Album getAlbum() {
		return album;
	}

	public void setAlbum(Album album) {
		this.album = album;
	}

	public Artist getArtist() {
		return artist;
	}

	public void setArtist(Artist artist) {
		this.artist = artist;
	}

	@Override
	public String toString() {
		return String.format("((%s) (%s))", album, artist);
	}
}
