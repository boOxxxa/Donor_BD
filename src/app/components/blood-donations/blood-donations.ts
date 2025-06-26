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
  newDonation : BloodDonation={
    id_donation:0,
    donation_date:'',
    id_point:{
      idPoint:0,
      city:'',
      address:'',
      phone:'',
      fioHeader:''
    },
    id_donor:{
      id_donor:0,
    id_person: {
      id_person: 0,
      fio: '',
      gender: ''
    },
    blood_type:'',
    rh_factor:''
    }

  }
  

  constructor(private bloodDonationService: BloodDonationService) {
    this.loadBloodDonations();
  }
  editMode: boolean = false;
  editDonation: BloodDonation | null = null;
  loadBloodDonations() {
    this.bloodDonationService.getAll().subscribe(data => {
      this.bloodDonations = data;
    });
  }

  addDonation() {
    this.bloodDonationService.create(this.newDonation).subscribe(() => {
      this.loadBloodDonations();
      {console.log(this.editDonation)}
      this.newDonation = { id_donation: 0, donation_date: '', id_point:{
        idPoint:0,
        city:'',
        address:'',
        phone:'',
        fioHeader:''
      }, id_donor:{
        id_donor:0,
      id_person: {
        id_person: 0,
        fio: '',
        gender: ''
      },
      blood_type:'',
      rh_factor:''
      } };
    });
  }
  startEdit(donation: BloodDonation) {
        this.editDonation = { ...donation };
        this.editMode = true;
      }
    
      saveEdit() {
        if (!this.editDonation) return;
        this.bloodDonationService.update(this.editDonation.id_donation, this.editDonation).subscribe(() => {
          this.loadBloodDonations()
          {console.log(this.editDonation)}
          this.editDonation = null;
          this.editMode = false;
        });
      }
  deleteDonation(id: number) {
    this.bloodDonationService.delete(id).subscribe(() => this.loadBloodDonations());
  }
  searchId: number = 0;
    foundDonation: BloodDonation | null = null;
     searchDonation() {
      this.bloodDonationService.getById(this.searchId).subscribe({
        next: (data) => this.foundDonation = data,
        error: () => this.foundDonation = null
      });
      }
}