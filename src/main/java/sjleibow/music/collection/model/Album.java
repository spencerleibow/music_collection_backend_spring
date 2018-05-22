package sjleibow.music.collection.model;

public class Album {
	
	private int id;
	private Artist artist;
	private String name;
	private short year;
	
	public int getId() {
		return id;
	}
	public Artist getArtist() {
		return artist;
	}
	public void setArtist(Artist artist) {
		this.artist = artist;
	}
	public void setId(int id) {
		this.id = id;
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
		return "Album [id=" + id + ", artist=" + artist + ", name=" + name + ", year=" + year + "]";
	}
}
