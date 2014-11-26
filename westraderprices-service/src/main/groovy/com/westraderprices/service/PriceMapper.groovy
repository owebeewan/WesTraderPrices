package com.westraderprices.service

import org.joda.time.DateTime
import org.springframework.batch.item.file.FlatFileParseException
import org.springframework.batch.item.file.mapping.FieldSetMapper
import org.springframework.batch.item.file.transform.FieldSet
import org.springframework.stereotype.Component
import org.springframework.validation.BindException

import com.westraderprices.domain.Price

@Component("priceMapper")
public class PriceFieldSetMapper implements FieldSetMapper {

   public Price mapFieldSet(FieldSet fieldSet) throws BindException {
	   String headerTest = fieldSet.readString(1)
	   if (headerTest.equalsIgnoreCase("Open")) {
		   return new Price(0.0,0.0,0.0,0.0,0L,new DateTime());
//		   throw new FlatFileParseException()
	   }
	   def open = Double.parseDouble(fieldSet.readString(1));
	   def high = Double.parseDouble(fieldSet.readString(2));
	   def low = Double.parseDouble(fieldSet.readString(3));
	   def close = Double.parseDouble(fieldSet.readString(6));
	   def volume = Long.parseLong(fieldSet.readString(5));
	   DateTime dateTime = new DateTime(fieldSet.readString(0));
	   
	   Price price = new Price(open, high, low, close, volume, dateTime)

	   return price;
   }
}
