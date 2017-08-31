/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.modelos;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author bernardo
 */
@Entity
@Table(name = "usuarios", catalog = "proyecto01", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuarios.findAll", query = "SELECT u FROM Usuarios u")
    , @NamedQuery(name = "Usuarios.findByCodiUsua", query = "SELECT u FROM Usuarios u WHERE u.codiUsua = :codiUsua")
    , @NamedQuery(name = "Usuarios.findByNombUsua", query = "SELECT u FROM Usuarios u WHERE u.nombUsua = :nombUsua")
    , @NamedQuery(name = "Usuarios.findByMailUsua", query = "SELECT u FROM Usuarios u WHERE u.mailUsua = :mailUsua")
    , @NamedQuery(name = "Usuarios.findByContUsua", query = "SELECT u FROM Usuarios u WHERE u.contUsua = :contUsua")
    , @NamedQuery(name = "Usuarios.findByConvList", query = "SELECT u FROM Usuarios u WHERE u.conversacionesList = :convUsua")})
public class Usuarios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codi_usua")
    private Integer codiUsua;
    @Basic(optional = false)
    @Size(min = 1, max = 30)
    @Column(name = "nomb_usua")
    private String nombUsua;
    @Basic(optional = false)
    @Size(min = 1, max = 60)
    @Column(name = "mail_usua")
    private String mailUsua;
    @Basic(optional = false)
    @Size(min = 1, max = 30)
    @Column(name = "cont_usua")
    private String contUsua;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codiUsuaResp", fetch = FetchType.LAZY)
    private List<Respuestas> respuestasList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuaUno", fetch = FetchType.LAZY)
    private List<Conversaciones> conversacionesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuaDos", fetch = FetchType.LAZY)
    private List<Conversaciones> conversacionesList1;

    public Usuarios() {
    }

    public Usuarios(Integer codiUsua) {
        this.codiUsua = codiUsua;
    }

    public Usuarios(Integer codiUsua, String nombUsua, String mailUsua, String contUsua) {
        this.codiUsua = codiUsua;
        this.nombUsua = nombUsua;
        this.mailUsua = mailUsua;
        this.contUsua = contUsua;
    }

    public Integer getCodiUsua() {
        return codiUsua;
    }

    public void setCodiUsua(Integer codiUsua) {
        this.codiUsua = codiUsua;
    }

    public String getNombUsua() {
        return nombUsua;
    }

    public void setNombUsua(String nombUsua) {
        this.nombUsua = nombUsua;
    }

    public String getMailUsua() {
        return mailUsua;
    }

    public void setMailUsua(String mailUsua) {
        this.mailUsua = mailUsua;
    }

    public String getContUsua() {
        return contUsua;
    }

    public void setContUsua(String contUsua) {
        this.contUsua = contUsua;
    }

    @XmlTransient
    public List<Respuestas> getRespuestasList() {
        return respuestasList;
    }

    public void setRespuestasList(List<Respuestas> respuestasList) {
        this.respuestasList = respuestasList;
    }

    @XmlTransient
    public List<Conversaciones> getConversacionesList() {
        return conversacionesList;
    }

    public void setConversacionesList(List<Conversaciones> conversacionesList) {
        this.conversacionesList = conversacionesList;
    }

    @XmlTransient
    public List<Conversaciones> getConversacionesList1() {
        return conversacionesList1;
    }

    public void setConversacionesList1(List<Conversaciones> conversacionesList1) {
        this.conversacionesList1 = conversacionesList1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codiUsua != null ? codiUsua.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuarios)) {
            return false;
        }
        Usuarios other = (Usuarios) object;
        if ((this.codiUsua == null && other.codiUsua != null) || (this.codiUsua != null && !this.codiUsua.equals(other.codiUsua))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sv.udb.modelos.Usuarios[ codiUsua=" + codiUsua + " ]";
    }
    
}
