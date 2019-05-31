package com.crm.bean;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.crm.dto.FiltroBusquedaDto;
import com.crm.dto.ProductoDto;
import com.crm.services.ProductoSrv;
import com.crm.util.BundleUtils;

@Component
@Named
public class ProductoBean {

	@Autowired
	private ProductoSrv productoSrv;
	
	private ProductoDto productoDto;
	private ProductoDto productoSelecDto;
	private FiltroBusquedaDto filtro;
	
	private List<ProductoDto> listaProductos;
	
	private boolean mostrarImaggen;
	private boolean mcaEditar;
	
	private UploadedFile file;
	private String filePath;
	
	public ProductoBean() {
		
		productoDto = new ProductoDto();
		filtro = new FiltroBusquedaDto();
		mcaEditar = false;
		
		filePath = BundleUtils.getString("com.crm.util.aplicacion", "app.ruta");
	}
	
	public void guardarProducto(){
		
		int id = productoSrv.guardarProducto(productoDto);
		cargarImagen();
		
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Se guardo el producto con código " + id));
	}
	
	public void consultarProducto(){
		
		listaProductos = productoSrv.buscarProducto(filtro);
		 
		if(listaProductos == null || listaProductos.size() == 0){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "", "No se encontraron registros con ese filtro"));
		}else{
			filtro = new FiltroBusquedaDto();
		}
	}
	
	public String consultarUnProducto(){
		this.mcaEditar = true;
		this.productoDto = productoSelecDto;
		
		return "producto";
	}
	
	public String nuevoProducto(){
		this.mcaEditar = false;
		this.productoDto = new ProductoDto();
		
		return "producto";
	}
	
	public void actualizar(){
		
		productoSrv.actualizarProducto(productoDto);

		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Se actualizo el producto"));
	}
	
	public void handleFileUpload(FileUploadEvent event) {
		file = event.getFile();
    }
	
	public void cargarImagen() {
        
        try {
			String filePath = BundleUtils.getString("com.crm.util.aplicacion", "app.ruta");
			
			String fileName = file.getFileName();
			File uploads = new File(filePath); //Carpeta donde se guardan los archivos
			uploads.mkdirs(); //Crea los directorios necesarios
			File file1 = null;

			file1 = File.createTempFile("cod-", "-"+fileName, uploads);
			InputStream input = file.getInputstream();
			Files.copy(input, file1.toPath(), StandardCopyOption.REPLACE_EXISTING);
			
			this.productoDto.setRutaArchivo(file1.getName());
			
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
	
	public String irVistaCompras(ProductoDto productoDto){
		
		FacesContext context = FacesContext.getCurrentInstance();
		CompraBean compraBean = (CompraBean) context.getELContext().getELResolver().getValue(context.getELContext(), null, "compraBean");
		compraBean.inicializarCompra(productoDto);
		
		return "compra";
	}
	
	
	public void setProductoSrv(ProductoSrv productoSrv) {
		this.productoSrv = productoSrv;
	}
	
	public ProductoDto getProductoDto() {
		return productoDto;
	}
	
	public void setProductoDto(ProductoDto productoDto) {
		this.productoDto = productoDto;
	}

	public List<ProductoDto> getListaProductos() {
		return listaProductos;
	}

	public void setListaProductos(List<ProductoDto> listaProductos) {
		this.listaProductos = listaProductos;
	}

	public UploadedFile getFile() {
		return file;
	}

	public void setFile(UploadedFile file) {
		this.file = file;
	}

	public boolean isMostrarImaggen() {
		return mostrarImaggen;
	}

	public void setMostrarImaggen(boolean mostrarImaggen) {
		this.mostrarImaggen = mostrarImaggen;
	}

	public ProductoDto getProductoSelecDto() {
		return productoSelecDto;
	}

	public void setProductoSelecDto(ProductoDto productoSelecDto) {
		this.productoSelecDto = productoSelecDto;
	}

	public boolean isMcaEditar() {
		return mcaEditar;
	}

	public void setMcaEditar(boolean mcaEditar) {
		this.mcaEditar = mcaEditar;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public FiltroBusquedaDto getFiltro() {
		return filtro;
	}
}