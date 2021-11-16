
#Author: omarguzman73@gmail.com

@BuscarProductos
Feature: Buscar y seleccionar un producto en la pagina de Falabella


   @SeleccionarProducto
  Scenario Outline: Ingresar a la pagina de falabella, buscar un un producto y agregarlo a la bolsa
    Given Ingresar a la pagina web de Falabella "<url>"
    And Buscar producto "<txtProducBuscar>"
    And Seleccionar producto "<txtProducSeleccionar>"
    When Agregar producto a la bolsa
    And Seleccionar seguro para el producto
    And Ver bolsa de compras
    Then Verificar resumen de la orden
    And Salir de la pagina
    
     Examples: 
      | url                          						  | txtProducBuscar  | txtProducSeleccionar  |
      | https://www.falabella.com.co/falabella-co | iphone 13        | iPhone 13 Pro 256     | 
     
    