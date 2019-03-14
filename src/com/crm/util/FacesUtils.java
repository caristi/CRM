package com.crm.util;

import javax.faces.FacesException;
import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;

import com.crm.services.BaseException;

public class FacesUtils {
	
	public static void manejarExcepcion(FacesException ex) throws FacesException{
		BaseException baseEx = MiscUtil.buscarCausa(BaseException.class, ex);
		if (baseEx != null)		{
			manejarExcepcion(baseEx);
		}
		else{
			throw ex;
		}
	}
	
	public static void manejarExcepcion(BaseException ex){
		Severity severity = BaseException.SEVERITY_WARNNIN.equals(ex.getSeverity())?FacesMessage.SEVERITY_WARN : FacesMessage.SEVERITY_ERROR;
		
		FacesMessage message = new FacesMessage(severity, null, ex.getMessage());
		FacesContext.getCurrentInstance().addMessage(null, message);
	}
}
