package com.vedic.astro.repository;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.vedic.astro.domain.EntityRefData;
import com.vedic.astro.domain.HouseDetails;
import com.vedic.astro.domain.PlanetDetails;
import com.vedic.astro.domain.ZodiacDetails;
import com.vedic.astro.exception.SystemException;

/**
 * The Repository which does all basic CRUD operations on the
 * <tt>Token</tt> object. Uses Spring's {@link MongoTemplate} to perform CRUD
 * operations.
 * 
 * @author Sumeer Saxena
 * @param <T>
 */
@Repository("entityRepository")
@Transactional
public class EntityRepository {


	@Value("${mongo.collection.entities}")
	public String COLLECTION_NAME;

	/**
	 * The mongoTemplate is injected.
	 */
	@Resource(name = "mongoTemplate")
	private MongoTemplate mongoTemplate;


	/**
	 * Creates a new token and adds to the collection.
	 * @param <T>
	 * 
	 * @param token Token of the User
	 * @return tokenId of the user
	 */
	public void addPlanetRefData(EntityRefData<PlanetDetails> planetRefData) {

		try {

			// Insert to db
			mongoTemplate.insert(planetRefData, this.getRepositoryName());

		} catch (Exception ex) {
			throw new SystemException(ex.getMessage(), ex);
		}
	}

	/**
	 * Creates a new token and adds to the collection.
	 * @param <T>
	 * 
	 * @param token Token of the User
	 * @return tokenId of the user
	 */
	public void addHouseRefData(EntityRefData<HouseDetails> houseRefData) {

		try {

			// Insert to db
			mongoTemplate.insert(houseRefData, this.getRepositoryName());

		} catch (Exception ex) {
			throw new SystemException(ex.getMessage(), ex);
		}
	}

	/**
	 * Creates a new token and adds to the collection.
	 * @param <T>
	 * 
	 * @param token Token of the User
	 * @return tokenId of the user
	 */
	public void addZodiacRefData(EntityRefData<ZodiacDetails> zodiacRefData) {

		try {

			// Insert to db
			mongoTemplate.insert(zodiacRefData, this.getRepositoryName());

		} catch (Exception ex) {
			throw new SystemException(ex.getMessage(), ex);
		}
	}
	
	
	protected String getRepositoryName(){
		return COLLECTION_NAME;
	}
	
}
