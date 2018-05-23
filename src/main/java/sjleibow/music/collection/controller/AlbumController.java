package sjleibow.music.collection.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import sjleibow.music.collection.model.Album;
import sjleibow.music.collection.service.AlbumService;

@RestController
public class AlbumController {

	@Autowired
	private AlbumService albumService;
	
	@RequestMapping(
			value="/Album",
			method=RequestMethod.POST,
			consumes={"application/json", "application/xml"}
	)
	@ResponseStatus(HttpStatus.CREATED)
	public void addAlbum(@RequestBody Album album) {
		albumService.addAlbum(album);
	}
}
