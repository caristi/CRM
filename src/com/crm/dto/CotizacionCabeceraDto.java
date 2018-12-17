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
import javax.persistence.Transient;

@Entity
@Table(name="cotizacion")
public class CotizacionCabeceraDto implements java.io.Serializable  {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cot_id")
	private int id;

	@Column(name="cot_num")
	private String numCotizacion;

	@Column(name="cot_fecha")
	private Date fecha;
	
	@Column(name="cot_vlr_iva_total")
	private double vlrIvaTotal;
	
    @Column(name="cot_vlr_sub_total")
    private double vlrSubTotal;
    
    @Column(name="cot_vlr_total")
    private double vlrTotal;
    
    @Column(name="cot_observacion")
    private String observacion;
    
    @Transient
    private double vlrTotalDescuento;
    
    @ManyToOne
    @JoinColumn(name="cli_id")
    private ClienteDto clienteDto;
    
    @ManyToOne
    @JoinColumn(name="usu_id")
    private UsuarioDto usuarioDto;
    
    @OneToMany(cascade= CascadeType.ALL)
    @JoinColumn(name="cot_id")
    private List<CotizacionDetalleDto> listaDetalles;
    
    public CotizacionCabeceraDto() {
		
    	clienteDto = new ClienteDto();
		usuarioDto = new UsuarioDto();
		
		CotizacionDetalleDto detalle = new CotizacionDetalleDto();
		listaDetalles = new ArrayList<CotizacionDetalleDto>();
		listaDetalles.add(detalle);
	}
    
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNumCotizacion() {
		return numCotizacion;
	}

	public void setNumCotizacion(String numCotizacion) {
		this.numCotizacion = numCotizacion;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public double getVlrIvaTotal() {
		return vlrIvaTotal;
	}

	public void setVlrIvaTotal(double vlrIvaTotal) {
		this.vlrIvaTotal = vlrIvaTotal;
	}

	public double getVlrSubTotal() {
		return vlrSubTotal;
	}

	public void setVlrSubTotal(double vlrSubTotal) {
		this.vlrSubTotal = vlrSubTotal;
	}

	public double getVlrTotal() {
		return vlrTotal;
	}

	public void setVlrTotal(double vlrTotal) {
		this.vlrTotal = vlrTotal;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public ClienteDto getClienteDto() {
		return clienteDto;
	}

	public void setClienteDto(ClienteDto clienteDto) {
		this.clienteDto = clienteDto;
	}

	public UsuarioDto getUsuarioDto() {
		return usuarioDto;
	}

	public void setUsuarioDto(UsuarioDto usuarioDto) {
		this.usuarioDto = usuarioDto;
	}

	public List<CotizacionDetalleDto> getListaDetalles() {
		return listaDetalles;
	}

	public void setListaDetalles(List<CotizacionDetalleDto> listaDetalles) {
		this.listaDetalles = listaDetalles;
	}

	public double getVlrTotalDescuento() {
		return vlrTotalDescuento;
	}

	public void setVlrTotalDescuento(double vlrTotalDescuento) {
		this.vlrTotalDescuento = vlrTotalDescuento;
	}
}