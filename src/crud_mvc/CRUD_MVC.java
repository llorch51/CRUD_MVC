
package crud_mvc;

import controlador.Controlador_producto;
import modelo.Consultas_producto;
import modelo.Producto;
import vista.Form;

public class CRUD_MVC {

    public static void main(String[] args) {
        Producto prod = new Producto();
        Consultas_producto modC = new Consultas_producto();
        Form form = new Form();
        
        Controlador_producto controlador = new Controlador_producto(prod, modC, form);
        controlador.iniciar();
        form.setVisible(true);
        
    }
    
}
