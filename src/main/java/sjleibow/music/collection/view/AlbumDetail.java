package sjleibow.music.collection.view;

import sjleibow.music.collection.entity.Album;

public class AlbumDetail {

	private int id;
	private String name;
	private short year;
	private ArtistSummary artist;
	
	// TODO Include track list
	
	public AlbumDetail(Album album) {
		id = album.getId();
		name = album.getName();
		year = album.getYear();
		artist = new ArtistSummary(album.getArtist());
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public short getYear() {
		return year;
	}

	public ArtistSummary getArtist() {
		return artist;
	}

	@Override
	public String toString() {
		return "ArtistDetail [id=" + id + ", name=" + name + ", year=" + year + ", artist=" + artist + "]";
	}
}
