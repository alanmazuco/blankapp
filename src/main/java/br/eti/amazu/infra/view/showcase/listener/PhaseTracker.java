package br.eti.amazu.infra.view.showcase.listener;

import jakarta.faces.event.PhaseEvent;
import jakarta.faces.event.PhaseId;
import jakarta.faces.event.PhaseListener;

public class PhaseTracker implements PhaseListener{

	private static final long serialVersionUID= -6723797173046037566L;

	@Override
	public void afterPhase(PhaseEvent event) {			
		event.getFacesContext().getExternalContext().log("AFTER: "+event.getPhaseId());
	}

	@Override
	public void beforePhase(PhaseEvent event) {
		event.getFacesContext().getExternalContext().log("BEFORE: "+event.getPhaseId());	 
	}

	@Override
	public PhaseId getPhaseId() {
		return PhaseId.ANY_PHASE;
	}
}
