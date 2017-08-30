/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.modelos;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author bernardo
 */
@Entity
@Table(name = "conversaciones", catalog = "proyecto01", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Conversaciones.findAll", query = "SELECT c FROM Conversaciones c")
    , @NamedQuery(name = "Conversaciones.findByCodiConv", query = "SELECT c FROM Conversaciones c WHERE c.codiConv = :codiConv")
    , @NamedQuery(name = "Conversaciones.findByTempConv", query = "SELECT c FROM Conversaciones c WHERE c.tempConv = :tempConv")})
public class Conversaciones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codi_conv")
    private Integer codiConv;
    @Basic(optional = false)
    @Column(name = "temp_conv")
    @Temporal(TemporalType.TIMESTAMP)
    private Date tempConv;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codiConv", fetch = FetchType.LAZY)
    private List<Respuestas> respuestasList;
    @JoinColumn(name = "usua_uno", referencedColumnName = "codi_usua")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Usuarios usuaUno;
    @JoinColumn(name = "usua_dos", referencedColumnName = "codi_usua")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Usuarios usuaDos;

    public Conversaciones() {
    }

    public Conversaciones(Integer codiConv) {
        this.codiConv = codiConv;
    }

    public Conversaciones(Integer codiConv, Date tempConv) {
        this.codiConv = codiConv;
        this.tempConv = tempConv;
    }

    public Integer getCodiConv() {
        return codiConv;
    }

    public void setCodiConv(Integer codiConv) {
        this.codiConv = codiConv;
    }

    public Date getTempConv() {
        return tempConv;
    }

    public void setTempConv(Date tempConv) {
        this.tempConv = tempConv;
    }

    @XmlTransient
    public List<Respuestas> getRespuestasList() {
        return respuestasList;
    }

    public void setRespuestasList(List<Respuestas> respuestasList) {
        this.respuestasList = respuestasList;
    }

    public Usuarios getUsuaUno() {
        return usuaUno;
    }

    public void setUsuaUno(Usuarios usuaUno) {
        this.usuaUno = usuaUno;
    }

    public Usuarios getUsuaDos() {
        return usuaDos;
    }

    public void setUsuaDos(Usuarios usuaDos) {
        this.usuaDos = usuaDos;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codiConv != null ? codiConv.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Conversaciones)) {
            return false;
        }
        Conversaciones other = (Conversaciones) object;
        if ((this.codiConv == null && other.codiConv != null) || (this.codiConv != null && !this.codiConv.equals(other.codiConv))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ir";
    }
    
}
