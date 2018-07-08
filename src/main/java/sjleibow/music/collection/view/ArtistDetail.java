package sjleibow.music.collection.view;

import java.util.ArrayList;
import java.util.List;

import sjleibow.music.collection.entity.Artist;

public class ArtistDetail {
	
	private int id;
	private String name;
	private List<AlbumSummary> albumList = new ArrayList<>();
	
	public ArtistDetail(Artist artist) {
		id = artist.getId();
		name = artist.getName();
		artist.getAlbumList().forEach(album -> albumList.add(new AlbumSummary(album, false)));
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public List<AlbumSummary> getAlbumList() {
		return albumList;
	}

	@Override
	public String toString() {
		return "ArtistDetail [id=" + id + ", name=" + name + ", albumList=" + albumList + "]";
	}
}
