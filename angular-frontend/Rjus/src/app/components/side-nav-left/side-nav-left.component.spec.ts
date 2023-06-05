import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SideNavLeftComponent } from './side-nav-left.component';

describe('SideNavLeftComponent', () => {
  let component: SideNavLeftComponent;
  let fixture: ComponentFixture<SideNavLeftComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SideNavLeftComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SideNavLeftComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
