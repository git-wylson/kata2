package fr.wd.kata.business.domain;

/**
 * Business class for FooBarQix. The object who allows to set the number and result
 * @author wylson
 */
public class FooBarQix {

	private Integer index;
	private String result;

	public FooBarQix(int index, String result) {
		this.index = index;
		this.result = result;
	}

	// Getters et setters
	public Integer getIndex() {
		return index;
	}

	public void setIndex(Integer index) {
		this.index = index;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (index ^ (index >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof FooBarQix))
			return false;
		FooBarQix other = (FooBarQix) obj;
		if (index != other.index)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "[number=" + index + ", result=" + result + "]";
	}

}
