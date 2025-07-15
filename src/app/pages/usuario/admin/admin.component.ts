import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { JogoService } from '../../../service/jogo-service/jogo.service';

import { ReactiveFormsModule } from '@angular/forms';
import { COMMA, ENTER } from '@angular/cdk/keycodes';
import { FormBuilder, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css'],
  imports: [CommonModule, ReactiveFormsModule],
  standalone: true,
})
export class AdminComponent implements OnInit {
  separatorKeysCodes = [ENTER, COMMA] as const;
  form!: FormGroup;
  mensagem: string = '';
  tipoMensagem: 'sucesso' | 'erro' | '' = '';

  // Formulário do jogo
  jogos: any[] = [];
  usuarios: any[] = [];

  generos: string[] = [];
  modos: string[] = [];
  plataformas: string[] = [];
  mostrarModal: boolean = false;

  constructor(private jogoService: JogoService, private fb: FormBuilder) {}
  ngOnInit(): void {
    this.loadAllJogos();
    this.form = this.fb.group({
      nomeJogo: [''],
      sinopseJogo: [''],
      imagemJogo: [''],
      dataLancamentoJogo: [''],
      nomeDistribuidora: [''],
      nomeDesenvolvedora: [''],
    });
  }

  loadAllJogos(): void {
    this.jogoService.getJogos().subscribe({
      next: (data: any) => {
        this.jogos = data.content || data;
      },
      error: (error: any) => {
        console.error('Erro ao carregar top 5:', error);
      },
    });
  }

  //Logica adicioanar jogo

  abrirModal() {
    this.mostrarModal = true;
  }

  fecharModal() {
    this.mostrarModal = false;
  }

  addGenero(event: KeyboardEvent): void {
    if (event.key === ',') {
      event.preventDefault();
      const input = event.target as HTMLInputElement;
      const value = input.value.trim();

      if (value && !this.generos.includes(value)) {
        this.generos.push(value);
      }

      input.value = '';
    }
  }

  removeGenero(genero: string): void {
    this.generos = this.generos.filter((g) => g !== genero);
  }

  addModo(event: KeyboardEvent): void {
    if (event.key === ',') {
      event.preventDefault();
      const input = event.target as HTMLInputElement;
      const value = input.value.trim();

      if (value && !this.modos.includes(value)) {
        this.modos.push(value);
      }

      input.value = '';
    }
  }

  removeModo(modo: string): void {
    this.modos = this.modos.filter((m) => m !== modo);
  }

  addPlataforma(event: KeyboardEvent): void {
    if (event.key === ',') {
      event.preventDefault();
      const input = event.target as HTMLInputElement;
      const value = input.value.trim();

      if (value && !this.plataformas.includes(value)) {
        this.plataformas.push(value);
      }

      input.value = '';
    }
  }

  removePlataforma(plataforma: string): void {
    this.plataformas = this.plataformas.filter((p) => p !== plataforma);
  }

  adicionarJogo(): void {
    const jogo = {
      ...this.form.value,
      generos: this.generos,
      modos: this.modos,
      plataformas: this.plataformas,
    };

    console.log('Jogo a ser adicionado:', jogo);

    this.jogoService.adicionarJogo(jogo).subscribe({
      next: (res: any) => {
        this.tipoMensagem = 'sucesso';
        this.mensagem = res;

        this.fecharModal();
        this.form.reset();
        this.generos = [];
        this.modos = [];
        this.plataformas = [];

        setTimeout(() => (this.mensagem = ''), 3000); // limpa mensagem após 3s
      },
      error: (err) => {
        this.tipoMensagem = 'erro';

        let mensagemErro = 'Erro desconhecido';

        if (err.error) {
          if (typeof err.error === 'string') {
            mensagemErro = err.error; // já é texto simples
          } else if (typeof err.error === 'object') {
            // tenta extrair mensagem, se existir
            mensagemErro = err.error.message || JSON.stringify(err.error);
          }
        } else if (err.message) {
          mensagemErro = err.message;
        }

        this.mensagem = 'Erro ao adicionar jogo: ' + mensagemErro;

        setTimeout(() => (this.mensagem = ''), 5000);
      },
    });
  }
}
