package sjleibow.music.collection.dao;

import java.util.List;

import sjleibow.music.collection.entity.Album;

public interface AlbumDAO {
	public Album getAlbum(int id);
	public List<Album> getAlbumList();
	public List<Album> getAlbumListByArtist(int artistId);
	public void addAlbum(Album album);
	public void updateAlbum(Album album);
	public void deleteAlbum(int id);
	public void deleteAlbumsByArtist(int artistId);
}