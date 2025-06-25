import { Routes } from '@angular/router';
import { PersonComponent } from './components/person/person';
import { PointComponent } from './components/point/point';
import { Home } from './homePage/home/home';
import { DonorListComponent } from './components/donor/donor';
import { DonationListComponent } from './components/blood-donations/blood-donations';
export const routes: Routes = [
    { path: 'persons', component: PersonComponent },
    { path: 'points', component: PointComponent },
    { path: 'donors', component: DonorListComponent },
    { path: 'blood-donations', component: DonationListComponent },
    { path: '', component: Home }

];
