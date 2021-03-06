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

import sjleibow.music.collection.entity.Artist;
import sjleibow.music.collection.http.ApiResponseHeaders;
import sjleibow.music.collection.service.ArtistService;
import sjleibow.music.collection.view.ArtistDetail;
import sjleibow.music.collection.view.ArtistSummary;


@RestController
public class ArtistController {
	
	@Autowired
	@Qualifier("ArtistServiceJPAImpl")
	private ArtistService artistService;
	
	@Autowired
	ApiResponseHeaders responseHeaders;
	
	@GetMapping(value="/Artist/{id}", produces={"application/json", "application/xml"})
	public ResponseEntity<ArtistDetail> getArtist(@PathVariable("id") int id) {
		ArtistDetail responseBody =  artistService.getArtist(id);
		return new ResponseEntity<>(responseBody, responseHeaders, HttpStatus.OK);
	}
		
	@GetMapping(value="/ArtistList", produces={"application/json", "application/xml"})
	public ResponseEntity<List<ArtistSummary>> getArtistList() {
		List<ArtistSummary> responseBody = artistService.getArtistList();
		return new ResponseEntity<>(responseBody, responseHeaders, HttpStatus.OK);
	}
	
	@PostMapping(value="/Artist", consumes={"application/json", "application/xml"})
	@ResponseStatus(HttpStatus.CREATED)
	public void addArtist(@RequestBody Artist artist) {
		artistService.addArtist(artist);
	}
	
	@PutMapping(value="/Artist", consumes={"application/json", "application/xml"})
	public void updateArtist(@RequestBody Artist artist) {
		artistService.updateArtist(artist);
	}
	
	@DeleteMapping(value="/Artist/{id}")
	public void deleteArtist(@PathVariable("id") int id) {
		artistService.deleteArtist(id);
	}
}
