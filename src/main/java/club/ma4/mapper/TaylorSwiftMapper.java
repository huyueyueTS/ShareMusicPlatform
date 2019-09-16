package club.ma4.mapper;

import club.ma4.pojo.Album;
import club.ma4.pojo.Song;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface TaylorSwiftMapper {
    List<Album> queryAlbum();
    List<Song> querySong(Album album);
    List<Song> singleSong(@Param("album") Album album, @Param("songName") String songName);
    void insertSong(@Param("album")Album album,@Param("song")Song song);
}
