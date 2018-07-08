package sjleibow.music.collection.view;

import sjleibow.music.collection.entity.Artist;

public class ArtistSummary extends AbstractSummary {
	
	public ArtistSummary(Artist artist) {
		super(artist.getId(), artist.getName());
	}

	@Override
	public String toString() {
		return "ArtistSummary [resourceLink=" + resourceLink + ", name=" + name + "]";
	}

	@Override
	protected String resourceName() {
		return Artist.RESOURCE_NAME;
	}
}
