/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WS;

import Entidad.Autor;
import Entidad.Categoria;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 *
 * @author FERNANDO
 */
public class ConsumidorApi {
 
    public List<Autor> listarAutor(String url){
        List<Autor> lista = new ArrayList<Autor>();
        Autor autor;
        PeticionWS ws = new PeticionWS();
        //invocar apiconsumer
        String data = ws.consumirWs(url);

        try {
            JSONParser parser = new JSONParser();

            JSONArray arreglo = new JSONArray(data);
            JSONObject json;
            for(int i=0; i<arreglo.length(); i++){
                json = arreglo.getJSONObject(i);
                System.out.println("autor -> "+json.getString("nombre_autor"));
                System.out.println("autor -> "+json.getInt("id_autor"));
                autor = new Autor();
                autor.setEstado(json.getInt("estado_autor"));
                autor.setIdAutor(json.getInt("id_autor"));
                autor.setNombreAutor(json.getString("nombre_autor"));
                lista.add(autor);
            }
        } catch (Exception e) {
            System.out.println("error casting json -> " + e);
        }
        
        return lista;
    }
    
    public List<Categoria> listarCategoria(String url){
        List<Categoria> lista = new ArrayList<Categoria>();
        Categoria categ;
        PeticionWS ws = new PeticionWS();
        //invocar apiconsumer
        String data = ws.consumirWs(url);

        try {
            JSONParser parser = new JSONParser();

            JSONArray arreglo = new JSONArray(data);
            JSONObject json;
            for(int i=0; i<arreglo.length(); i++){
                json = arreglo.getJSONObject(i);
                
                categ = new Categoria();
                categ.setEstado(json.getInt("estado_categoria"));
                categ.setIdCategoria(json.getInt("id_categoria"));
                categ.setCategoria(json.getString("nombre_categoria"));
                lista.add(categ);
            }
        } catch (Exception e) {
            System.out.println("error casting json -> " + e);
        }
        
        return lista;
    }
    
    
}
