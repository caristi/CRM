package com.crm.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="cabecera_factura")
public class FacturaCabeceraDto implements java.io.Serializable  {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cab_id")
	private int id;

	@Column(name="cab_num_factura")
	private String numFactura;

	@Column(name="cab_fecha")
	private Date fechaFactura;
	
	@Column(name="cab_vlr_iva")
	private double vlrIva;
	
    @Column(name="cab_vlr_sub_total")
    private double vlrSubTotal;
    
    @Column(name="cab_vlr_total")
    private double vlrTotal;
    
    @Column(name="cab_observacion")
    private String observacion;
    
//    cli_id
    
//    private List<FacturaDetalleDto> listaDetalleFactura;

	public FacturaCabeceraDto() {
		
	}

}
