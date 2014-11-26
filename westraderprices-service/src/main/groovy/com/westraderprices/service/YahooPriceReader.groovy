package com.westraderprices.service

import com.westraderprices.domain.Price

import java.io.*;
import java.net.URLEncoder;

import org.apache.commons.httpclient.*;
import org.apache.commons.httpclient.methods.*;
import org.springframework.batch.item.ItemReader
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

public class YahooPriceReader implements ItemReader<Price> {

	private String url
	private String symbol
	
	public YahooPriceReader() {
	}
	
	@Override
	public Price read() throws Exception, UnexpectedInputException,
			ParseException, NonTransientResourceException {
		
		// Process the response from Yahoo! Web Services
		String line
		BufferedReader br
		br = new BufferedReader(new InputStreamReader(rstream))
		while ((line = br.readLine()) != null) {
			println(line)
		}
		br.close()
		
		rstream.close()
		
	return line;
	}
	
	protected String buildDefaultUrl() {
		String symbol = "^VIX";
		int startMonth = 0;
		int startDay = 2;
		int startYear = 1990;
		int endMonth = 9;
		int endDay = 2;
		int endYear = 2014;
		String period = "d";  // d=daily, m=monthy, w=weekly
		
		String searchParameters = null;
			searchParameters = URLEncoder.encode(symbol, "UTF-8") +
					"&a=" + startMonth +
					"&b=" + startDay +
					"&c=" + startYear +
					"&d=" + endMonth +
					"&e=" + endDay +
					"&f=" + endYear +
					"&g=" + period +
					"&ignore=.csv";
				
		String url = baseUrl() + searchParameters;

		return url;
	}
	
	public void setUrl(String url) {
		this.url = url
	}

	public void setSymbol(String symbol) {
		this.url = symbol
	}
	
	public String baseUrl() {
		return "http://real-chart.finance.yahoo.com/table.csv?s=";
	}
}

