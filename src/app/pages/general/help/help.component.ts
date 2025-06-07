import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';

@Component({
  selector: 'app-help',
  imports: [CommonModule],
  templateUrl: './help.component.html',
  styleUrl: './help.component.css',
})
export class HelpComponent {
  items = [
    {
      pergunta: 'Como criar uma conta?',
      resposta:
        'Para criar uma conta, clique no botão "Registrar" no canto superior direito e preencha o formulário com as informações necessárias.',
    },
    {
      pergunta: 'Como fazer login?',
      resposta:
        'Para fazer login, clique no botão "Login" no canto superior direito e insira seu nome de usuário e senha.',
    },
    {
      pergunta: 'Como recuperar minha senha?',
      resposta:
        'Se você esqueceu sua senha, clique em "Esqueci minha senha" na página de login e siga as instruções.',
    },
    {
      pergunta: 'Como comentar em um jogo?',
      resposta:
        'Para comentar em um jogo, acesse a página do jogo e use a seção de comentários para enviar sua mensagem.',
    },
    {
      pergunta: 'Como visualizar o ranking dos jogos?',
      resposta:
        'Para visualizar o ranking dos jogos, vá para a seção "Ranking" na barra de navegação.',
    },
  ];

  abrirResposta(): void {
    // Função para abrir a resposta de uma pergunta
    
  }
}
