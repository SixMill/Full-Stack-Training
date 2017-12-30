import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { Message } from './message.component';

describe('MessageComponent', () => {
  let component: Message;
  let fixture: ComponentFixture<Message>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ Message ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(Message);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
