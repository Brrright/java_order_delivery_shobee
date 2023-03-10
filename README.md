# java_order_delivery_shobee
AUTHOR: CHIAH MING LIANG TP061801, CHAN HONG WEI TP060647

SHOBEE is an online order and delivery management system that created for our assignment (OODJ - Asia Pacific University)
This system consists of 4 roles which are: guest, customer, delivery staff, and admin.

## Main requirement:
### 1. Admin will be able to:
- manage admin and staff account
- edit all user profile
- manage product and category
- assign order to delivery staff
- search user order and payment
- view sales and staff performance report


### 2. Delivery staff will be able to:
- pick up order (update order status to deliverying)
- update order status to delivered
- receive feedback from customer
- edit and view their own profile

### 3. Customer (registered member))
- view and search product by name and category
- add item to cart
- remove item from cart
- checkout
- view order according to their status
- view and edit their own profile

## What's special for our program?
### Backend side
- we have implemented singleton design pattern (first try xD), for handling front end request and return the wanted objects.
 -'Services' - we have a lot of services such as AddressService, MemberService, OrderService, DeliveryService... to serve front end with backend object
 - in Services, it handle converting text file content to usable objects and vice versa.
 - all service will have only 1 instance

### Frontend side
- in our system, we will only have a frame with several panels, routing to pages will only replace the panels, which makes the user experience better.
- 99% of the UI is self created.
