package site.site8.springboot;

import com.alibaba.druid.pool.DruidDataSource;
import com.github.pagehelper.PageHelper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;
import java.util.Properties;

@SpringBootApplication
public class SpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootApplication.class, args);
	}


	@Autowired
	private Environment env;

	//destroy-method="close"的作用是当数据库连接不使用的时候,就把该连接重新放到数据池中,方便下次使用调用.
	@Bean(destroyMethod =  "close")
	public DataSource dataSource() {
		DruidDataSource dataSource = new DruidDataSource();
		dataSource.setUrl(env.getProperty("spring.datasource.url"));
		dataSource.setUsername(env.getProperty("spring.datasource.username"));//用户名
		dataSource.setPassword(env.getProperty("spring.datasource.password"));//密码
		dataSource.setDriverClassName(env.getProperty("spring.datasource.driver-class-name"));
		dataSource.setInitialSize(2);//初始化时建立物理连接的个数
		dataSource.setMaxActive(20);//最大连接池数量
		dataSource.setMinIdle(0);//最小连接池数量
		dataSource.setMaxWait(60000);//获取连接时最大等待时间，单位毫秒。
		dataSource.setValidationQuery("SELECT 1");//用来检测连接是否有效的sql
		dataSource.setTestOnBorrow(false);//申请连接时执行validationQuery检测连接是否有效
		dataSource.setTestWhileIdle(true);//建议配置为true，不影响性能，并且保证安全性。
		dataSource.setPoolPreparedStatements(false);//是否缓存preparedStatement，也就是PSCache
		return dataSource;
	}

	//配置mybatis的分页插件pageHelper
	// 参数说明 https://github.com/pagehelper/Mybatis-PageHelper/blob/master/wikis/zh/HowToUse.md
	@Bean
	public PageHelper pageHelper(){
		PageHelper pageHelper = new PageHelper();
		Properties properties = new Properties();
		//默认值为 false，该参数对使用 RowBounds 作为分页参数时有效。
		// 当该参数设置为 true 时，会将 RowBounds 中的 offset 参数当成 pageNum 使用，可以用页码和页面大小两个参数进行分页。
		properties.setProperty("offsetAsPageNum","true");
		properties.setProperty("rowBoundsWithCount","true");
		//分页合理化参数，默认值为false。当该参数设置为 true 时，pageNum<=0 时会查询第一页，
		// pageNum>pages（超过总数时），会查询最后一页。默认false 时，直接根据参数进行查询。
		properties.setProperty("reasonable","true");
		properties.setProperty("helperDialect","mysql");    //配置mysql数据库的方言
		pageHelper.setProperties(properties);
		return pageHelper;
	}
}
