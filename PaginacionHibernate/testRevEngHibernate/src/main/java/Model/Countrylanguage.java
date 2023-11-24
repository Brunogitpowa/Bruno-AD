// default package
// Generated 23 nov 2023 19:26:33 by Hibernate Tools 5.2.13.Final

package Model;

import java.math.BigDecimal;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Countrylanguage generated by hbm2java
 */
@Entity
@Table(name = "countrylanguage", catalog = "world")
public class Countrylanguage implements java.io.Serializable {

	private CountrylanguageId id;
	private Country country;
	private char isOfficial;
	private BigDecimal percentage;

	public Countrylanguage() {
	}

	public Countrylanguage(CountrylanguageId id, Country country, char isOfficial, BigDecimal percentage) {
		this.id = id;
		this.country = country;
		this.isOfficial = isOfficial;
		this.percentage = percentage;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "countryCode", column = @Column(name = "CountryCode", nullable = false, length = 3)),
			@AttributeOverride(name = "language", column = @Column(name = "Language", nullable = false, length = 30)) })
	public CountrylanguageId getId() {
		return this.id;
	}

	public void setId(CountrylanguageId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CountryCode", nullable = false, insertable = false, updatable = false)
	public Country getCountry() {
		return this.country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	@Column(name = "IsOfficial", nullable = false, length = 1)
	public char getIsOfficial() {
		return this.isOfficial;
	}

	public void setIsOfficial(char isOfficial) {
		this.isOfficial = isOfficial;
	}

	@Column(name = "Percentage", nullable = false, precision = 4, scale = 1)
	public BigDecimal getPercentage() {
		return this.percentage;
	}

	public void setPercentage(BigDecimal percentage) {
		this.percentage = percentage;
	}

}
