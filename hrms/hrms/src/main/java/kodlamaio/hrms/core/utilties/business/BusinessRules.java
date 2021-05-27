package kodlamaio.hrms.core.utilties.business;

import kodlamaio.hrms.core.utilties.results.Result;
import kodlamaio.hrms.core.utilties.results.SuccessResult;

public class BusinessRules {
	public static Result run(Result... logics) {
		for (Result logic : logics) {
			if (!logic.isSuccess()) {
				return logic;
			}
		}
		return new SuccessResult();
	}
}
