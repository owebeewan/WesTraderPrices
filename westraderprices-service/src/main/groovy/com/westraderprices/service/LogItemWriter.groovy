package com.westraderprices.service

import com.westraderprices.domain.Price
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

@Component("priceWriter")
public class LogItemWriter implements ItemWriter<Price> {

   private static final Logger LOG = Logger.getLogger(LogItemWriter.class);

   public void write(List<? extends Price> items) throws Exception {
	   for (Price price: items) {
		   LOG.info(price.toString());
	   }
   }
}