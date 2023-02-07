import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {RouterModule, Routes} from '@angular/router';
import {ProductsComponent} from './products/products.component';
import {CustomersComponent} from './customers/customers.component';
import {OrdersComponent} from "./orders/orders.component";
import {OrderDetailsComponent} from "./order-details/order-details.component";


// @ts-ignore
// @ts-ignore
const routes: Routes = [

  {path: 'products', component: ProductsComponent },
  {path: 'customers', component: CustomersComponent},
  {path: 'orders/:customerId', component: OrdersComponent},
  {path: 'order-details/:orderId', component: OrderDetailsComponent}
]

@NgModule({
  declarations: [],
  imports: [
    CommonModule,
  RouterModule.forRoot(
      routes,
      { enableTracing: true } // <-- debugging purposes only
    )
  ]
})
export class AppRoutingModule {
}
