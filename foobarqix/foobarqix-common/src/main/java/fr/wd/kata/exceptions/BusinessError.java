package fr.wd.kata.exceptions;

import java.text.MessageFormat;
import java.util.List;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class BusinessError {

	private String code;

	private String type;

	private String message;

	private String champs;

	private List<?> conflits;

	private final ResourceBundle resourceBundle = ResourceBundle.getBundle("ValidationMessages");

	public BusinessError(final String message) {
		try {
			this.code = resourceBundle.getString(message + ".code");
			this.type = resourceBundle.getString(message + ".type");
			this.message = resourceBundle.getString(message + ".msg");
		} catch (MissingResourceException e) {
			this.message = message;
		}
	}

	public BusinessError(final String message, Object... param) {
		try {
			this.code = resourceBundle.getString(message + ".code");
			this.type = resourceBundle.getString(message + ".type");
			this.message = MessageFormat.format(resourceBundle.getString(message + ".msg"), param);

		} catch (MissingResourceException e) {
			this.message = message;
		}
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getMessage() {
		return message;
	}

	public String getChamps() {
		return champs;
	}

	public void setChamps(String champs) {
		this.champs = champs;
	}

	public void setConflits(List<?> conflits) {
		this.conflits = conflits;
	}

	public List<?> getConflits() {
		return conflits;
	}

	@Override
	public String toString() {
		return "BusinessError [message=" + message + "]";
	}
}
