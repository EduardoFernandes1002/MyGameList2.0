package com.mygamelist.backend.jogo;

import java.time.LocalDate;

public record JogoDetalhesDTO(
    Long idJogo,
    String nomeJogo,
    String sinopseJogo,
    String imagemJogo,
    LocalDate dataLancamentoJogo,
    String nomeDesenvolvedora,
    String nomeDistribuidora
) {}
