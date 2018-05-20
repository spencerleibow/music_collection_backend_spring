package sjleibow.music.collection.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import sjleibow.music.collection.model.Album;
import sjleibow.music.collection.service.AlbumService;

@RestController
public class GetAlbumController {
	
	@Autowired
	private AlbumService albumService;
	
	@RequestMapping("/getAlbum")
	public Album getAlbum(@RequestParam(value="id")int id) {
		return albumService.getAlbum(id);
	}
}
