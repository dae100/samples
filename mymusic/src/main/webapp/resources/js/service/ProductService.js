	var app = angular.module("myMusic");
	
	var ProductService = function($http, $q){
		
		// Get All Products
		var getAllProducts = function(){
			
			return $http.get("rest/getAllProducts")
            .then(
                  function(response){
                  	return response;
                  }, 
                  function(errResponse){
		                console.error("Error while fetching products");
		                return $q.reject(errResponse);
                  }
              );
		};
		
		// Get Product
		var getProduct = function(id) {
			return $http.get("rest/product/" + id)
				.then(
				  function(response){
                  	return response;
                  }, 
                  function(errResponse){
		                console.error("Error while fetching product");
		                return $q.reject(errResponse);
                  }
			);
		};
		
		// Create Product
		var createProduct = function(product) {
			return $http.post("rest/createProduct", product)
				.then(
					function(response){
						return response;
					}, 
					function(errResponse){
		                console.error("Error while creating product");
		                return $q.reject(errResponse);
					}
			);
		
		}
		// Save Product
		var saveProduct = function(product) {			
			return $http.put("rest/saveProduct", product)
			.then(
				function(response){
					return response;
				}, 
				function(errResponse){
	                console.error("Error while saving product");
	                return $q.reject(errResponse);
				}
			);			
		};
		
		
		// Delete Product
		var deleteProduct = function(id) {
			return $http({url: "rest/deleteProduct/" + id, method: "DELETE", })
			.then(
				function(response){
					return response;
				}, 
				function(errResponse){
	                console.error("Error while deleting product");
	                return $q.reject(errResponse);
				}
			);
		}
		
		return {
			getAllProducts : getAllProducts,
			getProduct : getProduct,
			createProduct : createProduct,
			saveProduct : saveProduct,
			deleteProduct : deleteProduct
		};
		
    };
    
    app.factory("productService", ProductService);