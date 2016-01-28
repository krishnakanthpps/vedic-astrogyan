package com.vedic.astro.pipeline.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Async;

import com.vedic.astro.domain.BirthChartData;
import com.vedic.astro.domain.LocationInfo;
import com.vedic.astro.repository.BirthChartRepository;
import com.vedic.astro.repository.LocationInfoRepository;
import com.vedic.astro.service.PlanetPositionsDataService;
import com.vedic.astro.util.BirthChartUtil;
import com.vedic.astro.vo.AbsolutePlanetaryPositions;
import com.vedic.astro.vo.Member;

public class BirthChartCalcService {
	
	@Autowired
	@Qualifier("planetPositionsDataService")
	private PlanetPositionsDataService planetPositionsDataService;

	@Autowired
	@Qualifier("locationInfoRepository")
	private LocationInfoRepository locationInfoRepository;

	@Autowired
	@Qualifier("birthChartRepository")
	private BirthChartRepository birthChartRepository;

	@Autowired
	@Qualifier("birthChartUtil")
	private BirthChartUtil birthChartUtil;
 
	@Async
	public BirthChartData calcBirthChart(Member personalInfo){
		
		Optional<List<LocationInfo>> locationList = locationInfoRepository.getLocationByCountryAndCity(
				personalInfo.getCountryCode(), 
				personalInfo.getCityCode());
		
		Integer locationId = null;
		
		if(locationList.isPresent()){
		   locationId = locationList.get().get(0).getLocationId();
			
		}
		
		AbsolutePlanetaryPositions absolutePlanetaryPositions = 
				planetPositionsDataService.getPlanetPositionsData(
						personalInfo.getDob(), 
						personalInfo.getTob(), 
						locationId);
		
		System.out.println("absolutePlanetaryPositions =" + absolutePlanetaryPositions);
		
		BirthChartData birthChartData = birthChartUtil.generateD1Chart(absolutePlanetaryPositions);
		birthChartData.setPid(personalInfo.getPid());
		
		birthChartRepository.save(birthChartData);
		
		return birthChartData;
		
	}

}