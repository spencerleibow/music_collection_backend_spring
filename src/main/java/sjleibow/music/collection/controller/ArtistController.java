package sjleibow.music.collection.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import sjleibow.music.collection.model.Artist;
import sjleibow.music.collection.service.ArtistService;

@RestController
public class ArtistController {

	@Autowired
	private ArtistService artistService;
	
	@RequestMapping(
			value="/Artist",
			method=RequestMethod.POST,
			consumes={"application/json", "application/xml"}
	)
	@ResponseStatus(HttpStatus.CREATED)
	public void addArtist(@RequestBody Artist artist) {
		artistService.addArtist(artist);
	}
}
