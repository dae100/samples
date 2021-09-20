(function(){
	
	var app = angular.module("myMusic");
	
	var ArtistService = function($http, $q){
		
		// Get All Artists
		var getAllArtists = function(){
			
			return $http.get("rest/getAllArtists")
            .then(
                  function(response){
                  	return response;
                  }, 
                  function(errResponse){
		                console.error("Error while fetching artists");
		                return $q.reject(errResponse);
                  }
              );
		};
		
		// Get Artist
		var getArtist = function(id) {
			return $http.get("rest/artist/" + id)
				.then(
				  function(response){
                  	return response;
                  }, 
                  function(errResponse){
		                console.error("Error while fetching artists");
		                return $q.reject(errResponse);
                  }
			);
		};
		
		// Create Artist
		var createArtist = function(artist) {
			return $http.post("rest/createArtist", artist)
				.then(
					function(response){
						return response;
					}, 
					function(errResponse){
		                console.error("Error while creating artist");
		                return $q.reject(errResponse);
					}
			);
		
		}
		// Save Artist
		var saveArtist = function(artist) {			
			return $http.put("rest/saveArtist", artist)
			.then(
				function(response){
					return response;
				}, 
				function(errResponse){
	                console.error("Error while saving artist");
	                return $q.reject(errResponse);
				}
			);			
		};
		
		
		// Delete Artist
		var deleteArtist = function(id) {
			return $http({url: "rest/deleteArtist/" + id, method: "DELETE", })
			.then(
				function(response){
					return response;
				}, 
				function(errResponse){
	                console.error("Error while deleting artist");
	                return $q.reject(errResponse);
				}
			);
		}
		
		return {
			getAllArtists : getAllArtists,
			getArtist : getArtist,
			createArtist : createArtist,
			saveArtist : saveArtist,
			deleteArtist : deleteArtist
		};
		
    };
    
    app.factory("artistService", ArtistService);
    
}());