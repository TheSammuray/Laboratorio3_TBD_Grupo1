package com.TBD.SistemaVoluntarios.Controller;

import com.TBD.SistemaVoluntarios.Entity.Producto;
import com.TBD.SistemaVoluntarios.Repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private ProductoRepository productoRepository;

    @GetMapping
    public List<Producto> obtenerTodosLosProductos() {
        return productoRepository.findAll();
    }

    @PostMapping
    public Producto crearProducto(@RequestBody Producto producto) {
        System.out.println("Producto recibido: " + producto.toString());
        return productoRepository.save(producto);
    }
}
