(function() {

    var app = angular.module("myMusic");
        
    var ProductController = function($scope, $http, $filter, productService, artistService, recordLabelService) {
    	
    	$scope.errorMessage = null;
    	$scope.products = null;
    	$scope.selectedProduct = null;
    	$scope.artistSelectionList = null;
    	$scope.recordLabelSelectionList = null;
    	
    	$scope.modalSuccessMessage = null;
    	$scope.modalErrorMessage = null;
    	
    	// Sorting
    	$scope.sortType = "title" ; // set the default sort type
    	$scope.sortReverse = false;  // set the arrow direction 
    	
    	$scope.sort = function(type, reverse) {
    		$scope.sortType = type;
    		$scope.sortReverse = reverse;
     	};
     	
    	// Call this when modal window is closed
     	$scope.closeModal = function() {
     		$scope.modalSuccessMessage = null;
     		$scope.modalErrorMessage = null;
     	};
    	
    	
    	// Get All Products
        var getAllProducts = function(){
        	productService.getAllProducts().then(
					onGetAllProductsSuccess,
					onGetAllProductsError
			);
        };
        
        var onGetAllProductsSuccess = function(result) 
        {
        	$scope.products = result.data;
        };
        
        var onGetAllProductsError = function(errResponse)
        {
        	$scope.errorMessage = errResponse.error;
        };
        
        
        // Get All Artists
        var getAllArtists = function() {
        	artistService.getAllArtists().then(
					onGetAllArtistsSuccess,
					onGetAllArtistsError
			);
        };
        
        var onGetAllArtistsSuccess = function(result) 
        {
        	$scope.artistSelectionList = result.data;
        };
        
        var onGetAllArtistsError = function(errResponse)
        {
        	$scope.errorMessage = errResponse.error;
        };
        
        
        // Get All RecordLabels
        var getAllRecordLabels = function(){
        	recordLabelService.getAllRecordLabels().then(
					onGetAllRecordLabelSuccess,
					onGetAllRecordLabelError
			);
        };
        
        var onGetAllRecordLabelSuccess = function(result) 
        {
        	$scope.recordLabelSelectionList = result.data;
        };
        
        var onGetAllRecordLabelError = function(errResponse)
        {
        	$scope.errorMessage = errResponse.error;
        };
        
        
    	// Add Product
    	$scope.addProduct = function() {
    		$scope.selectedProduct = null;
    	}
        
    	// Edit Product 
    	$scope.editProduct = function(selectedId) {
    		$scope.selectedProduct = $filter('filter')($scope.products, {id: selectedId})[0];
    	};
    	
    	// Save Product
    	$scope.saveProduct = function() {
    		$scope.modalSuccessMessage = null;
    		$scope.modalErrorMessage = null;
    		if (!$scope.selectedProduct.id) {
    			productService.createProduct($scope.selectedProduct)
    			.then(
    					onCreateProductSuccess,
    					onCreateProductError
    				);
    		} else {
    			productService.saveProduct($scope.selectedProduct)
    			.then(
    					onSaveProductSuccess,
    					onSaveProductError
    				);
    		}
    	}
    	
        var onCreateProductSuccess = function(result) {
        	$scope.selectedProduct = result.data;
        	$scope.products.push($scope.selectedProduct);
        	$scope.modalSuccessMessage = "Saved.";
        }
    	
        var onCreateProductError = function(errResponse) {
        	console.log(JSON.stringify(errResponse));
        	$scope.modalErrorMessage = "Error saving";
        }
    	    	
        var onSaveProductSuccess = function(result) {
        	$scope.modalSuccessMessage = "Saved.";
        }
    	
        var onSaveProductError = function(errResponse) {
        	console.log(JSON.stringify(errResponse));
        	$scope.modalErrorMessage = "Error saving";
        }
        
        // Delete Product
    	$scope.deleteProduct = function() {
    		$scope.modalSuccessMessage = null;
    		$scope.modalErrorMessage = null;
    		alert($scope.selectedProduct.id);
            productService.deleteProduct($scope.selectedProduct.id)
            .then(
        		onDeleteProductSuccess,
        		onDeleteProductError
        	);
            
    	}
    	
        var onDeleteProductSuccess = function(result) {
        	$scope.modalSuccessMessage = "Deleted.";
        	var index = $scope.products.indexOf($scope.selectedProduct);
        	$scope.products.splice(index, 1);
        	$scope.selectedProduct = null;
        }
    	
    	var onDeleteProductError = function(errResponse) {
    		$scope.modalErrorMessage = "Error deleting.";
    	}
        
        getAllProducts();
        getAllArtists();
        getAllRecordLabels();
    };

    app.controller("ProductController", ProductController);
    

}());