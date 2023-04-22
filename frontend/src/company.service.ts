import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import { CompanyData } from "./company-data.interface";

@Injectable({
  providedIn: "root",
})
export class CompanyService {
  private apiUrl = "http://localhost:8080/company/getCompanies";

  constructor(private http: HttpClient) {}

  getCompanies(): Observable<CompanyData[]> {
    return this.http.get<CompanyData[]>(this.apiUrl);
  }
}
