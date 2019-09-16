package club.ma4;

import club.ma4.pojo.Album;
import club.ma4.service.QueryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaylorswiftApplicationTests {
    @Autowired
    QueryService queryService;
    @Test
    public void contextLoads() {
    }
    @Test
    public void getAlbum()throws Exception{
        System.out.println(queryService.queryAlbum().get(0).toString());
    }
    @Test
    public void getSong()throws Exception{
        Album album=new Album();
        album.setName("`1989`");
        System.out.println(queryService.querySong(album).get(0).toString());
    }

    @Test
    public void getSingleSong()throws Exception{
        Album album=new Album();
        album.setName("`1989`");
        String songName="Blank Space";
        System.out.println(queryService.singleSong(album,songName).get(0).toString());
    }

    @Test
    public void insertSong() throws Exception{
        Album album=new Album();
        album.setName("`speak now`");
        String songName="Mine";
        String nmsl="你妈死了";
        System.out.println(nmsl.toLowerCase());
//        queryService.insertSong(album,songName);
    }
}
