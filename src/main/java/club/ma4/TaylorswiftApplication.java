package club.ma4;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
@MapperScan("club.ma4.mapper")
public class TaylorswiftApplication extends SpringBootServletInitializer{

    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(TaylorswiftApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(TaylorswiftApplication.class, args);
    }

}
