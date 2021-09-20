(function() {

    var app = angular.module("myMusic");
        
    var RecordLabelController = function($scope, $http, $filter, recordLabelService) {
    	$scope.recordLabels = null;
    	$scope.errorMessage = "";
    	$scope.selectedRecordLabel = null;
    	
    	$scope.modalSuccessMessage = null;
    	$scope.modalErrorMessage = null;
    	
    	// Sorting
    	$scope.sortType = "name" ; // set the default sort type
    	$scope.sortReverse = false;  // set the arrow direction 

    	$scope.sort = function(type, reverse) {
    		$scope.sortType = type;
    		$scope.sortReverse = reverse;
     	}
    	
    	// Call this when the modal window is closed
     	$scope.closeModal = function() {
     		$scope.modalSuccessMessage = null;
     		$scope.modalErrorMessage = null;
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
        	$scope.recordLabels = result.data;
        }
        var onGetAllRecordLabelError = function(error)
        {
        	$scope.errorMessage = error;
        }
        
    	
    	// Edit RecordLabel
        // Find the record label based on the id and set $scope.selectedRecordLabel.
        // The UI will show the dialog to edit the RecordLabel
    	$scope.editRecordLabel = function(selectedId) {
    		$scope.selectedRecordLabel = $filter('filter')($scope.recordLabels, {id: selectedId})[0];
    	};
    	
    	
    	// Add RecordLabel
    	$scope.addRecordLabel = function() {
    		$scope.selectedRecordLabel = null;
    	}
    	
    	// Save RecordLabel
    	$scope.saveRecordLabel = function() {
        	$scope.modalSuccessMessage = null;
        	$scope.modalErrorMessage = null;
        	
    		if (!$scope.selectedRecordLabel.id) {
    			recordLabelService.createRecordLabel($scope.selectedRecordLabel)
    			.then(
    					onCreateRecordLabelSuccess,
    					onCreateRecordLabelError
    				);
    		} else {
    			recordLabelService.saveRecordLabel($scope.selectedRecordLabel)
    			.then(
    					onSaveRecordLabelSuccess,
    					onSaveRecordLabelError
    				);
    		}
    	}
    	
        var onCreateRecordLabelSuccess = function(result) {
        	$scope.selectedRecordLabel = result.data;
        	$scope.recordLabels.push($scope.selectedRecordLabel);
        	$scope.modalSuccessMessage = "Saved.";
        }
    	
        var onCreateRecordLabelError = function(error) {
        	console.error(error);
        	$scope.modalErrorMessage = "Error saving.";
        }
    	    	
        var onSaveRecordLabelSuccess = function(result) {
        	$scope.modalSuccessMessage = "Saved.";
        }
    	
        var onSaveRecordLabelError = function(error) {
        	console.error(error);
        	$scope.modalErrorMessage = "Error saving.";
        }
        
        
        // Delete RecordLabel
    	$scope.deleteRecordLabel = function() {
        	$scope.modalSuccessMessage = null;
        	$scope.modalErrorMessage = null;
        	
    		recordLabelService.deleteRecordLabel($scope.selectedRecordLabel.id)
            .then(
        		onDeleteRecordLabelSuccess,
        		onDeleteRecordLabelError
        	);
            
    	}
    	
        var onDeleteRecordLabelSuccess = function(result) {
        	var index = $scope.recordLabels.indexOf($scope.selectedRecordLabel);
        	$scope.recordLabels.splice(index, 1);
        	$scope.selectedRecordLabel = null;
        	$scope.modalSuccessMessage = "Deleted.";
        }
    	
    	var onDeleteRecordLabelError = function(error) {
    		console.error(error);
        	$scope.modalErrorMessage = "Error deleting.";
    	}

        getAllRecordLabels();
    	
    };

    app.controller("RecordLabelController", RecordLabelController);
    

}());