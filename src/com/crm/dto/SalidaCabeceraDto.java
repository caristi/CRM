package com.crm.dto;

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

import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name="salida")
@DynamicUpdate
public class SalidaCabeceraDto implements java.io.Serializable  {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="sal_id")
	private int id;

	@Column(name="sal_fecha")
	private Date fecha;
	
	@Column(name="sal_mca_completada")
	private char mcaCompletada;
	
    @Column(name="sal_observacion")
    private String observacion;
    
	@Column(name="sal_pct_avance")
	private float pctEnviado;

    @ManyToOne
    @JoinColumn(name="cli_id")
    private ClienteDto clienteDto;
    
    @ManyToOne
    @JoinColumn(name="usu_id")
    private UsuarioDto usuarioDto;
    
    @Column(name="bod_id")
    private int bodegaId;
    
    @Column(name="ven_id")
    private int ventaId;
    
    @OneToMany(cascade= CascadeType.ALL)
    @JoinColumn(name="sal_id")
    private List<SalidaDetalleDto> listaDetalles;
    
    @Transient
	private boolean isSeleccionTodos;
    
    public SalidaCabeceraDto() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public char getMcaCompletada() {
		return mcaCompletada;
	}

	public void setMcaCompletada(char mcaCompletada) {
		this.mcaCompletada = mcaCompletada;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public float getPctEnviado() {
		return pctEnviado;
	}

	public void setPctEnviado(float pctEnviado) {
		this.pctEnviado = pctEnviado;
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

	public int getBodegaId() {
		return bodegaId;
	}

	public void setBodegaId(int bodegaId) {
		this.bodegaId = bodegaId;
	}

	public int getVentaId() {
		return ventaId;
	}

	public void setVentaId(int ventaId) {
		this.ventaId = ventaId;
	}

	public List<SalidaDetalleDto> getListaDetalles() {
		return listaDetalles;
	}

	public void setListaDetalles(List<SalidaDetalleDto> listaDetalles) {
		this.listaDetalles = listaDetalles;
	}

	public boolean isSeleccionTodos() {
		return isSeleccionTodos;
	}

	public void setSeleccionTodos(boolean isSeleccionTodos) {
		this.isSeleccionTodos = isSeleccionTodos;
	}
}