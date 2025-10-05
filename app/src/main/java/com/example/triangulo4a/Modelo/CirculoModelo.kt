package com.example.triangulo4a.Modelo
import com.example.triangulo4a.Contratos.ContratoCirculo

class CirculoModelo: ContratoCirculo.Modelo {
    override fun area(radio: Float): Float {
        return 3.1416f*radio*radio;
    }
    override fun perimetro(radio: Float): Float {
        return 2*3.1416f*radio;
    }
    override fun valida(radio: Float): Boolean {
        if(radio>0) {
            return true;
        }
        else {
            return false;
        }
    }
}