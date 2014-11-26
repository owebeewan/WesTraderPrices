package com.westraderprices.service
import static org.junit.Assert.assertEquals

import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.batch.core.Job
import org.springframework.batch.core.JobExecution
import org.springframework.batch.core.JobParametersBuilder
import org.springframework.batch.core.launch.JobLauncher
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import org.springframework.transaction.annotation.Isolation
import org.springframework.transaction.annotation.Transactional

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/META-INF/spring/applicationContext.xml")
public class YahooPriceJobTest {

   @Autowired
   private JobLauncher jobLauncher;

   @Autowired
   @Qualifier(value = "YahooPrices")
   private Job job;

   @Test
   public void dummyTest() {
	   assert(true)
   }
   
   @Test
//   @Transactional(isolation = Isolation.READ_UNCOMMITTED)
  public void testJob() throws Exception {
	   JobParametersBuilder builder = new JobParametersBuilder();
	   JobExecution jobExecution = jobLauncher.run(job,
			   builder.toJobParameters());
	println(jobExecution.getExitStatus().getExitCode())
	   assertEquals("COMPLETED", jobExecution.getExitStatus().getExitCode());
   }
}
