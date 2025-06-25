import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { BloodDonation, BloodDonationService } from '../../services/bloodDonation';

@Component({
  selector: 'app-blood-donations',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './blood-donations.html'
})
export class DonationListComponent {
  bloodDonations: BloodDonation[] = [];
  

  constructor(private bloodDonationService: BloodDonationService) {
    this.loadBloodDonations();
  }
  loadBloodDonations() {
    this.bloodDonationService.getAll().subscribe(data => {
      this.bloodDonations = data;
    });
  }

  /*addDonor() {
    this.donorService.create(this.newDonor).subscribe(() => {
      this.loadDonors();
      this.newDonor = { id_donor: 0, id_person: '', blood_type: '', rh_factor: '', };
    });
  }*/

  deleteDonor(id: number) {
    this.bloodDonationService.delete(id).subscribe(() => this.loadBloodDonations());
  }
}