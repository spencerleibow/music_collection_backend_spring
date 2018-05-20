package sjleibow.music.collection.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sjleibow.music.collection.model.Album;
import sjleibow.music.collection.service.AlbumService;
import sjleibow.music.collection.view.AlbumSummary;

@RestController
public class GetAlbumListController {
	
	@Autowired
	private AlbumService albumService;
	
	@RequestMapping("/getAlbumList")
	public List<Album> getList() {
		return albumService.getAlbumList();
	}
	
	@RequestMapping("/getAlbumSummaryList")
	public List<AlbumSummary> getSummaryList() {
		return albumService.getAlbumSummaryList();
	}
}
