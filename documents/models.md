## Model

###### product

```
Product {
	id : int // Pk , Auto Increment
	name : String // Not null
	category : String // Not null
	price : int // Min = 0 
	manufacturer : String // Not null
	unitInStock : int // Min = 0
	description : String 
	productImage : MultipartFile // @Transient , DB에는 저장x
	imageFilename : String // 이미지의 파일 경로명
}
```



###### User

```
User {
	id : int // Pk , Auto Increment
	username : String // Not null
	password : String // Not null
	email : String // Not null
	shippingAddress : ShippingAddress // 1:1관계
	cart : Cart // 1:1관계
	enabled : boolean 
	authority : String
}
```



###### ShippingAddress

```
ShippingAddress {
	id : int // Pk , Auto Increment
	address : String
	country : String
	zipCode : String
}
```



###### Cart

```
Cart {
	id : int // Pk , Auto Increment
	cartItems : List<CartItem> // 1:N 관계
}
```



###### CartItem

```
CartItem {
	id : int //Pk , Auto Increment
	cart : Cart // N:1관계 , @JsonIgnore
	product : Product // N:1관계
	quantity : int
	totalPrice : double
}
```

