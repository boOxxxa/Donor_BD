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
  newDonor: Donor = {
    id_donor:0,
    id_person: {
      id_person: 0,
      fio: '',
      gender: ''
    },
    blood_type:'',
    rh_factor:''
  }

  constructor(private donorService: DonorService) {
    this.loadDonors();
  }
  editMode: boolean = false;
  editDonor: Donor | null = null;
  loadDonors() {
    this.donorService.getAll().subscribe(data => this.donors = data);
  }

  addDonor() {
    this.donorService.create(this.newDonor).subscribe(() => {
      this.loadDonors();
      this.newDonor = { id_donor: 0, 
        id_person: {
          id_person: 0,
          fio: '',
          gender: ''
        },
         blood_type: '',
          rh_factor: '', };
    });
  }
   startEdit(donor: Donor) {
      this.editDonor = { ...donor };
      this.editMode = true;
    }
  
    saveEdit() {
      if (!this.editDonor) return;
      this.donorService.update(this.editDonor.id_donor, this.editDonor).subscribe(() => {
        this.loadDonors()
        {console.log(this.editDonor)}
        this.editDonor = null;
        this.editMode = false;
      });
    }
  deleteDonor(id: number) {
    this.donorService.delete(id).subscribe(() => this.loadDonors());
  }
  searchId: number = 0;
  foundDonor: Donor | null = null;
   searchPerson() {
    this.donorService.getById(this.searchId).subscribe({
      next: (data) => this.foundDonor = data,
      error: () => this.foundDonor = null
    });
    }
}