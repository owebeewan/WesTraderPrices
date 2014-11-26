package com.westraderprices;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class NewScheduler {

	// every 500 seconds to test
	@Scheduled(fixedRate=500000)
	public void scheduleMethod() {
		
	}
}
