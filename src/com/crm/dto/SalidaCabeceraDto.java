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

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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
	
	@Column(name="sal_estado")
	private String estado;

    @ManyToOne
    @JoinColumn(name="cli_id",nullable = false)
    private ClienteDto clienteDto;
    
    @ManyToOne
    @JoinColumn(name="usu_id",nullable = false)
    private UsuarioDto usuarioDto;
    
    @Column(name="bod_id")
    private int bodegaId;
    
    @Column(name="ven_id",nullable = false)
    private int ventaId;
    
    @OneToMany(cascade= CascadeType.ALL)
    @JoinColumn(name="sal_id")
    private List<SalidaDetalleDto> listaDetalles;
    
    @Transient
	private boolean isSeleccionTodos;
    
    public SalidaCabeceraDto() {
		
	}

}