import { Routes } from '@angular/router';
import { PersonComponent } from './components/person/person';
import { PointComponent } from './components/point/point';
export const routes: Routes = [
    { path: 'persons', component: PersonComponent },
    { path: 'points', component: PointComponent },
    { path: '', redirectTo: '/persons', pathMatch: 'full' }
];
