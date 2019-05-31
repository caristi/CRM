package com.crm.converter;

import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.crm.bean.CotizacionBean;
import com.crm.dto.ProductoDto;

@SuppressWarnings("rawtypes")
@FacesConverter("productoConverter")
public class ProductoConverter implements Converter{
	
	@Override
	public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
		
		ProductoDto retorno = null;
		
		if(value != null && !value.isEmpty()) {
            try {
                FacesContext context = FacesContext.getCurrentInstance();
                CotizacionBean cotizacionBean = (CotizacionBean) context.getELContext().getELResolver().getValue(context.getELContext(), null, "cotizacionBean");
            	List<ProductoDto> listaProducto = cotizacionBean.getListaProductos();
            	if(listaProducto != null){
            		retorno = new ProductoDto();
            		retorno.setId(Integer.parseInt(value));
            		
            		int index = listaProducto.indexOf(retorno);
            		
            		if(index > -1){
            			retorno = listaProducto.get(index);
            		}
            	}
            } catch(NumberFormatException e) {
            	
            }
        }
		
		return retorno;
	}

	@Override
	public String getAsString(FacesContext fc, UIComponent uic, Object object) {
		String retorno = null;
		if(object != null) {
			ProductoDto productoDto = ((ProductoDto) object);
			if(productoDto.getId() > 0){
				retorno = String.valueOf(productoDto.getId());
			}
        }
		
		return retorno;
	} 

}
