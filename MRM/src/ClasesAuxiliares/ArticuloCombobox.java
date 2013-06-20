/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ClasesAuxiliares;

import Interfaz.Articulos;
import JdbcCustomDatum.*;
import java.util.ArrayList;

/**
 *
 * @author Carlos Basso
 */
public class ArticuloCombobox {

    private Articulo articulo;
    private String titulo;
    private ArrayList<Autor> autores = new ArrayList();
    private ArrayList<Virus> virus = new ArrayList();
    private ArrayList<Articulo> art_ref = new ArrayList();
    private ArrayList<Articulo> ref_en_art = new ArrayList();

    public ArticuloCombobox(Articulo a, String titu, ArrayList<Autor> au, ArrayList<Virus> vir,
            ArrayList<Articulo> art_r, ArrayList<Articulo> r_en_art) {
        titulo = titu;
        articulo = a;
        autores = au;
        virus = vir;
        art_ref = art_r;
        ref_en_art = r_en_art;
    }

    @Override
    public String toString() {
        return titulo;

    }

    public Articulo getArticulo() {
        return articulo;
    }

    public String getTitulo() {
        return titulo;
    }

    public ArrayList<Autor> getAutores() {
        return autores;
    }

    public ArrayList<Virus> getVirus() {
        return virus;
    }

    public ArrayList<Articulo> getArtRef() {
        return art_ref;
    }

    public ArrayList<Articulo> getRefEnArt() {
        return ref_en_art;
    }
}
