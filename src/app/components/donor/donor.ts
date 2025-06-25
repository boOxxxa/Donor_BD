import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Donor, DonorService } from '../../services/donor.service';

@Component({
  selector: 'app-donor',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './donor.html'
})
export class DonorListComponent {
  donors: Donor[] = [];
  

  constructor(private donorService: DonorService) {
    this.loadDonors();
  }

  loadDonors() {
    this.donorService.getAll().subscribe(data => this.donors = data);
  }

  /*addDonor() {
    this.donorService.create(this.newDonor).subscribe(() => {
      this.loadDonors();
      this.newDonor = { id_donor: 0, id_person: '', blood_type: '', rh_factor: '', };
    });
  }*/

  deleteDonor(id: number) {
    this.donorService.delete(id).subscribe(() => this.loadDonors());
  }
}