package club.ma4.service;

import club.ma4.pojo.Album;
import club.ma4.pojo.Song;
import org.springframework.stereotype.Service;

import java.util.List;

public interface QueryService {
    public List<Album> queryAlbum() throws Exception;
    public List<Song> querySong(Album album) throws Exception;
    public List<Song> singleSong(Album album,String songName);
    public void insertSong(Album album,Song song);
}
