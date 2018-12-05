package com.crm.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.primefaces.model.UploadedFile;

@Entity
@Table(name="producto")
public class ProductoDto implements java.io.Serializable{
	
	private static final long serialVersionUID = 1;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="pro_id")
	private int id;

	@Column(name="pro_referencia")
	private String codigo;
	
	@Column(name="pro_nombre")
	private String nombre;
	
	@Column(name="pro_cantidad")
	private int cantidad;
	
	@Column(name="pro_ruta_imagen")
	private String rutaArchivo;
	
	@Column(name="pro_descripcion")
	private String descripcion;
	
	@Column(name="pro_vlr_costo")
	private double vlrCosto;
	
	@Column(name="pro_pct_iva")
	private double pct_iva;
	
	@Column(name="pro_vlr_venta")
	private double vlrVenta;
	
	@Column(name="pro_unidad_medida")
	private String unidadMedida;
	
	@Column(name="pro_material")
	private String material;
	
	@Transient
	private UploadedFile imagenProducto;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public String getRutaArchivo() {
		return rutaArchivo;
	}

	public void setRutaArchivo(String rutaArchivo) {
		this.rutaArchivo = rutaArchivo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getVlrCosto() {
		return vlrCosto;
	}

	public void setVlrCosto(double vlrCosto) {
		this.vlrCosto = vlrCosto;
	}

	public double getPct_iva() {
		return pct_iva;
	}

	public void setPct_iva(double pct_iva) {
		this.pct_iva = pct_iva;
	}

	public double getVlrVenta() {
		return vlrVenta;
	}

	public void setVlrVenta(double vlrVenta) {
		this.vlrVenta = vlrVenta;
	}

	public String getUnidadMedida() {
		return unidadMedida;
	}

	public void setUnidadMedida(String unidadMedida) {
		this.unidadMedida = unidadMedida;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public UploadedFile getImagenProducto() {
		return imagenProducto;
	}

	public void setImagenProducto(UploadedFile imagenProducto) {
		this.imagenProducto = imagenProducto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductoDto other = (ProductoDto) obj;
		if (id != other.id)
			return false;
		return true;
	}
}
