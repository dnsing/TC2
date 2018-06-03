package arbolgrafico;
import java.awt.Dimension;
import java.awt.Graphics;

public class PanelFondo extends javax.swing.JPanel {

    private String ruta;

    public PanelFondo() {
        initComponents();
        this.setSize(933, 690);
       

    }

    @Override
    public void paintComponent(Graphics g) {
        Dimension tam = getSize();
      
        setOpaque(false);
        super.paintComponent(g);
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 462, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 323, Short.MAX_VALUE)
        );
    }
}
