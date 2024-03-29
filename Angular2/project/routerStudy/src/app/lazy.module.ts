import { NgModule }      from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { LuxuryComponent } from './Component/LuxuryComponent';

@NgModule({
	imports : [CommonModule,
		RouterModule.forChild([
			{ path : '', component : LuxuryComponent }
		])],
	declarations : [LuxuryComponent]
})

export default class LuxuryModule {}