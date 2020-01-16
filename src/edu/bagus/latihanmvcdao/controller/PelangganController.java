/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.bagus.latihanmvcdao.controller;

import edu.bagus.latihanmvcdao.model.PelangganModel;
import edu.bagus.latihanmvcdao.view.PelangganView;
import javax.swing.JOptionPane;

/**
 *	
 * @author
 * NIM      : 10118052
 * NAMA     : BAGUS SYIBRO MALISI
 * KELAS    : IF-2
 * 
 */
public class PelangganController {
    private PelangganModel model;

    public void setModel(PelangganModel model) {
        this.model = model;
    }
    
    public void resetPelanggan(PelangganView view) {
        model.resetPelanggan();
    }
    
    public void insertPelanggan(PelangganView view) {
        String nama = view.getTxtNama().getText();
        String alamat = view.getTxtAlamat().getText();
        String telepon = view.getTxtTelepon().getText();
        String email = view.getTxtEmail().getText();
        
        if(nama.trim().isEmpty()) {
            JOptionPane.showMessageDialog(view, "Nama tidak boleh kosong");
        } else if(nama.length() > 255) {
            JOptionPane.showMessageDialog(view, "Nama tidak boleh lebih dari 255 karakter");
        } else if(telepon.length() > 12) {
            JOptionPane.showMessageDialog(view, "Telepon tidak boleh lebih dari 12 karakter");
        } else if(alamat.length() > 255) {
            JOptionPane.showMessageDialog(view, "Alamat tidak boleh lebih dari 255 karakter");
        } else if(!email.contains("@") || !email.contains(".")) {
            JOptionPane.showMessageDialog(view, "Format email tidak valid");
        } else {
            model.setNama(nama);
            model.setAlamat(alamat);
            model.setTelepon(telepon);
            model.setEmail(email);
            
            try {
                model.insertPelanggan();
                JOptionPane.showMessageDialog(view, "Pelanggan berhasil ditambahkan");
                model.resetPelanggan();
            } catch (Throwable e) {
                JOptionPane.showMessageDialog(view, new Object[]{"Terjadi Error di database dengan pesan ", e.getMessage()});
            }
        }
    }
    
    public void updatePelanggan(PelangganView view) {
        
        if(view.getTablePelanggan().getSelectedRowCount() == 0) {
            JOptionPane.showMessageDialog(view, "Silahkan seleksi baris data yang akan diubah");
            return;
        }
        
        Integer id = Integer.parseInt(view.getTxtId().getText());
        String nama = view.getTxtNama().getText();
        String alamat = view.getTxtAlamat().getText();
        String telepon = view.getTxtTelepon().getText();
        String email = view.getTxtEmail().getText();
        
        if(nama.trim().isEmpty()) {
            JOptionPane.showMessageDialog(view, "Nama tidak boleh kosong");
        } else if(nama.length() > 255) {
            JOptionPane.showMessageDialog(view, "Nama tidak boleh lebih dari 255 karakter");
        } else if(telepon.length() > 12) {
            JOptionPane.showMessageDialog(view, "Telepon tidak boleh lebih dari 12 karakter");
        } else if(alamat.length() > 255) {
            JOptionPane.showMessageDialog(view, "Alamat tidak boleh lebih dari 255 karakter");
        } else if(!email.contains("@") || !email.contains(".")) {
            JOptionPane.showMessageDialog(view, "Format email tidak valid");
        } else {
            model.setId(id);
            model.setNama(nama);
            model.setAlamat(alamat);
            model.setTelepon(telepon);
            model.setEmail(email);
            
            try {
                model.updatePelanggan();
                JOptionPane.showMessageDialog(view, "Pelanggan berhasil diubah");
                model.resetPelanggan();
            } catch (Throwable e) {
                JOptionPane.showMessageDialog(view, new Object[]{"Terjadi Error di database dengan pesan ", e.getMessage()});
            }
        }
    }
    
    public void deletePelanggan(PelangganView view) {
        if(view.getTablePelanggan().getSelectedRowCount() == 0) {
            JOptionPane.showMessageDialog(view, "Silahkan seleksi baris data yang akan dihapus");
            return;
        }
        
        if(JOptionPane.showConfirmDialog(view, "Anda yakin akan menghapus?") == JOptionPane.OK_OPTION) {
            Integer id = Integer.parseInt(view.getTxtId().getText());
            model.setId(id);
            
            try {
                model.deletePelanggan();
                JOptionPane.showMessageDialog(view, "Pelanggan berhasil dihapus");
                model.resetPelanggan();
            } catch (Throwable e) {
                JOptionPane.showMessageDialog(view, new Object[]{"Terjadi Error di database dengan pesan ", e.getMessage()});
            }
        }
    }
}
