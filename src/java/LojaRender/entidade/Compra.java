/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LojaRender.entidade;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Maurício
 */
@Entity
@Table(name = "compra")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Compra.findAll", query = "SELECT c FROM Compra c"),
    @NamedQuery(name = "Compra.findByIdCompra", query = "SELECT c FROM Compra c WHERE c.idCompra = :idCompra"),
    @NamedQuery(name = "Compra.findByProduto", query = "SELECT c FROM Compra c WHERE c.produto = :produto"),
    @NamedQuery(name = "Compra.findByValor", query = "SELECT c FROM Compra c WHERE c.valor = :valor"),
    @NamedQuery(name = "Compra.findByDataCompra", query = "SELECT c FROM Compra c WHERE c.dataCompra = :dataCompra")})
public class Compra implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idCompra")
    private Integer idCompra;
    @Basic(optional = false)
    @Column(name = "produto")
    private String produto;
    @Basic(optional = false)
    @Column(name = "valor")
    private float valor;
    @Basic(optional = false)
    @Column(name = "dataCompra")
    @Temporal(TemporalType.DATE)
    private Date dataCompra;
    @JoinColumn(name = "cliente_cpf", referencedColumnName = "cpf")
    @ManyToOne(optional = false)
    private Cliente clienteCpf;

    public Compra() {
    }

    public Compra(Integer idCompra) {
        this.idCompra = idCompra;
    }

    public Compra(Integer idCompra, String produto, float valor, Date dataCompra) {
        this.idCompra = idCompra;
        this.produto = produto;
        this.valor = valor;
        this.dataCompra = dataCompra;
    }

    public Integer getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(Integer idCompra) {
        this.idCompra = idCompra;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public Date getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(Date dataCompra) {
        this.dataCompra = dataCompra;
    }

    public Cliente getClienteCpf() {
        return clienteCpf;
    }

    public void setClienteCpf(Cliente clienteCpf) {
        this.clienteCpf = clienteCpf;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCompra != null ? idCompra.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Compra)) {
            return false;
        }
        Compra other = (Compra) object;
        if ((this.idCompra == null && other.idCompra != null) || (this.idCompra != null && !this.idCompra.equals(other.idCompra))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "LojaRender.entidade.Compra[ idCompra=" + idCompra + " ]";
    }
    
}
