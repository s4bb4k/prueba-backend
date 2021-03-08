/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.backend.models.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "test_producto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TestProducto.findAll", query = "SELECT t FROM TestProducto t"),
    @NamedQuery(name = "TestProducto.findByIdproducto", query = "SELECT t FROM TestProducto t WHERE t.idproducto = :idproducto"),
    @NamedQuery(name = "TestProducto.findByCodigo", query = "SELECT t FROM TestProducto t WHERE t.codigo = :codigo"),
    @NamedQuery(name = "TestProducto.findByNombre", query = "SELECT t FROM TestProducto t WHERE t.nombre = :nombre"),
    @NamedQuery(name = "TestProducto.findByValorunidad", query = "SELECT t FROM TestProducto t WHERE t.valorunidad = :valorunidad"),
    @NamedQuery(name = "TestProducto.findByStock", query = "SELECT t FROM TestProducto t WHERE t.stock = :stock")})
public class TestProducto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idproducto")
    private Integer idproducto;
    @Basic(optional = false)
    @Column(name = "codigo")
    private String codigo;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "valorunidad")
    private int valorunidad;
    @Basic(optional = false)
    @Column(name = "stock")
    private int stock;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idproducto")
    private Collection<TestFacturaDetalle> testFacturaDetalleCollection;

    public TestProducto() {
    }

    public TestProducto(Integer idproducto) {
        this.idproducto = idproducto;
    }

    public TestProducto(Integer idproducto, String codigo, String nombre, int valorunidad, int stock) {
        this.idproducto = idproducto;
        this.codigo = codigo;
        this.nombre = nombre;
        this.valorunidad = valorunidad;
        this.stock = stock;
    }

    public Integer getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(Integer idproducto) {
        this.idproducto = idproducto;
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

    public int getValorunidad() {
        return valorunidad;
    }

    public void setValorunidad(int valorunidad) {
        this.valorunidad = valorunidad;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @XmlTransient
    public Collection<TestFacturaDetalle> getTestFacturaDetalleCollection() {
        return testFacturaDetalleCollection;
    }

    public void setTestFacturaDetalleCollection(Collection<TestFacturaDetalle> testFacturaDetalleCollection) {
        this.testFacturaDetalleCollection = testFacturaDetalleCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idproducto != null ? idproducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TestProducto)) {
            return false;
        }
        TestProducto other = (TestProducto) object;
        if ((this.idproducto == null && other.idproducto != null) || (this.idproducto != null && !this.idproducto.equals(other.idproducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.mavenproject1.TestProducto[ idproducto=" + idproducto + " ]";
    }
    
}
