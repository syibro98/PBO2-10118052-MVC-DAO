/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.bagus.latihanmvcdao.event;

import edu.bagus.latihanmvcdao.entity.Pelanggan;
import edu.bagus.latihanmvcdao.model.PelangganModel;

/**
 *	
 * @author
 * NIM      : 10118052
 * NAMA     : BAGUS SYIBRO MALISI
 * KELAS    : IF-2
 * 
 */
public interface PelangganListener {
    
    public void onChange(PelangganModel model);
    
    public void onInsert(Pelanggan pelanggan);
    
    public void onUpdate(Pelanggan pelanggan);
    
    public void onDelete();
    
}
