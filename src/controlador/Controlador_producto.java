
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.Consultas_producto;
import modelo.Producto;
import vista.Form;


public class Controlador_producto implements ActionListener{
    private Producto mod;
    private Consultas_producto modC;
    private Form form;

    public Controlador_producto(Producto mod, Consultas_producto modC, Form form) {
        this.mod = mod;
        this.modC = modC;
        this.form = form;
        
        this.form.btnGuardar.addActionListener(this);
        this.form.btnModificar.addActionListener(this);
        this.form.btnEliminar.addActionListener(this);
        this.form.btnLimpiar.addActionListener(this);
        this.form.btnBuscar.addActionListener(this);
        
        
    }
    
    public void iniciar(){
        form.setTitle("Productos");
        form.setLocationRelativeTo(null);
        form.txtID.setVisible(false);
    }
    //para mandarle los valores de txtbox a las instancias de producto
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == form.btnGuardar){
            mod.setCodigo(form.txtCodigo.getText());
            mod.setNombre(form.txtNombre.getText().toUpperCase());
            mod.setPrecio(Double.parseDouble(form.txtPrecio.getText()));
            mod.setCantidad(Integer.parseInt(form.txtCantidad.getText()));
            
            if(modC.registrar(mod)){
                JOptionPane.showMessageDialog(null, "Registro guardado");
                limpiar();
            }else{
                JOptionPane.showMessageDialog(null, "Error al guardar");
                limpiar();
            }
        }
        
        if(e.getSource() == form.btnModificar){
            mod.setId(Integer.parseInt(form.txtID.getText()));
            mod.setCodigo(form.txtCodigo.getText());
            mod.setNombre(form.txtNombre.getText().toUpperCase());
            mod.setPrecio(Double.parseDouble(form.txtPrecio.getText()));
            mod.setCantidad(Integer.parseInt(form.txtCantidad.getText()));
            
            if(modC.modificar(mod)){
                JOptionPane.showMessageDialog(null, "Registro modificado");
                limpiar();
            }else{
                JOptionPane.showMessageDialog(null, "Error al modificar");
                limpiar();
            }
        }
        
         if(e.getSource() == form.btnEliminar){
            mod.setId(Integer.parseInt(form.txtID.getText()));
//            mod.setCodigo(form.txtCodigo.getText());
//            mod.setNombre(form.txtNombre.getText());
//            mod.setPrecio(Double.parseDouble(form.txtCodigo.getText()));
//            mod.setCantidad(Integer.parseInt(form.txtCodigo.getText()));
            
            if(modC.eliminar(mod)){
                JOptionPane.showMessageDialog(null, "Registro eliminado");
                limpiar();
            }else{
                JOptionPane.showMessageDialog(null, "Error al eliminar");
                limpiar();
            }
        }
         
         if(e.getSource() == form.btnBuscar){
//            mod.setId(Integer.parseInt(form.txtID.getText()));
            mod.setCodigo(form.txtCodigo.getText());
//            mod.setNombre(form.txtNombre.getText());
//            mod.setPrecio(Double.parseDouble(form.txtCodigo.getText()));
//            mod.setCantidad(Integer.parseInt(form.txtCodigo.getText()));
            
            if(modC.buscar(mod)){
                form.txtID.setText(String.valueOf(mod.getId()));
                form.txtCodigo.setText(mod.getCodigo());
                form.txtNombre.setText(mod.getNombre());
                form.txtPrecio.setText(String.valueOf(mod.getPrecio()));
                form.txtCantidad.setText(String.valueOf(mod.getCantidad()));
                
            }else{
                JOptionPane.showMessageDialog(null, "No se encontro registro");
                limpiar();
            }
        }
         
         if(e.getSource() == form.btnLimpiar){
             limpiar();
         }
    }
    
    public void limpiar(){
        form.txtID.setText("");
        form.txtNombre.setText("");
        form.txtPrecio.setText("");
        form.txtCantidad.setText("");
        form.txtCodigo.setText("");
    }
    
}
