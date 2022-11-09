package com.vs.model;

public class AdharCard {
	private Long adharNo;
	private String fingerprints;
	private String irisscan;

	public AdharCard() {

	}

	public AdharCard(Long adharNo, String fingerprints, String irisscan) {
		super();
		this.adharNo = adharNo;
		this.fingerprints = fingerprints;
		this.irisscan = irisscan;
	}

	public long getAdharNo() {
		return adharNo;
	}

	public void setAdharNo(long adharNo) {
		this.adharNo = adharNo;
	}

	public String getFingerprints() {
		return fingerprints;
	}

	public void setFingerprints(String fingerprints) {
		this.fingerprints = fingerprints;
	}

	public String getIrisscan() {
		return irisscan;
	}

	public void setIrisscan(String irisscan) {
		this.irisscan = irisscan;
	}

	@Override
	public String toString() {
		return "AdharCard [adharNo=" + adharNo + ", fingerprints=" + fingerprints + ", irisscan=" + irisscan + "]";
	}

}
