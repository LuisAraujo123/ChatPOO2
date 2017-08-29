/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.modelos;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author bernardo
 */
@Entity
@Table(name = "respuestas", catalog = "proyecto01", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Respuestas.findAll", query = "SELECT r FROM Respuestas r")
    , @NamedQuery(name = "Respuestas.findByCodiResp", query = "SELECT r FROM Respuestas r WHERE r.codiResp = :codiResp")
    , @NamedQuery(name = "Respuestas.findConver", query = "SELECT r FROM Respuestas r WHERE r.codiConv = :codiConv")
    , @NamedQuery(name = "Respuestas.findByFechHoraResp", query = "SELECT r FROM Respuestas r WHERE r.fechHoraResp = :fechHoraResp")})
public class Respuestas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codi_resp")
    private Integer codiResp;
    @Basic(optional = false)
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "mens_resp")
    private String mensResp;
    @Basic(optional = false)
    @Column(name = "fech_hora_resp")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechHoraResp;
    @JoinColumn(name = "codi_usua_resp", referencedColumnName = "codi_usua")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Usuarios codiUsuaResp;
    @JoinColumn(name = "codi_conv", referencedColumnName = "codi_conv")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Conversaciones codiConv;

    public Respuestas() {
    }

    public Respuestas(Integer codiResp) {
        this.codiResp = codiResp;
    }

    public Respuestas(Integer codiResp, String mensResp, Date fechHoraResp) {
        this.codiResp = codiResp;
        this.mensResp = mensResp;
        this.fechHoraResp = fechHoraResp;
    }

    public Integer getCodiResp() {
        return codiResp;
    }

    public void setCodiResp(Integer codiResp) {
        this.codiResp = codiResp;
    }

    public String getMensResp() {
        return mensResp;
    }

    public void setMensResp(String mensResp) {
        this.mensResp = mensResp;
    }

    public Date getFechHoraResp() {
        return fechHoraResp;
    }

    public void setFechHoraResp(Date fechHoraResp) {
        this.fechHoraResp = fechHoraResp;
    }

    public Usuarios getCodiUsuaResp() {
        return codiUsuaResp;
    }

    public void setCodiUsuaResp(Usuarios codiUsuaResp) {
        this.codiUsuaResp = codiUsuaResp;
    }

    public Conversaciones getCodiConv() {
        return codiConv;
    }

    public void setCodiConv(Conversaciones codiConv) {
        this.codiConv = codiConv;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codiResp != null ? codiResp.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Respuestas)) {
            return false;
        }
        Respuestas other = (Respuestas) object;
        if ((this.codiResp == null && other.codiResp != null) || (this.codiResp != null && !this.codiResp.equals(other.codiResp))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sv.udb.modelos.Respuestas[ codiResp=" + codiResp + " ]";
    }
    
}
