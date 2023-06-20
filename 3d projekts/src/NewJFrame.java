
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;
import static java.lang.Math.sqrt;

public class NewJFrame extends javax.swing.JFrame {

    double[][] koordinatas = new double[37*25][3];
    double[][] koordinataspec = new double[37*25][3];
    double[][] projekcijasm = {{1, 0}, {0, 1}, {0.5, 0.866025404}}; //0.5, 0.866025404  0, 1
    double[][] rotacijasm = {{0,0,0},{0,0,0},{0,0,0}};
    double[][] attels = new double[37*25][2];

    public NewJFrame() {
        initComponents();
        
        //genere koordinatas
        for (int i = 0; i <= 36; i = i + 1) {
            for (int j = 0; j <= 24; j = j + 1) {
                koordinatas[j*36+i][0] = (i-18)*10;
                koordinatas[j*36+i][1] = 40 * Math.sin(0.043 * sqrt(Math.pow((i - 18)*10, 2) + Math.pow((j - 12)*10, 2)));
                koordinatas[j*36+i][2] = (j-12)*10;
            }
        }
        sliders();
        
    }
    
    public double [][] reizina (double[][] punkts, double[][] reiz){
        int r = punkts.length;
        int k = reiz[0].length;
        double[][] result = new double [r][k];
        for(int i = 0; i < r; i++){
            for(int j = 0; j < k; j++){
                result[i][j]=0;
                for(int t = 0; t<3; t++){
                    result[i][j]+=punkts[i][t]*reiz[t][j];
                }
            }
        }
        return result;
    }
    
    public void ziimee() {
        
        Graphics2D g = (Graphics2D) this.getGraphics();
        g.setColor(Color.green);
        
        for (int i = 0; i <= 36; i = i + 1) {
            for (int j = 0; j <= 24; j = j + 1) {
                g.drawRect((int)( attels[j*36+i][0] * -1 + 400), (int) (attels[j*36+i][1] * -1 + 400), 1, 1);
            }
        }
        
    }
    
    public void polygons() {
        
        attels=reizina(koordinataspec,projekcijasm);
        
        Graphics2D g = (Graphics2D) this.getGraphics();
        g.clearRect(0,0,700,700);
        g.setColor(Color.pink);
        
        for (int i = 1; i < 36; i++) {
            for (int j = 0; j < 24; j++) {
                Polygon pol=new Polygon(); 
                pol.addPoint((int)( (attels[j*36+i][0] * -1 )*jSlider1.getValue()/100) + 300,(int) ((attels[j*36+i][1] * -1 )*jSlider1.getValue()/100)+ 300); 
                pol.addPoint((int)( (attels[j*36+i+1][0] * -1 )*jSlider1.getValue()/100)+ 300,(int) ((attels[j*36+i+1][1] * -1 )*jSlider1.getValue()/100)+ 300);
                pol.addPoint((int)( (attels[(j+1)*36+i+1][0] * -1 )*jSlider1.getValue()/100)+ 300,(int) ((attels[(j+1)*36+i+1][1] * -1 )*jSlider1.getValue()/100)+ 300);
                pol.addPoint((int)( (attels[(j+1)*36+i][0] * -1 )*jSlider1.getValue()/100)+ 300,(int) ((attels[(j+1)*36+i][1] * -1 )*jSlider1.getValue()/100)+ 300);
                g.fillPolygon(pol);
                g.setColor(Color.black);
                g.drawPolygon(pol);
                g.setColor(Color.pink);
            }
        }
        
    }
    
    public void sliders (){
        double a=(double)xAss.getValue() / 100;
        double b=(double)yAss.getValue()/100;
        double c=(double)zAss.getValue()/100;

        rotacijasm[0][0] = Math.cos(b)*Math.cos(c);
        rotacijasm[0][1] = Math.sin(a)*Math.sin(b)*Math.cos(c)-Math.cos(a)*Math.sin(c);
        rotacijasm[0][2] = Math.cos(a)*Math.sin(b)*Math.cos(c)+Math.sin(a)*Math.sin(c);
        rotacijasm[1][0] = Math.cos(b)*Math.sin(c);
        rotacijasm[1][1] = Math.sin(a)*Math.sin(b)*Math.sin(c)+Math.cos(a)*Math.cos(c);
        rotacijasm[1][2] = Math.cos(a)*Math.sin(b)*Math.sin(c)-Math.sin(a)*Math.cos(c);
        rotacijasm[2][0] = -Math.sin(b);
        rotacijasm[2][1] = Math.sin(a)*Math.cos(b);
        rotacijasm[2][2] = Math.cos(a)*Math.cos(b);
        koordinataspec=reizina(koordinatas, rotacijasm);

        }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        xAss = new javax.swing.JSlider();
        yAss = new javax.swing.JSlider();
        zAss = new javax.swing.JSlider();
        jSlider1 = new javax.swing.JSlider();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Zīmēt");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        xAss.setMaximum(314);
        xAss.setMinimum(-314);
        xAss.setValue(0);
        xAss.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                xAssStateChanged(evt);
            }
        });

        yAss.setMaximum(314);
        yAss.setMinimum(-314);
        yAss.setValue(0);
        yAss.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                yAssStateChanged(evt);
            }
        });

        zAss.setMaximum(314);
        zAss.setMinimum(-314);
        zAss.setValue(0);
        zAss.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                zAssStateChanged(evt);
            }
        });

        jSlider1.setMaximum(125);
        jSlider1.setMinimum(1);
        jSlider1.setValue(100);
        jSlider1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSlider1StateChanged(evt);
            }
        });

        jLabel1.setText("Rotēt ap X asi");

        jLabel2.setText("Rotēt ap Y asi");

        jLabel3.setText("Rotēt ap Z asi");

        jLabel4.setText("Zoom");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 761, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4)
                    .addComponent(yAss, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(xAss, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(jSlider1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(zAss, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(xAss, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(yAss, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(zAss, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(272, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        polygons();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void xAssStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_xAssStateChanged
        sliders();
        polygons();
    }//GEN-LAST:event_xAssStateChanged

    private void yAssStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_yAssStateChanged
        sliders();
        polygons();
    }//GEN-LAST:event_yAssStateChanged

    private void zAssStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_zAssStateChanged
        sliders();
        polygons();
    }//GEN-LAST:event_zAssStateChanged

    private void jSlider1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSlider1StateChanged
        polygons();
    }//GEN-LAST:event_jSlider1StateChanged

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JSlider jSlider1;
    private javax.swing.JSlider xAss;
    private javax.swing.JSlider yAss;
    private javax.swing.JSlider zAss;
    // End of variables declaration//GEN-END:variables
}
