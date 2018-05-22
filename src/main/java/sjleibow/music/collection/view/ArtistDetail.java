package sjleibow.music.collection.view;

import java.util.ArrayList;
import java.util.List;

import sjleibow.music.collection.model.Album;
import sjleibow.music.collection.model.Artist;

public class ArtistDetail {
	
	private String name;
	private List<AlbumInfo> albumList;
	
	public ArtistDetail(Artist artist, List<Album> albumList) {
		this.name = artist.getName();
		this.albumList = new ArrayList<>(albumList.size());
		albumList.forEach(album -> this.albumList.add(new AlbumInfo(album)));
	}

	public String getName() {
		return name;
	}

	public List<AlbumInfo> getAlbumList() {
		return albumList;
	}

	@Override
	public String toString() {
		return "ArtistDetail [name=" + name + ", albumList=" + albumList + "]";
	}
	
	class AlbumInfo {
		private int id;
		private String name;
		private short year;
		
		public AlbumInfo(Album album) {
			id = album.getId();
			name = album.getName();
			year = album.getYear();
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
	}
}
