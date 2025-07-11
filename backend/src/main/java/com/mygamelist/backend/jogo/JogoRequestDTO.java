package com.mygamelist.backend.jogo;

import java.time.LocalDate;
import java.util.List;

public class JogoRequestDTO {

    public String nomeJogo;
    public String sinopseJogo;
    public String imagemJogo;
    public LocalDate dataLancamentoJogo;

    public String nomeDistribuidora;
    public String nomeDesenvolvedora;

    public List<String> generos;
    public List<String> modos;
    public List<String> plataformas;
}

