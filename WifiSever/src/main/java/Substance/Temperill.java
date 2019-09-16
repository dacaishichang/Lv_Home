package Substance;

/**
 * Temperill entity. @author MyEclipse Persistence Tools
 */

public class Temperill implements java.io.Serializable {

	// Fields

	private Integer id;
	private String temperture;
	private String illumination;
	private String yesNo;

	// Constructors

	/** default constructor */
	public Temperill() {
	}

	/** full constructor */
	public Temperill(String temperture, String illumination, String yesNo) {
		this.temperture = temperture;
		this.illumination = illumination;
		this.yesNo = yesNo;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTemperture() {
		return this.temperture;
	}

	public void setTemperture(String temperture) {
		this.temperture = temperture;
	}

	public String getIllumination() {
		return this.illumination;
	}

	public void setIllumination(String illumination) {
		this.illumination = illumination;
	}

	public String getYesNo() {
		return this.yesNo;
	}

	public void setYesNo(String yesNo) {
		this.yesNo = yesNo;
	}

}