package springBatch.batch.reader;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.database.JdbcPagingItemReader;
import org.springframework.batch.item.database.Order;
import org.springframework.batch.item.database.support.MySqlPagingQueryProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import springBatch.entity.User;

@Component
public class Reader {
	@Autowired
    private DataSource dataSource;
	
	@StepScope
	@Bean("itemReaderFromDB")
	public JdbcPagingItemReader<User> itemReaderFromDB(){
		JdbcPagingItemReader<User> jdbcPagingItemReader = new JdbcPagingItemReader<User>();
		jdbcPagingItemReader.setDataSource(dataSource);
        jdbcPagingItemReader.setFetchSize(2);
 
        jdbcPagingItemReader.setRowMapper(new RowMapper<User>() {
        	@Override
            public User mapRow(ResultSet resultSet, int i) throws SQLException {
 
                User user = new User();
                user.setId(resultSet.getInt(1));
                user.setName(resultSet.getString(2));
                user.setAge(resultSet.getInt(3));
 
                return user;
            }
        });
 
        MySqlPagingQueryProvider provider = new MySqlPagingQueryProvider();
        provider.setSelectClause("id,userid,password");
        provider.setFromClause("from usertest");
 
        Map<String, Order> map = new HashMap<>(1);
        map.put("id", Order.ASCENDING);
        provider.setSortKeys(map);
        jdbcPagingItemReader.setQueryProvider(provider);
        return jdbcPagingItemReader;
 
	}
}
