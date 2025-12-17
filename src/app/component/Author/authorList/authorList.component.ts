import { Component, OnInit } from '@angular/core';
import { AuthorDTO } from '../../../author.model';
import { AuthorService } from 'src/app/Service/author.service';


@Component({
  selector: 'app-author-list',
  templateUrl: './authorList.component.html',
  styleUrls: ['./authorList.component.css']
})
export class AuthorListComponent implements OnInit {
  author : AuthorDTO[]=[];

  constructor(private authorService : AuthorService) { }

   ngOnInit():void{
    this.authorService.getAllAuthors().subscribe({
      next : (data)=>{
        this.author=data;
        console.log(this.author);
      },
      error : (err)=>{
        console.error(err);
      }
    });

}
}
