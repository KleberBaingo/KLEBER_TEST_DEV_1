import { Component, OnInit } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { CompanyService } from "../company.service";
import { CompanyData } from "src/company-data.interface";

@Component({
  selector: "app-get-companies-button",
  template: `
    <div class="container">
      <button class="center-btn" (click)="getCompanies()">Get Companies</button>
      <div *ngFor="let item of companiesWithStdDev">
        <h2>Company Name:{{ item.company.name }}</h2>
        <h3>Segment:{{ item.company.segment }}</h3>
        <p>Standard Deviation => {{ item.stdDev }}</p>
      </div>
    </div>
  `,
  styleUrls: ["./get-companies-button.component.css"],
})
export class CompanyComponent implements OnInit {
  companiesWithStdDev: CompanyData[];
  constructor(private companyService: CompanyService) {}
  ngOnInit(): void {}
  getCompanies(): void {
    this.companyService.getCompanies().subscribe((data) => {
      this.companiesWithStdDev = data;
    });
  }
}
