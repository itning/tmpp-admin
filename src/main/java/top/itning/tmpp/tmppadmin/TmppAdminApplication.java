package top.itning.tmpp.tmppadmin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author itning
 */
@SpringBootApplication
@MapperScan("top.itning.tmpp.tmppadmin.mapper")
public class TmppAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(TmppAdminApplication.class, args);
    }

}
