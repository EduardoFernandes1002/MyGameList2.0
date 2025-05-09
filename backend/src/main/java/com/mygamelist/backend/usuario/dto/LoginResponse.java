package com.mygamelist.backend.usuario.dto;

import com.mygamelist.backend.usuario.Usuario;

public record LoginResponse(Usuario usuario, String token) {
    
}
