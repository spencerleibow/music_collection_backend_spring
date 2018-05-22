package sjleibow.music.collection.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import sjleibow.music.collection.service.ArtistService;
import sjleibow.music.collection.view.ArtistDetail;

@RestController
public class ArtistDetailController {

	@Autowired
	private ArtistService artistService;
	
	@RequestMapping(
			value="/ArtistDetail/{id}",
			method=RequestMethod.GET,
			produces={"application/json", "application/xml"})
	public ResponseEntity<ArtistDetail> getArtistDetail(@PathVariable("id") int id) {
		ArtistDetail responseBody =  artistService.getArtistDetail(id);
		return new ResponseEntity<>(responseBody, HttpStatus.OK);
	}
}
