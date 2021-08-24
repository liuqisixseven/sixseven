package springBatch.controller;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringBatchController {
	@Autowired
    JobLauncher jobLauncher;
    @Autowired
    Job job;
    @GetMapping("/hello")
    public void hello() {
        try {
            jobLauncher.run(job, new JobParametersBuilder().toJobParameters());//执行一个批处理任务
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
