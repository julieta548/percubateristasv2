package com.onclick.moduloA.Entidades;

import javax.persistence.*;

@Entity
public class Contenido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    
    @Lob
    private byte[] archivoPdf;

    private int indice;

    // Constructores
    public Contenido() {
    }

    public Contenido(String titulo, byte[] archivoPdf, int indice) {
        this.titulo = titulo;
        this.archivoPdf = archivoPdf;
        this.indice = indice;
    }

    // Getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public byte[] getArchivoPdf() {
        return archivoPdf;
    }

    public void setArchivoPdf(byte[] archivoPdf) {
        this.archivoPdf = archivoPdf;
    }

    public int getIndice() {
        return indice;
    }

    public void setIndice(int indice) {
        this.indice = indice;
    }

    @Override
    public String toString() {
        return "Contenido{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", archivoPdf=" + archivoPdf +
                ", indice=" + indice +
                '}';
    }
}
