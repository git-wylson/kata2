package fr.wd.kata.exceptions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SuppressWarnings("serial")
public class BusinessException extends RuntimeException {

	protected List<BusinessError> businessErrors = new ArrayList<BusinessError>();

	public BusinessException(final BusinessError... businessErrors) {
		this(Arrays.asList(businessErrors));
	}

	public BusinessException(final List<BusinessError> businessErrors) {
		this.businessErrors.addAll(businessErrors);
	}

	public void addError(final BusinessError businessError) {
		businessErrors.add(businessError);
	}

	public List<BusinessError> getBusinessErrors() {
		return businessErrors;
	}

	@Override
	public String toString() {
		return "BusinessException [businessErrors=" + businessErrors + "]";
	}
}
