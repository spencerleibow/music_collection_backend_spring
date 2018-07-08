package sjleibow.music.collection.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sjleibow.music.collection.entity.Album;


@Repository
public interface AlbumRepository extends JpaRepository<Album, Integer> {

}
