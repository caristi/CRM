package com.crm.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="venta_cabecera")
public class VentaCabeceraDto implements java.io.Serializable  {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ven_id")
	private int id;

	@Column(name="ven_num")
	private String numVenta;

	@Column(name="ven_fecha")
	private Date fecha;
	
	@Column(name="ven_vlr_iva_total")
	private double vlrIvaTotal;
	
    @Column(name="ven_vlr_sub_total")
    private double vlrSubTotal;
    
    @Column(name="ven_vlr_total")
    private double vlrTotal;
    
    @Column(name="ven_vlr_descuento")
    private double vlrTotalDescuento;
    
    @Column(name="ven_observacion")
    private String observacion;

    @ManyToOne
    @JoinColumn(name="cli_id")
    private ClienteDto clienteDto;
    
    @ManyToOne
    @JoinColumn(name="usu_id")
    private UsuarioDto usuarioDto;
    
    @OneToMany(cascade= CascadeType.ALL)
    @JoinColumn(name="ven_id")
    private List<VentaDetalleDto> listaDetalles;
    
    @Column(name="cot_id")
    private int idCotizacion;
    
    public VentaCabeceraDto() {
		
    	clienteDto = new ClienteDto();
		usuarioDto = new UsuarioDto();
		
		VentaDetalleDto detalle = new VentaDetalleDto();
		listaDetalles = new ArrayList<VentaDetalleDto>();
		listaDetalles.add(detalle);
	}

}