/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package traitement;

import connexion.Connexion;
import static connexion.Connexion.cx;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JTable;
import javax.swing.JTextField;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Soft developpers
 */
public class Traitement {
 
    PreparedStatement ps;
    ResultSet rs;

    public void chargement(JTable d) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (;;) {
                    try {
                        Thread.sleep(1000);
                        ps = cx().prepareStatement(" select * from tpresence");
                        //select Ref_P as [REFERENCE], CODE AS [MATRICULE], DATE_Presence AS [DATE],Heure_dArriver as [HEURE], heure_de_sortie as H_Sortie from tpresence group by Ref_P,code,date_presence,Heure_dArriver,heure_de_sortie
                        rs = ps.executeQuery();
                        d.setModel(DbUtils.resultSetToTableModel(rs));
                    } catch (Exception e) {
                    }
                }
            }
        }).start();
    }

    public void savePresece(JTextField code, JTable tab) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (;;) {
                    try {
                        ps = cx().prepareCall("exec p_presence ?");
                        ps.setString(1, code.getText());
                        if (!(code.getText().isEmpty())) {
                            Thread.sleep(7000);
                            ps.execute();
                           // chargement(tab);
                        }
                    } catch (Exception e) {
                    }
                }
            }
        }).start();
    }
}
