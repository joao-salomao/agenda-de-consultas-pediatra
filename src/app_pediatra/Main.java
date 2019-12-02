/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app_pediatra;

import views.MainFrame;

/**
 *
 * @author João Salomão
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            setLookAndFeel();
            new MainFrame().setVisible(true);
        } catch (Exception e) {
            System.out.println("ERRO AO INICIALIZAR O PROGRAMA: " + e);
            System.exit(1);
        }

    }

    public static void setLookAndFeel() {
        try {
            javax.swing.UIManager.put("Label.font", new java.awt.Font("Arial", java.awt.Font.PLAIN, 14));
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException e) {
            System.out.println("Erro ao setar lookAndFell: " + e);
        }
    }

}
