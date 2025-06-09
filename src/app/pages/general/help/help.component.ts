import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-help',
  imports: [CommonModule, FormsModule],
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
    {
      pergunta: 'Como adicionar um jogo à minha lista?',
      resposta:
        'Para adicionar um jogo à sua lista, acesse a página do jogo e clique no botão "Adicionar à minha lista".',
    },
    {
      pergunta: 'Como editar meu perfil?',
      resposta:
        'Para editar seu perfil, clique em "Configurações" no canto superior direito.',
    },
    {
      pergunta: 'Como excluir minha conta?',
      resposta:
        'Para excluir sua conta, entre nas configurações da conta e clique em "Excluir Conta".'
    },
    {
      pergunta: 'Por que não consigo encontrar um jogo específico?',
      resposta: 'O jogo pode não estar listado no nosso banco de dados. Você pode sugerir um jogo que ainda não está disponível.',
    },
    {
      pergunta: 'Como posso entrar em contato com o suporte?',
      resposta:
        'Para entrar em contato com o suporte, envie um e-mail para o endereço de suporte fornecido no fim da pagina.',
    },
  ];

  pesquisarPergunta: string = '';
  paginaAtual: number = 1;
  maxItensPagina: number = 3;

  get filteredItems() {
    let filtrado = this.items;
    if (this.pesquisarPergunta.trim()) {
      filtrado = filtrado.filter(item =>
        item.pergunta.toLowerCase().includes(this.pesquisarPergunta.toLowerCase())
      );
    }
    const inicio = (this.paginaAtual - 1) * this.maxItensPagina;
    return filtrado.slice(inicio, inicio + this.maxItensPagina);
  }

  get totalPages() {
    return Math.ceil(
      (this.pesquisarPergunta.trim()
        ? this.items.filter(item =>
            item.pergunta.toLowerCase().includes(this.pesquisarPergunta.toLowerCase())
          ).length
        : this.items.length) / this.maxItensPagina
    );
  }

  goToPage(page: number) {
    this.paginaAtual = page;
  }
}
