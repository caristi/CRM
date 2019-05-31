package com.crm.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.primefaces.model.UploadedFile;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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
