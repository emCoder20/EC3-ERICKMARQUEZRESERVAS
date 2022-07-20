package com.idat.EC3ERICKMARQUEZRESERVAS.DTO;

public class HospitalRequest {

    private Integer idHospital;
    private String nombre;
    private String direccion;
    private Integer distrito;

    public Integer getIdHospital() {
        return idHospital;
    }

    public void setIdHospital(Integer idHospital) {
        this.idHospital = idHospital;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Integer getDistrito() {
        return distrito;
    }

    public void setDistrito(Integer distrito) {
        this.distrito = distrito;
    }
}
