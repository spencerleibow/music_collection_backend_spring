package sjleibow.music.collection.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import sjleibow.music.collection.service.AlbumService;
import sjleibow.music.collection.view.AlbumSummary;

@RestController
public class AlbumSummaryListController {
	
	@Autowired
	private AlbumService albumService;
	
	@RequestMapping(value="/AlbumSummaryList",
			method=RequestMethod.GET,
			produces={"application/json", "application/xml"}
	)
	public ResponseEntity<List<AlbumSummary>> getAlbumSummaryList() {
		List<AlbumSummary> responseBody =  albumService.getAlbumSummaryList();
		return new ResponseEntity<>(responseBody, HttpStatus.OK);
	}
}
