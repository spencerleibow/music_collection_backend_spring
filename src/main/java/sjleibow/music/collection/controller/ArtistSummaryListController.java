package sjleibow.music.collection.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import sjleibow.music.collection.service.ArtistService;
import sjleibow.music.collection.view.ArtistSummary;

@RestController
public class ArtistSummaryListController {
	
	@Autowired
	private ArtistService artistService;
	
	@RequestMapping(
			value="/ArtistSummaryList",
			method=RequestMethod.GET,
			produces={"application/json", "application/xml"}
	)
	public ResponseEntity<List<ArtistSummary>> getArtistSummaryList() {
		List<ArtistSummary> responseBody = artistService.getArtistSummaryList();
		return new ResponseEntity<>(responseBody, HttpStatus.OK);
	}
}
