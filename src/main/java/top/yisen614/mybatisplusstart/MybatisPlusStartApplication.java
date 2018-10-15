package top.yisen614.mybatisplusstart;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "top.yisen614")
@MapperScan("top.yisen614.mybatisplusstart.mapper")
public class MybatisPlusStartApplication {

	public static void main(String[] args) {
		SpringApplication.run(MybatisPlusStartApplication.class, args);
	}
}
