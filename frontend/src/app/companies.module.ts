import { NgModule } from "@angular/core";
import { CommonModule } from "@angular/common";
import { HttpClientModule } from "@angular/common/http";
import { CompanyService } from "../company.service";

@NgModule({
  declarations: [],
  imports: [CommonModule, HttpClientModule],
  providers: [CompanyService],
})
export class CompaniesModule {}
