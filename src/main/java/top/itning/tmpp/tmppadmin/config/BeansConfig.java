package top.itning.tmpp.tmppadmin.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author itning
 * @date 2019/6/17 16:30
 */
@Configuration
public class BeansConfig {
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
