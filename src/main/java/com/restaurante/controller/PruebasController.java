package com.restaurante.controller;

import com.restaurante.controller.*;
import com.restaurante.domain.Categoria;
import com.restaurante.domain.Producto;
import com.restaurante.services.CategoriaService;
import com.restaurante.services.ProductoService;
import com.restaurante.services.FirebaseStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import com.restaurante.services.CategoriaService;

@Controller
@RequestMapping("/pruebas")
public class PruebasController {

    @Autowired
    private ProductoService productoServices;
    @Autowired
    private CategoriaService categoriaServices;

    @GetMapping("/listado")
    public String listado(Model model) {

        var productos = productoServices.getProductos(false);
        model.addAttribute("productos", productos);
        
        var categorias = categoriaServices.getCategorias(false);
        model.addAttribute("categorias", categorias);
        
        return "/pruebas/listado";

    }
    @GetMapping("/listado/{idCategoria}")
    public String listado(Categoria producto, Model model) {
        var productos = categoriaServices.getCategoria(producto).getProductos();
        model.addAttribute("productos", productos);
        var categorias = categoriaServices.getCategorias(false);
        model.addAttribute("categorias", categorias);
        return "/pruebas/listado";
    }
}
