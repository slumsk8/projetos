package br.edu.cairu.app.web.integra.cairu.projetos.database.dbclass;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity
@Table(name = "anexo")
@NamedQueries(@NamedQuery(name = "Anexo.findAll",query = "SELECT a FROM Anexo a"))
public class Anexo implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "idanexo")
    private Long idarquivos;
    
    @Column (length = 255,unique = true)
    private String descricao;
    
    @Lob
    private byte [] arquivo;

    public Long getIdarquivos() {
        return idarquivos;
    }

    public void setIdarquivos(Long idarquivos) {
        this.idarquivos = idarquivos;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public byte[] getArquivo() {
        return arquivo;
    }

    public void setArquivo(byte[] arquivo) {
        this.arquivo = arquivo;
    }

    
    

}
