(function(){
	
	var app = angular.module("myMusic");
	
	var RecordLabelService = function($http, $q){
		
		// Get All RecordLabels
		var getAllRecordLabels = function(){
			
			return $http.get("rest/getAllRecordLabels")
            .then(
                  function(response){
                  	return response;
                  }, 
                  function(errResponse){
		                console.error("Error while fetching recordLabels");
		                return $q.reject(errResponse);
                  }
              );
		};
		
		// Get RecordLabel
		var getRecordLabel = function(id) {
			return $http.get("rest/recordLabel/" + id)
				.then(
				  function(response){
                  	return response;
                  }, 
                  function(errResponse){
		                console.error("Error while fetching recordLabels");
		                return $q.reject(errResponse);
                  }
			);
		};
		
		// Create RecordLabel
		var createRecordLabel = function(recordLabel) {
			return $http.post("rest/createRecordLabel", recordLabel)
				.then(
					function(response){
						return response;
					}, 
					function(errResponse){
		                console.error("Error while creating recordLabel");
		                return $q.reject(errResponse);
					}
			);
		
		}
		// Save RecordLabel
		var saveRecordLabel = function(recordLabel) {			
			return $http.put("rest/saveRecordLabel", recordLabel)
			.then(
				function(response){
					return response;
				}, 
				function(errResponse){
	                console.error("Error while saving recordLabel");
	                return $q.reject(errResponse);
				}
			);			
		};
		
		
		// Delete RecordLabel
		var deleteRecordLabel = function(id) {
			return $http({url: "rest/deleteRecordLabel/" + id, method: "DELETE", })
			.then(
				function(response){
					return response;
				}, 
				function(errResponse){
	                console.error("Error while deleting recordLabel");
	                return $q.reject(errResponse);
				}
			);
		}
		
		return {
			getAllRecordLabels : getAllRecordLabels,
			getRecordLabel : getRecordLabel,
			createRecordLabel : createRecordLabel,
			saveRecordLabel : saveRecordLabel,
			deleteRecordLabel : deleteRecordLabel
		};
		
    };
    
    app.factory("recordLabelService", RecordLabelService);
    
}());