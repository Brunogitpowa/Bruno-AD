// default package
// Generated 23 nov 2023 19:26:33 by Hibernate Tools 5.2.13.Final

package Model;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Country generated by hbm2java
 */
@Entity
@Table(name = "country", catalog = "world")
public class Country implements java.io.Serializable {

	private String code;
	private String name;
	private String continent;
	private String region;
	private BigDecimal surfaceArea;
	private Short indepYear;
	private int population;
	private BigDecimal lifeExpectancy;
	private BigDecimal gnp;
	private BigDecimal gnpold;
	private String localName;
	private String governmentForm;
	private String headOfState;
	private Integer capital;
	private String code2;
	private Set<Countrylanguage> countrylanguages = new HashSet<Countrylanguage>(0);
	private Set<City> cities = new HashSet<City>(0);

	public Country() {
	}

	public Country(String code, String name, String continent, String region, BigDecimal surfaceArea, int population,
			String localName, String governmentForm, String code2) {
		this.code = code;
		this.name = name;
		this.continent = continent;
		this.region = region;
		this.surfaceArea = surfaceArea;
		this.population = population;
		this.localName = localName;
		this.governmentForm = governmentForm;
		this.code2 = code2;
	}

	public Country(String code, String name, String continent, String region, BigDecimal surfaceArea, Short indepYear,
			int population, BigDecimal lifeExpectancy, BigDecimal gnp, BigDecimal gnpold, String localName,
			String governmentForm, String headOfState, Integer capital, String code2,
			Set<Countrylanguage> countrylanguages, Set<City> cities) {
		this.code = code;
		this.name = name;
		this.continent = continent;
		this.region = region;
		this.surfaceArea = surfaceArea;
		this.indepYear = indepYear;
		this.population = population;
		this.lifeExpectancy = lifeExpectancy;
		this.gnp = gnp;
		this.gnpold = gnpold;
		this.localName = localName;
		this.governmentForm = governmentForm;
		this.headOfState = headOfState;
		this.capital = capital;
		this.code2 = code2;
		this.countrylanguages = countrylanguages;
		this.cities = cities;
	}

	@Id

	@Column(name = "Code", unique = true, nullable = false, length = 3)
	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Column(name = "Name", nullable = false, length = 52)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "Continent", nullable = false, length = 13)
	public String getContinent() {
		return this.continent;
	}

	public void setContinent(String continent) {
		this.continent = continent;
	}

	@Column(name = "Region", nullable = false, length = 26)
	public String getRegion() {
		return this.region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	@Column(name = "SurfaceArea", nullable = false, precision = 10)
	public BigDecimal getSurfaceArea() {
		return this.surfaceArea;
	}

	public void setSurfaceArea(BigDecimal surfaceArea) {
		this.surfaceArea = surfaceArea;
	}

	@Column(name = "IndepYear")
	public Short getIndepYear() {
		return this.indepYear;
	}

	public void setIndepYear(Short indepYear) {
		this.indepYear = indepYear;
	}

	@Column(name = "Population", nullable = false)
	public int getPopulation() {
		return this.population;
	}

	public void setPopulation(int population) {
		this.population = population;
	}

	@Column(name = "LifeExpectancy", precision = 3, scale = 1)
	public BigDecimal getLifeExpectancy() {
		return this.lifeExpectancy;
	}

	public void setLifeExpectancy(BigDecimal lifeExpectancy) {
		this.lifeExpectancy = lifeExpectancy;
	}

	@Column(name = "GNP", precision = 10)
	public BigDecimal getGnp() {
		return this.gnp;
	}

	public void setGnp(BigDecimal gnp) {
		this.gnp = gnp;
	}

	@Column(name = "GNPOld", precision = 10)
	public BigDecimal getGnpold() {
		return this.gnpold;
	}

	public void setGnpold(BigDecimal gnpold) {
		this.gnpold = gnpold;
	}

	@Column(name = "LocalName", nullable = false, length = 45)
	public String getLocalName() {
		return this.localName;
	}

	public void setLocalName(String localName) {
		this.localName = localName;
	}

	@Column(name = "GovernmentForm", nullable = false, length = 45)
	public String getGovernmentForm() {
		return this.governmentForm;
	}

	public void setGovernmentForm(String governmentForm) {
		this.governmentForm = governmentForm;
	}

	@Column(name = "HeadOfState", length = 60)
	public String getHeadOfState() {
		return this.headOfState;
	}

	public void setHeadOfState(String headOfState) {
		this.headOfState = headOfState;
	}

	@Column(name = "Capital")
	public Integer getCapital() {
		return this.capital;
	}

	public void setCapital(Integer capital) {
		this.capital = capital;
	}

	@Column(name = "Code2", nullable = false, length = 2)
	public String getCode2() {
		return this.code2;
	}

	public void setCode2(String code2) {
		this.code2 = code2;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "country")
	public Set<Countrylanguage> getCountrylanguages() {
		return this.countrylanguages;
	}

	public void setCountrylanguages(Set<Countrylanguage> countrylanguages) {
		this.countrylanguages = countrylanguages;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "country")
	public Set<City> getCities() {
		return this.cities;
	}

	public void setCities(Set<City> cities) {
		this.cities = cities;
	}

}