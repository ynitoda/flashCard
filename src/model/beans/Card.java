package model.beans;

import java.io.Serializable;

public class Card implements Serializable{
	private int id;
	private String word;
	private String meaning;
	private boolean checkflag;
	private String unit;
	private String day;

	public Card(final int id, final String word, final String
			meaning, final boolean checkflag, final String unit, final String day) {
		this.id = id;
		this.word = word;
		this.meaning = meaning;
		this.checkflag = checkflag;
		this.unit = unit;
		this.day = day;

	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public String getMeaning() {
		return meaning;
	}

	public void setMeaning(String meaning) {
		this.meaning = meaning;
	}

	public boolean isCheckflag() {
		return checkflag;
	}

	public void setCheckflag(boolean checkflag) {
		this.checkflag = checkflag;
	}
}
