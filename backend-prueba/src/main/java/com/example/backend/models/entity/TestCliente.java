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
@Table(name = "test_cliente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TestCliente.findAll", query = "SELECT t FROM TestCliente t"),
    @NamedQuery(name = "TestCliente.findByIdcliente", query = "SELECT t FROM TestCliente t WHERE t.idcliente = :idcliente"),
    @NamedQuery(name = "TestCliente.findByIdentifiacion", query = "SELECT t FROM TestCliente t WHERE t.identifiacion = :identifiacion"),
    @NamedQuery(name = "TestCliente.findByNombres", query = "SELECT t FROM TestCliente t WHERE t.nombres = :nombres"),
    @NamedQuery(name = "TestCliente.findByApellidos", query = "SELECT t FROM TestCliente t WHERE t.apellidos = :apellidos"),
    @NamedQuery(name = "TestCliente.findByDireccion", query = "SELECT t FROM TestCliente t WHERE t.direccion = :direccion"),
    @NamedQuery(name = "TestCliente.findByTelefono", query = "SELECT t FROM TestCliente t WHERE t.telefono = :telefono"),
    @NamedQuery(name = "TestCliente.findByEmail", query = "SELECT t FROM TestCliente t WHERE t.email = :email")})
public class TestCliente implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcliente")
    private Integer idcliente;
    @Basic(optional = false)
    @Column(name = "identifiacion")
    private int identifiacion;
    @Basic(optional = false)
    @Column(name = "nombres")
    private String nombres;
    @Basic(optional = false)
    @Column(name = "apellidos")
    private String apellidos;
    @Basic(optional = false)
    @Column(name = "direccion")
    private String direccion;
    @Column(name = "telefono")
    private String telefono;
    @Column(name = "email")
    private String email;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idcliente")
    private Collection<TestFactura> testFacturaCollection;

    public TestCliente() {
    }

    public TestCliente(Integer idcliente) {
        this.idcliente = idcliente;
    }

    public TestCliente(Integer idcliente, int identifiacion, String nombres, String apellidos, String direccion) {
        this.idcliente = idcliente;
        this.identifiacion = identifiacion;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.direccion = direccion;
    }

    public Integer getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(Integer idcliente) {
        this.idcliente = idcliente;
    }

    public int getIdentifiacion() {
        return identifiacion;
    }

    public void setIdentifiacion(int identifiacion) {
        this.identifiacion = identifiacion;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @XmlTransient
    public Collection<TestFactura> getTestFacturaCollection() {
        return testFacturaCollection;
    }

    public void setTestFacturaCollection(Collection<TestFactura> testFacturaCollection) {
        this.testFacturaCollection = testFacturaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcliente != null ? idcliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TestCliente)) {
            return false;
        }
        TestCliente other = (TestCliente) object;
        if ((this.idcliente == null && other.idcliente != null) || (this.idcliente != null && !this.idcliente.equals(other.idcliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.mavenproject1.TestCliente[ idcliente=" + idcliente + " ]";
    }
    
}
