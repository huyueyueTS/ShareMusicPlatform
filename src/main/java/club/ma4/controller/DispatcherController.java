package club.ma4.controller;

import club.ma4.pojo.Album;
import club.ma4.pojo.Image;
import club.ma4.pojo.Song;
import club.ma4.service.QueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://www.ma4.club", maxAge = 3600)
@RequestMapping("/angular")
public class DispatcherController {
    String fileName=null;
    @Autowired
    QueryService queryService;
    @RequestMapping(value = "/queryAlbum",method = RequestMethod.GET)
    public List<Album> queryAlbum() throws Exception{
        List<Album> albums=new ArrayList<>();
        albums=queryService.queryAlbum();
        return albums;
    }
    @RequestMapping(value = "/{album}")
    public List<Song> querySong(@PathVariable("album")String albumName)throws Exception{
        Album album = new Album();
        albumName = "`" + albumName + "`";
        album.setName(albumName);
        List<Song> songs = new ArrayList<>();
        songs = queryService.querySong(album);
        return songs;
    }
    @RequestMapping(value = "/{album}/{songName}",method = RequestMethod.GET)
    public List<Song> querySingleSong(@PathVariable("album")String albumName, @PathVariable("songName")String songName) throws Exception{
        Album album = new Album();
        albumName = "`" + albumName + "`";
        album.setName(albumName);
        System.out.println(songName);
        List<Song> song=new ArrayList<>();
        song=queryService.singleSong(album,songName);
        return song;
    }
    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    public void saveSong(@RequestBody Map<String,Object> map)throws Exception{
        Album album=new Album();
        album.setName("`"+(String)map.get("album")+"`");
        Song song=new Song();
        String songName=(String)map.get("name");
        song.setName(songName);
        String srcName=(String)map.get("srcName");
        System.out.println(srcName);
        song.setSrc("http://129.211.61.146:8080/taylorswift/music/"+srcName);
        queryService.insertSong(album,song);
    }
    @RequestMapping("/upload")
    public void saveFile(@RequestParam("file")MultipartFile file)throws Exception{
        String fileName=file.getOriginalFilename();
        file.transferTo(new File("/usr/local/taylorswift/static/music/"+fileName));
        System.out.println("Save File");
//        file.transferTo(new File("D:\\workspace\\taylorswift\\src\\main\\resources\\static\\music"+file.getOriginalFilename().toLowerCase()));
//        System.out.println(fileName);
    }
}
