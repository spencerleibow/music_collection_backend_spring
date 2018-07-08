package sjleibow.music.collection.service;

import java.util.List;

import sjleibow.music.collection.entity.Album;
import sjleibow.music.collection.view.AlbumDetail;
import sjleibow.music.collection.view.AlbumSummary;

public interface AlbumService {	
	public AlbumDetail getAlbum(int id);
	public List<AlbumSummary> getAlbumList();
	public void addAlbum(Album album);
	public void updateAlbum(Album album);
	public void deleteAlbum(int id);
}