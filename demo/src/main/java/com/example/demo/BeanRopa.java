package com.example.demo;

public class BeanRopa {
    private long id;

    private String nombre;
    private BeanTipo tipo;
    private BeanCategoria categoria;
    private double precio;
    private String talla;
    private String marca;
    private String tela;
    private int stock;
    private String fechregistro;
    private String estado;

    public BeanRopa(){}

    public BeanRopa(long id, String nombre, BeanTipo tipo, BeanCategoria categoria, double precio, String talla, String marca, String tela, int stock, String fechregistro, String estado) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.categoria = categoria;
        this.precio = precio;
        this.talla = talla;
        this.marca = marca;
        this.tela = tela;
        this.stock = stock;
        this.fechregistro = fechregistro;
        this.estado = estado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public BeanTipo getTipo() {
        return tipo;
    }

    public void setTipo(BeanTipo tipo) {
        this.tipo = tipo;
    }

    public BeanCategoria getCategoria() {
        return categoria;
    }

    public void setCategoria(BeanCategoria categoria) {
        this.categoria = categoria;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getTalla() {
        return talla;
    }

    public void setTalla(String talla) {
        this.talla = talla;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getTela() {
        return tela;
    }

    public void setTela(String tela) {
        this.tela = tela;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getFechregistro() {
        return fechregistro;
    }

    public void setFechregistro(String fechregistro) {
        this.fechregistro = fechregistro;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
