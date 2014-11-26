package com.westraderprices.service

import java.io.*;
import java.net.URLEncoder;

import org.apache.commons.httpclient.*;
import org.apache.commons.httpclient.methods.*;

public class YahooPriceService {

	public YahooPriceService() {
	}

	public String getStockPrices(String url) throws IOException {
		HttpClient client = new HttpClient();
		GetMethod method = new GetMethod(url);
		
		// Send GET request
		int statusCode = client.executeMethod(method);
		
		if (statusCode != HttpStatus.SC_OK) {
			System.err.println("Method failed: " + method.getStatusLine());
		}
		InputStream rstream = null;
		
		// Get the response body
		rstream = method.getResponseBodyAsStream();
		
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
	
	public String baseUrl() {
		return "http://real-chart.finance.yahoo.com/table.csv?s=";
	}
}

