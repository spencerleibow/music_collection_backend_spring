package sjleibow.music.collection.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sjleibow.music.collection.model.Artist;
import sjleibow.music.collection.service.ArtistService;

@RestController
public class GetArtistListController {
	
	@Autowired
	private ArtistService artistService;
	
	@RequestMapping(value="/getArtistList", produces={"application/json", "application/xml"})
	public List<Artist> getList() {
		return artistService.getArtistList();
	}
	
}
