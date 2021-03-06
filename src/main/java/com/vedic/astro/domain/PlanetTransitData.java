package com.vedic.astro.domain;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.vedic.astro.enums.Planet;
import com.vedic.astro.enums.Zodiac;

@Document(collection="transit_info")
public class PlanetTransitData {
	
	@Id
	private String id = null;
	
	private Integer sequence;
	private Planet planet;
	private Date startDate;
	private Date endDate;
	private Zodiac zodiac;
	
	public PlanetTransitData(Planet planet, Date startDate,
			Zodiac zodiac) {
		super();
		this.planet = planet;
		this.startDate = startDate;
		this.zodiac = zodiac;
	}

	public Planet getPlanet() {
		return planet;
	}

	public void setPlanet(Planet planet) {
		this.planet = planet;
	}

	public Zodiac getZodiac() {
		return zodiac;
	}

	public void setZodiac(Zodiac zodiac) {
		this.zodiac = zodiac;
	}
	
	public Integer getSequence() {
		return sequence;
	}

	public void setSequence(Integer sequence) {
		this.sequence = sequence;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "PlanetTransitData [id=" + id + ", sequence=" + sequence + ", planet=" + planet + ", startDate="
				+ startDate + ", endDate=" + endDate + ", zodiac=" + zodiac + "]";
	}


}
