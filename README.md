                                                                          Gestión de tienda de productos electrónicos

Se necesita crear un sistema de gestión para una tienda vendedora de productos electrónicos. La tienda cuenta con los siguientes productos: Televisores, Computadoras, y Teléfonos. 
La tienda además cuenta con un registro de clientes. Todos los clientes cuentan con un DNI y nombre. Se requiere reconocer la lista de los productos comprados de cada cliente, 
y saber si tienen productos a comprar en su carrito. El cliente debe ser capaz de vaciar su carrito si lo desea. Los productos tienen un código de producto, un nombre, y el precio. 
Cada producto tiene una posibilidad de ser enviado o no, si cuenta con un envío se le sumara al precio del dicho producto. 
Todos los productos cuentan con una marca única entre sí, pero para aquellos que no sean nacionales se le sumara a su precio un impuesto. 
Mientras más reconocida sea la marca, más impuesto va a tener. Las marcas nacionales contaran solo con un 10% de impuesto sobre el precio. Si se requiere hacer un envío de un teléfono, el precio será de 200$. 
Para el televisor, el precio será de $500, y para una computadora, será de $800. 
Se debe ser capaz de agregar clientes, si se intenta agregar un cliente que ya se encuentra en la tienda, debe lanzarse la excepción ClienteRepetido(),
y también se necesita agregar productos en la tienda. Al cobrar un cliente, debe estar registrado en la tienda y debe poseer productos en su carrito, 
caso contrario deben lanzarse las excepciones ClienteNoEncontrado() o NoHayProductosEnElCarrito() respectivamente y no debe ser capaz de comprar. 
Si todo lo anterior se valida, se agrega el producto a la lista de productos comprados del cliente. La tienda tiene que ser capaz de buscar clientes por su nombre y saber los productos que contiene. 
Como requerimiento extra, las tienda nos pide encontrar al cliente con mayor cantidad de productos comprados y conseguir al cliente que haya gastado más.

Generar los siguientes tests para verificar la funcionalidad del sistema:
•	QueSePuedaAgregarUnClienteALaTienda()
•	QueElClientePuedaAgregarUnProductoAlCarrito()
•	QueSePuedaEncontrarUnClienteBuscado()
•	QueSePuedaAgregarUnProductoAlStockDeLaTienda()
•	QueSePuedaCobrarAUnCliente()
•	QueNoSePuedaCobrarAUnClientesSiNoExisteEnLaTienda()
•	QueSiElCarritoEstaVacioCuandoSeCobreSeLanceLaExcepcion()
•	QueSiNoSeEncuentraElClienteACobrarSeLanceLaExcepcion()
•	QueSiSeIntentaAgregarUnClienteRepetidoSeLanceExcepcion()
•	QueSeEncuentreAlClienteQueHayaCompradoMásProductos()
•	QueSeEncuentreAlClienteQueHayaGastadoMás()
