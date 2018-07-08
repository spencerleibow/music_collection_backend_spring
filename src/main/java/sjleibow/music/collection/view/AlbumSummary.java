package sjleibow.music.collection.view;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import sjleibow.music.collection.entity.Album;

@JsonInclude(Include.NON_NULL)
public class AlbumSummary extends AbstractSummary {
	
	private short year;
	private ArtistSummary artist;
	
	public AlbumSummary(Album album, boolean includeArtist) {
		super(album.getId(), album.getName());
		year = album.getYear();
		if (includeArtist) {
			artist = new ArtistSummary(album.getArtist());
		}
	}

	public short getYear() {
		return year;
	}

	public ArtistSummary getArtist() {
		return artist;
	}

	@Override
	protected String resourceName() {
		return Album.RESOURCE_NAME;
	}

	@Override
	public String toString() {
		return "AlbumSummary [year=" + year + ", artist=" + artist + ", resourceLink=" + resourceLink + ", name=" + name + "]";
	}
}
