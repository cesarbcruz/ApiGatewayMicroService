import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Http, ResponseContentType } from "@angular/http";
import * as FileSaver from 'file-saver';



import { ArticleListConfig, TagsService, UserService } from '../core';

@Component({
  selector: 'app-home-page',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  constructor(
    private router: Router,
    private tagsService: TagsService,
    private userService: UserService,
    private http: Http
  ) {}

  isAuthenticated: boolean;
  listConfig: ArticleListConfig = {
    type: 'all',
    filters: {}
  };
  tags: Array<string> = [];
  tagsLoaded = false;

  ngOnInit() {
    this.userService.isAuthenticated.subscribe(
      (authenticated) => {
        this.isAuthenticated = authenticated;

        // set the article list accordingly
        if (authenticated) {
          this.setListTo('feed');
        } else {
          this.setListTo('all');
        }
      }
    );

    this.tagsService.getAll()
    .subscribe(tags => {
      this.tags = tags;
      this.tagsLoaded = true;
    });
  }

  setListTo(type: string = '', filters: Object = {}) {
    // If feed is requested but user is not authenticated, redirect to login
    if (type === 'feed' && !this.isAuthenticated) {
      this.router.navigateByUrl('/login');
      return;
    }

    // Otherwise, set the list object
    this.listConfig = {type: type, filters: filters};
  }

  public download(event) {
    this.http.post("http://172.16.50.169:8082/api/catalogo/download", {}, {responseType: ResponseContentType.Blob})
      .subscribe((response) => {
        if (response && response.blob() && response.blob().size > 0) {
          var contentDisposition = response.headers.get('Content-Disposition');
          let fileName = this.getNameFile(response);
          FileSaver.saveAs(response.blob(), fileName);
        }
        else {
          return null;
        }
      });
  }

  getNameFile(response){
    var contentDisposition = response.headers.get('Content-Disposition');
    if(contentDisposition){
        return contentDisposition.split('filename=')[1].trim()
    }else{
        return "Download";
    }
  }
}
