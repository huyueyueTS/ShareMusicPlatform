package club.ma4.service.impl;

import club.ma4.mapper.TaylorSwiftMapper;
import club.ma4.pojo.Album;
import club.ma4.pojo.Song;
import club.ma4.service.QueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
@Service
public class QueryServiceImpl implements QueryService {
    @Autowired
    private TaylorSwiftMapper taylorSwiftMapper;
    @Override
    public List<Album> queryAlbum() throws Exception {
        List<Album> list=new ArrayList<>();
        list= taylorSwiftMapper.queryAlbum();
        return list;
    }

    public List<Song> querySong(Album album) throws Exception {
        List<Song> list=taylorSwiftMapper.querySong(album);
        return list;
    }

    public List<Song> singleSong(Album album, String songName) {
        List<Song> list=taylorSwiftMapper.singleSong(album,songName);
        return list;
    }

    public void insertSong(Album album, Song song) {
        taylorSwiftMapper.insertSong(album,song);
    }
}
