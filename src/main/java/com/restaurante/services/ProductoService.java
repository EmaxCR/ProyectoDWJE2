/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.restaurante.services;

import com.restaurante.domain.Producto;
import java.util.List;

/**
 *
 * @author Usuario
 */
public interface ProductoService {
  //Se recupera los registros de la tabla producto en un 
    //ArrayList depbjetos Producto. Todos o solo los activos
    public List<Producto> getProductos(boolean activos);
    
    public Producto getProducto(Producto producto);
    
    public void delete(Producto producto);
    
    public void save(Producto producto);
}
