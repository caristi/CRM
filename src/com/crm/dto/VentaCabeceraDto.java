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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNumVenta() {
		return numVenta;
	}

	public void setNumVenta(String numVenta) {
		this.numVenta = numVenta;
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

	public double getVlrTotalDescuento() {
		return vlrTotalDescuento;
	}

	public void setVlrTotalDescuento(double vlrTotalDescuento) {
		this.vlrTotalDescuento = vlrTotalDescuento;
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

	public List<VentaDetalleDto> getListaDetalles() {
		return listaDetalles;
	}

	public void setListaDetalles(List<VentaDetalleDto> listaDetalles) {
		this.listaDetalles = listaDetalles;
	}

	public int getIdCotizacion() {
		return idCotizacion;
	}

	public void setIdCotizacion(int idCotizacion) {
		this.idCotizacion = idCotizacion;
	}
}