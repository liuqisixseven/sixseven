package springBatch.batch.job;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class JobConfig {
	@Autowired
	private JobBuilderFactory jobBuilderFactory;
	@Bean
	public Job itemReaderFromDBJob(@Qualifier("itemReaderFromDBJobStep")Step step) {
		return jobBuilderFactory.get("ItemReaderFromDBJobConfig")
				 .start(step)
	             .build();
	}
}
