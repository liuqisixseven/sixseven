package springBatch.batch.step;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springBatch.batch.writer.ItemWriteFromDb;
import springBatch.entity.User;

@Configuration
public class StepConfig{
	@Autowired
	private StepBuilderFactory stepBuilderFactory;
	
    @Bean("itemReaderFromDBJobStep")
	public Step itemReaderFromDBJobStep(
			@Qualifier("itemReaderFromDB")ItemReader<User> reader,
			@Qualifier("itemWriteFromDb")ItemWriteFromDb writer) {
	return stepBuilderFactory.get("itemReaderFromDBJobStep")
            .<User, User>chunk(2)
            .reader(reader)
            .writer(writer)
            .build();
	}
}
