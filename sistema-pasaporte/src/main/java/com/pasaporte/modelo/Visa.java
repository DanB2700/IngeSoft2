package com.pasaporte.modelo;

public class Visa {
    private int id;
    private String tipo;
    private Pais pais; // país destino (opcional)

    public Visa() {}
    public Visa(int id, String tipo){ this.id=id; this.tipo=tipo; }
    public Visa(String tipo){ this.tipo=tipo; }
    public Visa(String tipo, Pais pais){ this.tipo=tipo; this.pais=pais; }

    public int getId(){ return id; }
    public void setId(int id){ this.id=id; }
    public String getTipo(){ return tipo; }
    public void setTipo(String tipo){ this.tipo=tipo; }
    public Pais getPais(){ return pais; }
    public void setPais(Pais pais){ this.pais=pais; }

    @Override public String toString(){ return "Visa{id="+id+", tipo='"+tipo+"', pais="+pais+"}"; }
}
