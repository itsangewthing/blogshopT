import { Component, OnInit } from "@angular/core";
import { Product } from "src/app/common/product";
import { ProductService } from "src/app/common/product.service";



@Component({
    selector: 'app-product-list',
    templateUrl: './product-list.component.html',
    styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {
    //Called after the constructor, initializing input properties, and the first call to ngOnChanges.
    //Add 'implements OnInit' to the class.
    products: Product[] =[];
    
    constructor(private productService: ProductService){}

    ngOnInit(){
        this.listProducts();
     }


     //invoke method
    listProducts() {
        this.productService.getProductList().subscribe(
            data => {
                this.products = data;
            }
        )
    }

}