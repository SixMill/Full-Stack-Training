import { BrowserModule }            from '@angular/platform-browser';
import { NgModule }                 from '@angular/core';
import { FormsModule }              from '@angular/forms';
import { HttpModule }               from '@angular/http';

import { AppComponent }             from './app.component';
import { ChatWindowComponent }      from './chat-window/chat-window.component';
import { Message }                  from './message/message.component';

import { MessageService }           from './message.service';

@NgModule({
  declarations: [
    AppComponent,
    ChatWindowComponent,
    Message
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule
  ],
  providers: [ MessageService ],
  bootstrap: [AppComponent]
})

export class AppModule { }
