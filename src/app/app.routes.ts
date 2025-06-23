import { Routes } from '@angular/router';
import { HomeComponent } from './pages/geral/home/home.component';
import { PerfilComponent } from './pages/usuario/perfil/perfil.component';
import { InfoGameComponent } from './pages/jogo/info-game/info-game.component';
import { RankComponent } from './pages/jogo/rank/rank.component';
import { RecomendadoComponent } from './pages/jogo/recomended/recomendado.component';
import { CategoryComponent } from './pages/geral/categoria/category.component';
import { AjudaComponent } from './pages/geral/ajuda/ajuda.component';
import { DiscoverComponent } from './pages/jogo/discover/discover.component';
import { ConfigComponent } from './pages/usuario/config/config.component';
import { LoginComponent } from './pages/usuario/login/login.component';
import { RegisterComponent } from './pages/usuario/register/register.component';
import { authGuard } from './guard/auth/auth.guard';
import { TestComponentsComponent } from './test/test-components/test-components.component';
import { AdminComponent } from './pages/usuario/admin/admin.component';


export const routes: Routes = [
  { path: '', component: HomeComponent, title: 'Home' },
  { path: 'perfil/:nomeUsuario', component: PerfilComponent, title: 'Perfil', canActivate: [authGuard] },
  { path: 'info/:nomeJogo', component: InfoGameComponent, title: 'Informações' },
  { path: 'rank', component: RankComponent, title: 'Ranking' },
  { path: 'recomendado', component: RecomendadoComponent, title: 'Recomendação', canActivate: [authGuard] },
  { path: 'categoria', component: CategoryComponent, title: 'Categoria' },
  { path: 'ajuda', component: AjudaComponent, title: 'Ajuda/FAQ' },
  { path: 'descoberta/:nomeJogo', component: DiscoverComponent, title: 'Descoberta' },
  { path: 'descoberta/:tipo/:nomeCategoria', component: DiscoverComponent, title: 'Descoberta' },
  { path: 'config/:nomeUsuario', component: ConfigComponent, title: ' ', canActivate: [authGuard] },
  { path: 'login', component: LoginComponent, title: 'Login' },
  { path: 'registro', component: RegisterComponent, title: 'Registro' },
  { path: 't3st3s', component: TestComponentsComponent, title: 'Testes'},
  { path: 'admin', component: AdminComponent, title: 'Administração'},
];