package sjleibow.music.collection.view;

import sjleibow.music.collection.model.Album;

public class AlbumSummary {

	private int id;
	private String name;
	private short year;
	private int artistId;
	private String artistName;
	
	public AlbumSummary(Album album) {
		this.id = album.getId();
		this.name = album.getName();
		this.year = album.getYear();
		this.artistId = album.getArtist().getId();
		this.artistName = album.getArtist().getName();
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

	public int getArtistId() {
		return artistId;
	}

	public String getArtistName() {
		return artistName;
	}

	@Override
	public String toString() {
		return "AlbumSummary [id=" + id + ", name=" + name + ", year=" + year + ", artistId=" + artistId
				+ ", artistName=" + artistName + "]";
	}
}
