/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.backend.models.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "test_factura")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TestFactura.findAll", query = "SELECT t FROM TestFactura t"),
    @NamedQuery(name = "TestFactura.findByIdfactura", query = "SELECT t FROM TestFactura t WHERE t.idfactura = :idfactura"),
    @NamedQuery(name = "TestFactura.findByFechaventa", query = "SELECT t FROM TestFactura t WHERE t.fechaventa = :fechaventa"),
    @NamedQuery(name = "TestFactura.findByValortotal", query = "SELECT t FROM TestFactura t WHERE t.valortotal = :valortotal")})
public class TestFactura implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idfactura")
    private Integer idfactura;
    @Basic(optional = false)
    @Column(name = "fechaventa")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaventa;
    @Basic(optional = false)
    @Column(name = "valortotal")
    private int valortotal;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idfactura")
    private Collection<TestFacturaDetalle> testFacturaDetalleCollection;
    @JoinColumn(name = "idcliente", referencedColumnName = "idcliente")
    @ManyToOne(optional = false)
    private TestCliente idcliente;

    public TestFactura() {
    }

    public TestFactura(Integer idfactura) {
        this.idfactura = idfactura;
    }

    public TestFactura(Integer idfactura, Date fechaventa, int valortotal) {
        this.idfactura = idfactura;
        this.fechaventa = fechaventa;
        this.valortotal = valortotal;
    }

    public Integer getIdfactura() {
        return idfactura;
    }

    public void setIdfactura(Integer idfactura) {
        this.idfactura = idfactura;
    }

    public Date getFechaventa() {
        return fechaventa;
    }

    public void setFechaventa(Date fechaventa) {
        this.fechaventa = fechaventa;
    }

    public int getValortotal() {
        return valortotal;
    }

    public void setValortotal(int valortotal) {
        this.valortotal = valortotal;
    }

    @XmlTransient
    public Collection<TestFacturaDetalle> getTestFacturaDetalleCollection() {
        return testFacturaDetalleCollection;
    }

    public void setTestFacturaDetalleCollection(Collection<TestFacturaDetalle> testFacturaDetalleCollection) {
        this.testFacturaDetalleCollection = testFacturaDetalleCollection;
    }

    public TestCliente getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(TestCliente idcliente) {
        this.idcliente = idcliente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idfactura != null ? idfactura.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TestFactura)) {
            return false;
        }
        TestFactura other = (TestFactura) object;
        if ((this.idfactura == null && other.idfactura != null) || (this.idfactura != null && !this.idfactura.equals(other.idfactura))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.mavenproject1.TestFactura[ idfactura=" + idfactura + " ]";
    }
    
}
