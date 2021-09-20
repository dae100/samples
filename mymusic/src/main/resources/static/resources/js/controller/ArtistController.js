(function() {

    var app = angular.module("myMusic");
    
    // ArtistController
    var ArtistController = function($scope, $http, $filter, $q, artistService) {
    	$scope.artists = null;
    	$scope.errorMessage = "";
    	$scope.selectedArtist = null;
    	
    	$scope.modalSuccessMessage = null;
    	$scope.modalErrorMessage = null;
    	
    	// Sorting
    	$scope.sortType = "name" ; // set the default sort type
    	$scope.sortReverse = false;  // set the arrow direction 

    	$scope.sort = function(type, reverse) {
    		$scope.sortType = type;
    		$scope.sortReverse = reverse;
     	}
    	
    	// Get All Artists
        var getAllArtists = function(){
			artistService.getAllArtists().then(
					onGetAllArtistsSuccess,
					onGetAllArtistsError
			);
        };
        
        var onGetAllArtistsSuccess = function(result) 
        {
        	$scope.artists = result.data;
        }
        var onGetAllArtistsError = function(error)
        {
        	$scope.errorMessage = error;
        }
        
    	
    	// Edit Artist
        // Find the artist based on the id and set $scope.selectedArtist.
        // The UI will show the dialog to edit the Artist
    	$scope.editArtist = function(selectedId) {
    		$scope.selectedArtist = $filter('filter')($scope.artists, {id: selectedId})[0];
    	};
    	
    	
    	// Add Artist
    	$scope.addArtist = function() {
    		$scope.selectedArtist = null;
    	}
    	
    	// Call this when modal window is closed
    	$scope.closeModal = function() {
    		$scope.modalSuccessMessage = null;
        	$scope.modalErrorMessage = null;
    	}
    	
    	// Save Artist
    	$scope.saveArtist = function() {
    		$scope.modalSuccessMessage = null;
        	$scope.modalErrorMessage = null;
        	
    		if (!$scope.selectedArtist.id) {
    			artistService.createArtist($scope.selectedArtist)
    			.then(
    					onCreateArtistSuccess,
    					onCreateArtistError
    				);
    		} else {
    			artistService.saveArtist($scope.selectedArtist)
    			.then(
    					onSaveArtistSuccess,
    					onSaveArtistError
    				);
    		}
    	}
    	
        var onCreateArtistSuccess = function(result) {
        	$scope.selectedArtist = result.data;
        	$scope.artists.push($scope.selectedArtist);
        	$scope.modalSuccessMessage = "Saved.";
        }
    	
        var onCreateArtistError = function(error) {
        	console.error(error);
           	$scope.modalErrorMessage = "Error saving.";
        }
    	    	
        var onSaveArtistSuccess = function(result) {
        	$scope.modalSuccessMessage = "Saved.";
        }
    	
        var onSaveArtistError = function(error) {
        	console.error(error);
           	$scope.modalErrorMessage = "Error saving.";
        }
        
        
        // Delete Artist
    	$scope.deleteArtist = function() {
    		$scope.modalSuccessMessage = null;
    		$scope.modalErrorMessage = null;
            artistService.deleteArtist($scope.selectedArtist.id)
            .then(
        		onDeleteArtistSuccess,
        		onDeleteArtistError
        	);
            
    	}
    	
        var onDeleteArtistSuccess = function(result) {
        	var index = $scope.artists.indexOf($scope.selectedArtist);
        	$scope.artists.splice(index, 1);
        	$scope.selectedArtist = null;
        	$scope.modalSuccessMessage = "Deleted.";
        }
    	
    	var onDeleteArtistError = function(error) {
    		console.error(error);
    		$scope.modalErrorMessage = "Error deleting.";
    	}

        getAllArtists();
    };

    app.controller("ArtistController", ArtistController);
    

}());