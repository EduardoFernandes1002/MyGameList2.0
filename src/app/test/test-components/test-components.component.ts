import { Component, OnInit } from '@angular/core';
import { GameCardComponent } from '../../component/game-card/game-card.component';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { JogoService } from '../../service/jogo-service/jogo.service';
import { ComentarioService } from '../../service/comentario-service/comentario.service';
import { CategoriaService } from '../../service/categoria-service/categoria.service';

@Component({
  selector: 'app-test-components',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './test-components.component.html',
  styleUrl: './test-components.component.css',
})
export class TestComponentsComponent implements OnInit {

  // Emote Component testados e funcionando:                               "✔️"

  // Emote Component não testado, não implementado ou não iniciado:        "❌"

  // Emote Componente testado, quase funcionando ou ajustes necessários:   "⚠️"

  /**
   *
   *  Game Card Component para HOME TOP 5 testado!                       ||  ✔️
   *  Game Card Component para HOME OUTROS não iniciado!                 ||  ❌
   *  Game Card Component para RANK GERAL testado, quase funcionando!    ||  ⚠️
   *  Rank Geral Component testado, preicsa ajustes!                     ||  ⚠️
   *  Perfil Component não testado, não implementado completamente!      ||  ❌
   *  Info Game Component testado, quase funcionando!                    ||  ⚠️
   *  Discover Component não testado, não iniciado!                      ||  ❌
   *  Recomendado Component não testado, não iniciado!                   ||  ❌
   *  Category Component não testado, não iniciado!                      ||  ❌
   *  Ajuda Component testado, completo!                                 ||  ✔️
   *  Config Component não testado, não iniciado!                        ||  ❌
   *  Login Component testado, completo!                                 ||  ✔️
   *  Register Component testado, completo!                              ||  ✔️
   *  Admin Component não testado, não iniciado!                         ||  ❌
   *  Navbar Component testado, completo!                                ||  ✔️
   *  Footer Component testado, completo!                                ||  ✔️
   *  Test Components Component testado, completo!                       ||  ✔️
   *  Comentario Component para visualização, ajustes gerais!            ||  ⚠️
   *  Comentario Component para AVALIAÇÃO, não implementado!             ||  ❌
   *
   **/

  // ------------------- Area de testes, caso funcionando apagar! ------------------- //

  /**
   * 
   *  Test Components Component é um componente de teste para verificar/mudar se os componentes estao funcionando corretamente ou
   *  se precisam de ajustes. Ele importa os serviços necessários e contem a maioria dos imports necessarios para o funcionamento
   * 
   **/

  constructor(private jogoService: JogoService, private comentarioService: ComentarioService, private categoriaService: CategoriaService) {}

  ngOnInit(): void {}

  
}
