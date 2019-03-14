package com.crm.util;

public final class MiscUtil{

	private MiscUtil(){
		
	}
	
	public static <T extends Exception> T buscarCausa(Class<T> clase, Exception ex){
		
		T exception = null;
		Throwable cause = ex.getCause();
		while ((cause != null && cause != cause.getCause()) && exception == null)
		{
			if (clase.isInstance(cause))
			{
				exception = clase.cast(cause);
			}

			cause = cause.getCause();
		}

		return exception;
	}
}
