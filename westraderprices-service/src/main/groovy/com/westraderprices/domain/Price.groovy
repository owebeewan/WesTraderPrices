package com.westraderprices.domain;

import org.joda.time.DateTime;

public class Price {
    private DateTime timestamp = new DateTime()
	private double open = 0.0
    private double close = 0.0
    private double high = 0.0
    private double low = 0.0
    private long volume = 0
 
	/**
	 * @param open
	 * @param close
	 * @param high
	 * @param low
	 * @param volume
	 * @param timestamp
	 */
	public Price(double open, double high, double low, double close, long volume, DateTime timestamp) {
		super();
		this.open = open;
		this.close = close;
		this.high = high;
		this.low = low;
		this.volume = volume;
		this.timestamp = timestamp;
	}


    public double getOpen() {
		return open;
	}

	public double getClose() {
		return close;
	}

	public double getHigh() {
		return high;
	}

	public double getLow() {
		return low;
	}

	public long getVolume() {
		return volume;
	}

	public DateTime getTimestamp() {
		return timestamp;
	}

	@Override
	public String toString() {
		return "Price [timestamp=" + timestamp.toLocalDateTime() + ", open=" + open + ", close=" + close + ", high=" + high + ", low=" + low + ",  volume=" + volume + "]"
	}
}

