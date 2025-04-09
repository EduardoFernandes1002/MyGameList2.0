import { Routes } from '@angular/router';
import { HomeComponent } from './pages/home/home.component';
import { PerfilComponent } from './pages/perfil/perfil.component';
import { InfoGameComponent } from './pages/info-game/info-game.component';
import { RankComponent } from './pages/rank/rank.component';
import { AdminComponent } from './pages/admin/admin.component';
import { RecomendedComponent } from './pages/recomended/recomended.component';
import { CategoryComponent } from './pages/category/category.component';
import { HelpComponent } from './pages/help/help.component';
import { DiscoverComponent } from './pages/discover/discover.component';
import { ConfigComponent } from './pages/config/config.component';
import { LoginComponent } from './pages/login/login.component';
import { RegisterComponent } from './pages/register/register.component';


export const routes: Routes = [
  { path: '', component: HomeComponent, title: 'Home' },
  { path: 'perfil', component: PerfilComponent, title: 'Perfil' },
  { path: 'info/:nomeJogo', component: InfoGameComponent, title: 'Informações' },
  { path: 'rank', component: RankComponent, title: 'Ranking' },
  { path: 'admin', component: AdminComponent, title: 'Administração' },
  { path: 'recomendado', component: RecomendedComponent, title: 'Recomendação' },
  { path: 'categoria', component: CategoryComponent, title: 'Categoria' },
  { path: 'ajuda', component: HelpComponent, title: 'Ajuda/FAQ' },
  { path: 'descoberta', component: DiscoverComponent, title: 'Descoberta' },
  { path: 'config', component: ConfigComponent, title: 'Configuração' },
  { path: 'login', component: LoginComponent, title: 'Login' },
  { path: 'registro', component: RegisterComponent, title: 'Registro' }
];