/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.trabalho.controladores;

import br.ufsc.ine5605.trabalho.modelos.Evento;
import br.ufsc.ine5605.trabalho.telas.TelaEvento;
import java.util.ArrayList;

/**
 *
 * @author usuario
 */
public class ControladorEvento {

    ArrayList<Evento> permitidos;
    private ArrayList<Evento> listaNegadoAutorizacao;
    private ArrayList<Evento> listaNegadoMatriculaInexistente;
    private ArrayList<Evento> listaNegadoAcessoBloqueado;
    private ArrayList<Evento> listaNegadoPlacaInexistente;
    private ArrayList<Evento> listaNegadosPorEstarEmprestado;
    private static ControladorEvento instancia;
    private TelaEvento telaRelatorio;

    private ControladorEvento() {
        this.permitidos = new ArrayList<>();
        this.listaNegadoAutorizacao = new ArrayList<>();
        this.listaNegadoMatriculaInexistente = new ArrayList<>();
        this.listaNegadoAcessoBloqueado = new ArrayList<>();
        this.listaNegadoPlacaInexistente = new ArrayList<>();
        this.listaNegadosPorEstarEmprestado = new ArrayList<>();
        telaRelatorio = new TelaEvento(this);
    }

    public static ControladorEvento getInstancia() {
        if (instancia == null) {
            instancia = new ControladorEvento();
        }
        return instancia;
    }

    public void inicia() {
        telaRelatorio.exibeMenuInicial();
    }

    public ArrayList<Evento> getPermitidos() {
        return permitidos;
    }
    
    public void addPermitido(Evento relatorio){
        permitidos.add(relatorio);
    }

    public ArrayList<Evento> getListaNegadoAutorizacao() {
        return listaNegadoAutorizacao;
    }

    public void addListaNegadoAutorizacao(Evento relatorio) {
        listaNegadoAutorizacao.add(relatorio);
    }

    public ArrayList<Evento> getListaNegadoMatriculaInexistente() {
        return listaNegadoMatriculaInexistente;
    }

    public void listaNegadoMatriculaInexistente(Evento relatorio) {
        listaNegadoMatriculaInexistente.add(relatorio);
    }

    public ArrayList<Evento> getListaNegadoAcessoBloqueado() {
        return listaNegadoAcessoBloqueado;
    }

    public void listaNegadoAcessoBloqueado(Evento relatorio) {
        listaNegadoAcessoBloqueado.add(relatorio);
    }

    public ArrayList<Evento> getListaNegadoPlacaInexistente() {
        return listaNegadoPlacaInexistente;
    }

    public void listaNegadoPlacaInexistente(Evento relatorio) {
        listaNegadoPlacaInexistente.add(relatorio);
    }

    public ArrayList<Evento> getListaNegadosPorEstarEmprestado() {
        return listaNegadosPorEstarEmprestado;
    }

    
    
}
