package br.edu.cairu.app.web.integra.cairu.projetos.database.dbclass;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "anexo")

public class Anexo implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idarquivos;
    private String end_arq;

    public void Anexo(){
        
    }
    
    public Integer getIdarquivos() {
        return idarquivos;
    }

    public void setIdarquivos(Integer idarquivos) {
        this.idarquivos = idarquivos;
    }

    public String getEnd_arq() {
        return end_arq;
    }

    public void setEnd_arq(String end_arq) {
        this.end_arq = end_arq;
    }
    
    
    
}
