/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.exercicio06;

/**
 *
 * @author karla
 */
public class Servidor {
    private String ip;
    private String regiao;
    private String idioma;
    private String link;

    public Servidor(String ip, String regiao, String idioma, String link) {
        this.ip = ip;
        this.regiao = regiao;
        this.idioma = idioma;
        this.link = link;
    }


    public String getIp() {
        return ip;
    }

    public String getRegiao() {
        return regiao;
    }

    public String getIdioma() {
        return idioma;
    }

    public String getLink() {
        return link;
    }

}
