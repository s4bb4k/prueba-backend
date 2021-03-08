/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.backend.models.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "test_factura_detalle")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TestFacturaDetalle.findAll", query = "SELECT t FROM TestFacturaDetalle t"),
    @NamedQuery(name = "TestFacturaDetalle.findByIdfacturadetalle", query = "SELECT t FROM TestFacturaDetalle t WHERE t.idfacturadetalle = :idfacturadetalle"),
    @NamedQuery(name = "TestFacturaDetalle.findByCantidad", query = "SELECT t FROM TestFacturaDetalle t WHERE t.cantidad = :cantidad"),
    @NamedQuery(name = "TestFacturaDetalle.findByValorunidad", query = "SELECT t FROM TestFacturaDetalle t WHERE t.valorunidad = :valorunidad"),
    @NamedQuery(name = "TestFacturaDetalle.findByValortotal", query = "SELECT t FROM TestFacturaDetalle t WHERE t.valortotal = :valortotal")})
public class TestFacturaDetalle implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idfacturadetalle")
    private Integer idfacturadetalle;
    @Basic(optional = false)
    @Column(name = "cantidad")
    private int cantidad;
    @Basic(optional = false)
    @Column(name = "valorunidad")
    private int valorunidad;
    @Basic(optional = false)
    @Column(name = "valortotal")
    private int valortotal;
    @JoinColumn(name = "idfactura", referencedColumnName = "idfactura")
    @ManyToOne(optional = false)
    private TestFactura idfactura;
    @JoinColumn(name = "idproducto", referencedColumnName = "idproducto")
    @ManyToOne(optional = false)
    private TestProducto idproducto;

    public TestFacturaDetalle() {
    }

    public TestFacturaDetalle(Integer idfacturadetalle) {
        this.idfacturadetalle = idfacturadetalle;
    }

    public TestFacturaDetalle(Integer idfacturadetalle, int cantidad, int valorunidad, int valortotal) {
        this.idfacturadetalle = idfacturadetalle;
        this.cantidad = cantidad;
        this.valorunidad = valorunidad;
        this.valortotal = valortotal;
    }

    public Integer getIdfacturadetalle() {
        return idfacturadetalle;
    }

    public void setIdfacturadetalle(Integer idfacturadetalle) {
        this.idfacturadetalle = idfacturadetalle;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getValorunidad() {
        return valorunidad;
    }

    public void setValorunidad(int valorunidad) {
        this.valorunidad = valorunidad;
    }

    public int getValortotal() {
        return valortotal;
    }

    public void setValortotal(int valortotal) {
        this.valortotal = valortotal;
    }

    public TestFactura getIdfactura() {
        return idfactura;
    }

    public void setIdfactura(TestFactura idfactura) {
        this.idfactura = idfactura;
    }

    public TestProducto getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(TestProducto idproducto) {
        this.idproducto = idproducto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idfacturadetalle != null ? idfacturadetalle.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TestFacturaDetalle)) {
            return false;
        }
        TestFacturaDetalle other = (TestFacturaDetalle) object;
        if ((this.idfacturadetalle == null && other.idfacturadetalle != null) || (this.idfacturadetalle != null && !this.idfacturadetalle.equals(other.idfacturadetalle))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.mavenproject1.TestFacturaDetalle[ idfacturadetalle=" + idfacturadetalle + " ]";
    }
    
}
