/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.restaurante.services.impl;

import com.restaurante.dao.ProductoDao;
import com.restaurante.domain.Producto;
import com.restaurante.services.ProductoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Usuario
 */
@Service
public class ProductoServiceimpl implements ProductoService {

    @Autowired
    private ProductoDao productoDao;

    @Override
    public List<Producto> getProductos(boolean activos) {
        var lista = productoDao.findAll();

        if (activos) {//si solo quiero activos}
            lista.removeIf(c -> !c.isActivo());
        }

        return lista;
    }
    @Override
    public Producto getProducto(Producto producto) {

        return productoDao.findById(producto.getIdProducto()).orElse(null);
    }
    @Override
    public void delete(Producto producto) {
        productoDao.delete(producto);
    }
    @Override

    public void save(Producto producto) {
        productoDao.save(producto);
    }
}
