package sjleibow.music.collection.view;

import sjleibow.music.collection.model.Artist;

public class ArtistSummary {
	
	private int id;
	private String name;

	public ArtistSummary(Artist artist) {
		this.id = artist.getId();
		this.name = artist.getName();
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "ArtistSummary [id=" + id + ", name=" + name + "]";
	}
}
