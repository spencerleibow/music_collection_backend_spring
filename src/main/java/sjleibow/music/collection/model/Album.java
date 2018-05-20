package sjleibow.music.collection.model;

public class Album {
	
	private int id;
	private int artistId;
	private String name;
	private short year;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getArtistId() {
		return artistId;
	}
	public void setArtistId(int artistId) {
		this.artistId = artistId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public short getYear() {
		return year;
	}
	public void setYear(short year) {
		this.year = year;
	}
	
	@Override
	public String toString() {
		return String.format("(%d %d %s %d)", id, artistId, name, year);
	}
}
