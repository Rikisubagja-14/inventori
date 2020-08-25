/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stokgudang.client.lap.path;

import java.io.InputStream;

/**
 *
 * @author Riki subagja
 */
public class directori {
    public InputStream getPath(String file){
            return getClass().getClassLoader().
                        getResourceAsStream("stokgudang/client/laporan/"+file+".jasper");
    }
}
