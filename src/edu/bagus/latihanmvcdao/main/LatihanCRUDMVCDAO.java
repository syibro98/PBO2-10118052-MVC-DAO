/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.bagus.latihanmvcdao.main;

import edu.bagus.latihanmvcdao.database.KingBarbershopDatabase;
import edu.bagus.latihanmvcdao.entity.Pelanggan;
import edu.bagus.latihanmvcdao.error.PelangganException;
import edu.bagus.latihanmvcdao.service.PelangganDao;
import edu.bagus.latihanmvcdao.view.MainViewPelanggan;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;

/**
 *	
 * @author
 * NIM      : 10118052
 * NAMA     : BAGUS SYIBRO MALISI
 * KELAS    : IF-2
 * 
 */
public class LatihanCRUDMVCDAO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws PelangganException, SQLException {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    MainViewPelanggan pelanggan = new MainViewPelanggan();
                    pelanggan.loadDatabase();
                    pelanggan.setVisible(true);
                } catch (SQLException e) {
                } catch (PelangganException ex) {
                    Logger.getLogger(LatihanCRUDMVCDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
}
