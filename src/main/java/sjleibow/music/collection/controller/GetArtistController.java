package sjleibow.music.collection.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import sjleibow.music.collection.model.Artist;
import sjleibow.music.collection.service.ArtistService;
import sjleibow.music.collection.view.ArtistDetail;

@RestController
public class GetArtistController {

	@Autowired
	private ArtistService artistService;
	
	@RequestMapping("/getArtist")
	public Artist getArtist(@RequestParam(value="id") int id) {
		return artistService.getArtist(id);
	}
	
	@RequestMapping("/getArtistDetail")
	public ArtistDetail getArtistDetail(@RequestParam(value="id") int id) {
		return artistService.getArtistDetail(id);
	}
}
