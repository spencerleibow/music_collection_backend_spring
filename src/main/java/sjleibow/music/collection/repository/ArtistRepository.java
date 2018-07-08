package sjleibow.music.collection.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sjleibow.music.collection.entity.Artist;


@Repository
public interface ArtistRepository extends JpaRepository<Artist, Integer> {

}
