import { Routes } from '@angular/router';
import { HomeComponent } from './pages/general/home/home.component';
import { PerfilComponent } from './pages/user/perfil/perfil.component';
import { InfoGameComponent } from './pages/game/info-game/info-game.component';
import { RankComponent } from './pages/game/rank/rank.component';
import { AdminComponent } from './pages/user/admin/admin.component';
import { RecomendedComponent } from './pages/game/recomended/recomended.component';
import { CategoryComponent } from './pages/general/category/category.component';
import { HelpComponent } from './pages/general/help/help.component';
import { DiscoverComponent } from './pages/game/discover/discover.component';
import { ConfigComponent } from './pages/user/config/config.component';
import { LoginComponent } from './pages/user/login/login.component';
import { RegisterComponent } from './pages/user/register/register.component';
import { authGuard } from './guard/auth/auth.guard';


export const routes: Routes = [
  { path: '', component: HomeComponent, title: 'Home' },
  { path: 'perfil/:nomeUsuario', component: PerfilComponent, title: 'Perfil', canActivate: [authGuard]},
  { path: 'info/:nomeJogo', component: InfoGameComponent, title: 'Informações' },
  { path: 'rank', component: RankComponent, title: 'Ranking' },
  { path: 'admin', component: AdminComponent, title: 'Administração' },
  { path: 'recomendado', component: RecomendedComponent, title: 'Recomendação' },
  { path: 'categoria', component: CategoryComponent, title: 'Categoria' },
  { path: 'ajuda', component: HelpComponent, title: 'Ajuda/FAQ' },
  { path: 'descoberta', component: DiscoverComponent, title: 'Descoberta' },
  { path: 'config/:nomeUsuario', component: ConfigComponent, title: 'Configuração', canActivate: [authGuard] },
  { path: 'login', component: LoginComponent, title: 'Login' },
  { path: 'registro', component: RegisterComponent, title: 'Registro' },
];