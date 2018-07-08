package sjleibow.music.collection.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import sjleibow.music.collection.entity.Album;
import sjleibow.music.collection.http.ApiResponseHeaders;
import sjleibow.music.collection.service.AlbumService;
import sjleibow.music.collection.view.AlbumDetail;
import sjleibow.music.collection.view.AlbumSummary;

@RestController
public class AlbumController {

	@Autowired
	@Qualifier("AlbumServiceJPAImpl")
	private AlbumService albumService;
	
	@Autowired
	ApiResponseHeaders responseHeaders;
	
	@GetMapping(value="/Album/{id}", produces={"application/json", "application/xml"})
	public ResponseEntity<AlbumDetail> getAlbum(@PathVariable("id") int id) {
		AlbumDetail responseBody = albumService.getAlbum(id);
		return new ResponseEntity<>(responseBody, responseHeaders, HttpStatus.OK);
	}
	
	@GetMapping(value="/AlbumList", produces={"application/json", "application/xml"})
	public ResponseEntity<List<AlbumSummary>> getAlbumList() {
		List<AlbumSummary> responseBody =  albumService.getAlbumList();
		return new ResponseEntity<>(responseBody, responseHeaders, HttpStatus.OK);
	}
	
	@PostMapping(value="/Album", consumes={"application/json", "application/xml"})
	@ResponseStatus(HttpStatus.CREATED)
	public void addAlbum(@RequestBody Album album) {
		albumService.addAlbum(album);
	}
	
	@PutMapping(value="/Album", consumes={"application/json", "application/xml"})
	public void updateAlbum(@RequestBody Album album) {
		albumService.updateAlbum(album);
	}
	
	@DeleteMapping(value="/Album/{id}")
	public void deleteAlbum(@PathVariable("id") int id) {
		albumService.deleteAlbum(id);
	}
}
