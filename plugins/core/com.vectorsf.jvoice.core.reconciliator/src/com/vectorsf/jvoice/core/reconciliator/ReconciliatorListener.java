package com.vectorsf.jvoice.core.reconciliator;

import com.vectorsf.jvoice.base.model.service.BaseModel;
import com.vectorsf.jvoice.base.model.service.JVModelLifecycleListener;

public class ReconciliatorListener implements JVModelLifecycleListener {

	public ReconciliatorListener() {
	}

	@Override
	public void modelCreated(BaseModel baseModel) {
		JVoiceModelReconcilier.getInstance().create(baseModel);
	}

}
