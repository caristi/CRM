package com.crm.util;

import javax.faces.FacesException;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ActionEvent;

import com.sun.faces.application.ActionListenerImpl;

public class MensajesUIActionListener extends ActionListenerImpl {
	
	@Override
	public void processAction(ActionEvent event) throws AbortProcessingException {
		try {
			super.processAction(event);
		}catch(FacesException ex) {
			FacesUtils.manejarExcepcion(ex);
		}
	}
	
}
