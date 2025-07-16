import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { JogoService } from '../../../service/jogo-service/jogo.service';

import { ReactiveFormsModule } from '@angular/forms';
import { COMMA, ENTER } from '@angular/cdk/keycodes';
import { FormBuilder, FormGroup } from '@angular/forms';
import { timeout } from 'rxjs';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css'],
  imports: [CommonModule, ReactiveFormsModule],
  standalone: true,
})
export class AdminComponent implements OnInit {
  jogoSelecionado: any = null;
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
        console.log('Jogos carregados:', this.jogos[1]);
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
    this.jogoSelecionado = null;
    this.form.reset();
    this.generos = [];
    this.modos = [];
    this.plataformas = [];
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
        alert('Erro ao adicionar: ' + err.message);
      },
    });
  }

  abrirModalEdicao(jogo: any) {
    this.jogoSelecionado = jogo;
    this.mostrarModal = true;
    this.form.patchValue({
      nomeJogo: jogo.nomeJogo,
      sinopseJogo: jogo.sinopseJogo,
      imagemJogo: jogo.imagemJogo,
      dataLancamentoJogo: jogo.dataLancamentoJogo,
      nomeDistribuidora: jogo.distribuidora?.nomeDistribuidora || '',
      nomeDesenvolvedora: jogo.desenvolvedora?.nomeDesenvolvedora || '',
    });

    console.log('link imagem:', jogo.imagemJogo),
      (this.generos = jogo.generos.map((g: any) => g.nomeGenero || g));
    this.modos = jogo.modos.map((m: any) => m.nomeModo || m);
    this.plataformas = jogo.plataformas.map((p: any) => p.nomePlataforma || p);
  }

  editarJogo(): void {
    if (!this.jogoSelecionado) return;

    const jogoAtualizado = {
      ...this.form.value,
      generos: this.generos,
      modos: this.modos,
      plataformas: this.plataformas,
    };

    this.jogoService
      .editarJogo(this.toSlug(this.jogoSelecionado.nomeJogo), jogoAtualizado)
      .subscribe({
        next: () => {
          this.tipoMensagem = 'sucesso';
          this.mensagem = 'Jogo editado com sucesso!';
          this.fecharModal();
          this.loadAllJogos();
          this.jogoSelecionado = null;
          setTimeout(() => (this.mensagem = ''), 3000);
        },
        error: (err) => {
          alert('Erro ao editar: ' + err.message);
        },
      });
  }

  public toSlug = (nomeJogo: string): string => {
    return nomeJogo ? nomeJogo.toLowerCase().replace(/\s+/g, '-') : '';
  };
}
